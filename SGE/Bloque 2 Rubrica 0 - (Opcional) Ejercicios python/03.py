import math
from random import randint

print('Voy a pensar un número del 0 al 20 y los tendrás que adivinar\n')

number = int(randint(0, 20))

tries = 0

while True:
    userNumber = int(input('Inproduce un número: '))
    if number == userNumber:
        break;
    else:
        print('mayor' if userNumber > number else 'menor')
        tries += 1

print(f'Has ganado, el numero era {number}, {tries} intentos.')