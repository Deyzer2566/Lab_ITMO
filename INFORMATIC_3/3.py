import re
import random
sym = ['+','*','-','=',':']
def gen():
    c = random.randint(2,10)
    b = []
    a = []
    for i in range(c):
        num = random.randint(0,100)
        if random.randint(0,5)==3:
            sym_rnd=random.choice(sym)
            a.append(sym_rnd)
            b.append(sym_rnd)
        b.append(str(num))
        a.append(str(3*num**2+5))
    return ' '.join(b),' '.join(a)
test = [gen() for i in range(5)]
for i in test:
    out = []
    for n in re.findall(r'(\d+|[+*-=:])',i[0]):
        if n in sym:
            out.append(n)
        else:
            num = int(n)
            out.append(str(num**2*3+5))
    out = ' '.join(out)
    #print((i[1],out))
    if i[1] == out:
        print('Правильно!')
