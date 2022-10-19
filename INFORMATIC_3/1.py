import random
import re
isu = 367298
eye = [':',';','X','8','=','[']
nose = ['-','<','-{','<{']
mouth = ['(',')','O','|','\\','/','P']
my_smile = eye[isu%6]+nose[isu%4]+mouth[isu%7]
print('мой смайлик:',my_smile)
def gen():#генерация тестов
    s = []
    count = 0
    for i in range(20):
        if random.randint(0,8)==3:
            s.append(my_smile)
            count+=1
        eye_ind = random.randint(0,5)
        nose_ind=random.randint(0,3)
        mouth_ind=random.randint(0,6)
        smile = eye[eye_ind]+nose[nose_ind]+mouth[mouth_ind]
        s += [smile]
        if(smile == my_smile):
            count += 1
    return ' '.join(s),count
test=[]
for i in range(10):
    test += [gen()]
print('Вывод программы   Правильный ответ')
for i in range(10):
    print('       ',len(re.findall('X-\{\)',test[i][0])),'              ', test[i][1])
