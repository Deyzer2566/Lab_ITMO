def fromArrayToXML(l:list,lvl:int):
    ret=''
    for k,j in enumerate(l):
        ret += ' '*lvl+'<elem'+str(k)+'>'
        if type(j) is list:
            ret += '\n'+fromArrayToXML(j,lvl+1)+'\n'+' '*lvl
        elif type(j) is dict:
            ret += '\n'+toXML(j,lvl+1)+'\n'+' '*lvl
        else:
            ret += str(j)
        ret += '</elem'+str(k)+'>' + '\n'
    return ret

def toXML(s:dict,lvl:int):
    ret=''
    for key,value in s.items():
        ret += ' '*lvl+'<'+key+'>'
        if type(value) is dict:
            ret += '\n'+toXML(value,lvl+1)+'\n'+' '*lvl
        elif type(value) is list:
            ret += '\n'+fromArrayToXML(value,lvl+1)+'\n'+' '*lvl
        else:
            ret += value
        ret += '</' + key + '>'+'\n'
    return ret
    
import json,xmltodict

import re

def sequence(*funcs):
    if len(funcs) == 0:
        def result(src):
            yield (), src
        return result
    def result(src):
        for arg1, src in funcs[0](src):
            for others, src in sequence(*funcs[1:])(src):
                yield (arg1,) + others, src
    return result

number_regex = re.compile(r"(-?(?:0|[1-9]\d*)(?:\.\d+)?(?:[eE][+-]?\d+)?)\s*(.*)", re.DOTALL)

def parse_number(src):
    match = number_regex.match(src)
    if match is not None:
        number, src = match.groups()
        yield eval(number), src

string_regex = re.compile(r"(\"(?:[^\\\"]|\\[\"\\/bfnrt]|\\u[0-9a-fA-F]{4})*?\")\s*(.*)", re.DOTALL)

def parse_string(src):
    match = string_regex.match(src)
    if match is not None:
        string, src = match.groups()
        yield eval(string), src

def parse_word(word, value=None):
    l = len(word)
    def result(src):
        if src.startswith(word):
            yield value, src[l:].lstrip()
    result.__name__ = "parse_%s" % word
    return result

parse_true = parse_word("true", True)
parse_false = parse_word("false", False)
parse_null = parse_word("null", None)

def parse_value(src):
    for match in (
        list(parse_string(src))+
        list(parse_number(src))+
        list(parse_array(src))+
        list(parse_object(src))+
        list(parse_true(src))+
        list(parse_false(src))+
        list(parse_null(src))
    ):
        yield match
        return

parse_left_square_bracket = parse_word("[")
parse_right_square_bracket = parse_word("]")
parse_empty_array = sequence(parse_left_square_bracket, parse_right_square_bracket)

def parse_array(src):
    for _, src in parse_empty_array(src):
        yield [], src
        return

    for (_, items, _), src in sequence(
        parse_left_square_bracket,
        parse_comma_separated_values,
        parse_right_square_bracket,
    )(src):
        yield items, src

parse_comma = parse_word(",")

def parse_comma_separated_values(src):
    for (value, _, values), src in sequence(
        parse_value,
        parse_comma,
        parse_comma_separated_values
    )(src):
        yield [value] + values, src
        return

    for value, src in parse_value(src):
        yield [value], src

parse_left_curly_bracket = parse_word("{")
parse_right_curly_bracket = parse_word("}")
parse_empty_object = sequence(parse_left_curly_bracket, parse_right_curly_bracket)

def parse_object(src):
    for _, src in parse_empty_object(src):
        yield {}, src
        return
    for (_, items, _), src in sequence(
        parse_left_curly_bracket,
        parse_comma_separated_keyvalues,
        parse_right_curly_bracket,
    )(src):
        yield items, src

parse_colon = parse_word(":")

def parse_keyvalue(src):
    for (key, _, value), src in sequence(
        parse_string,
        parse_colon,
        parse_value
    )(src):
        yield {key: value}, src

def parse_comma_separated_keyvalues(src):
    for (keyvalue, _, keyvalues), src in sequence(
        parse_keyvalue,
        parse_comma,
        parse_comma_separated_keyvalues,
    )(src):
        keyvalue.update(keyvalues)
        yield keyvalue, src
        return

    for keyvalue, src in parse_keyvalue(src):
        yield keyvalue, src

def parse(s):
    s = s.strip()
    match = list(parse_value(s))
    if len(match) != 1:
        raise ValueError("not a valid JSON string")
    result, src = match[0]
    if src.strip():
        raise ValueError("not a valid JSON string")
    return result

import time

if __name__=='__main__':
    t = time.time()
    with open("расписание.json",encoding='utf-8') as f:
      s = f.read()
    in_str=False
    s=list(s)
    offset=0
    l = len(s)
    for j in range(l):
        if s[j-offset] == '"' and s[j-offset-1] != '\\':
            in_str ^= True
        if s[j-offset] in [' ','\t','\n'] and not in_str:
            del s[j-offset]
            offset+=1
    s=''.join(s)
    #s = parseObject(s[1:])
    s=eval(s)
    s=toXML(s,0)
    #print(s)
    with open('расписание.xml','w') as f:
      f.write(s)
    print('my:',time.time()-t)
    t=time.time()
    with open('расписание.json',encoding='utf-8') as f:
        s = json.loads(f.read())
    # print(s['lessons'][1]['week-num'])
    s = {'root':s}
    with open("расписание.xml", "w",encoding='utf-8') as outf:
        s = xmltodict.unparse(s, pretty=True)
        outf.write(s)
    print('other:',time.time()-t)
    t = time.time()
    with open('расписание.json',encoding='UTF-8') as f:
        s=parse(f.read())
    with open("расписание.xml", "w",encoding='utf-8') as outf:
        s = xmltodict.unparse(s, pretty=True)
        outf.write(s)
    print('regex:',time.time()-t)
