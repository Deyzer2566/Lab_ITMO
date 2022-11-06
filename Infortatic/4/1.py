print((367298+8*2)%36)#6
#JSON -> XML
#ВТОРНИК

def parseString(s:str):
    e=0
    while True:
        e = min(s.find(',',e+1),s.find('"'))
        if e == -1:
            e = max(s.find(',', e + 1), s.find('"'))
        if e == -1:
            return s,s.__len__()
        in_seq=True
        for j in range(e+1):
            in_seq = in_seq ^ (s[j]=='"' and s[j-1]!='\\')
        if not in_seq:
            break
    return s[:e],e+1
def parseArray(s:str):
    p=0
    e=0
    elements=[]
    while True:
        e = min(s.find(',',p+1),s.find(']',p+1))
        if e == -1:
            e=max(s.find(',', p+1), s.find(']', p+1))
        if e == -1:
            e=s.__len__()
        if p == e:
            break
        if s[p]==']':
            break
        if s[p] == '[':
            data = parseArray(s[p+1:])
            elements += [data[0]]
            p += data[1]
        elif s[p] == '"':
            data = parseString(s[p+1:])
            elements += [data[0]]
            p += data[1]
        elif s[p] == '{':
            data = parseObject(s[p+1:])
            elements += [data[0]]
            p += data[1]
        else:
            mean = s[p:e]
            elements += [mean]
            p = e
        while s[p] == ',':
            p += 1
        in_seq=True
        for j in range(e+1):
            in_seq = in_seq ^ (s[j]==']')
        if not in_seq:
            break
    return elements,e
def parseObject(s:str):
    p=0
    ret = {}
    end=s.__len__()
    while p != end:
        end = s.find('}',p)
        name_p1 = s.find('"', p) + 1
        name_p2 = s.find('"', name_p1 + 1)
        name = s[name_p1:name_p2]
        p = name_p2+2
        if s[p] == '[':
            data = parseArray(s[p+1:])
            mean = data[0]
            p += data[1]
        elif s[p] == '"':
            data = parseString(s[p+1:])
            mean = data[0]
            p += data[1]
        elif s[p]=='{':
            data = parseObject(s[p+1:])
            mean = data[0]
            p += data[1]
        else:
            mean = s[name_p2+2:s.find(',',name_p2+2)]
            p += s.find(',',name_p2+2)
        ex=True
        ret = dict(list(ret.items())+list({name:mean}.items()))
    return ret,end
#print(parseObject("{{\"name1\":[\"lol\"],\"name2\":[]},{}}"))
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
# def fromArrayToXML(l:list,lvl:int):
#     ret=''
#     for k,j in enumerate(l):
#         ret += '<'+str(k)+'>'
#         if type(j) is list:
#             ret += fromArrayToXML(j,lvl+1)
#         elif type(j) is dict:
#             ret += toXML(j,lvl+1)
#         else:
#             ret += str(j)
#         ret += '</'+str(k)+'>'
#     return ret
#
# def toXML(s:dict,lvl:int):
#     ret=''
#     for key,value in s.items():
#         ret += '<'+key+'>'
#         if type(value) is dict:
#             ret += toXML(value,lvl+1)
#         elif type(value) is list:
#             ret += fromArrayToXML(value,lvl+1)
#         else:
#             ret += value
#         ret += '</' + key + '>'
#     return ret
if __name__=='__main__':
    f = open("расписание.json",encoding='utf-8')
    s = f.read()
    f.close()
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
    f = open('расписание.xml','w')
    f.write(s)
    f.close()
