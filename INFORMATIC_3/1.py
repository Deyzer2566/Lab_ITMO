import re#8 -{ )
import random
isu = 367298
eye = [':',';','X','8','=']
nose = ['-','<','-{','<{']
mouth = ['(',')','O','|','\\','/','P']
my_smile = eye[isu%5]+nose[isu%4]+mouth[isu%7]
print('my smile:',my_smile)
def gen():#генерация тестов
    s = []
    count = 0
    for i in range(40):
        if random.randint(0,8)==3:
            s.extend(my_smile)
            count+=1
        eye_ind = random.randint(0,4)
        nose_ind=random.randint(0,3)
        mouth_ind=random.randint(0,6)
        smile = eye[eye_ind]+nose[nose_ind]+mouth[mouth_ind]
        s.extend(smile)
        if(smile == my_smile):
            count += 1
    return ''.join(s),count
test=[]
for i in range(10):
    test += [gen()]
for i in range(10):
    print(test[i][0].count(my_smile), test[i][1])
