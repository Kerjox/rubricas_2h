input = input("Introduce 10 números separados por espacios: ")
input = list(map(int, input.split(' ')))

print(input)

mayorCero = menorCero = cero = 0

i = 0
for i in input:

    if (i == 0):
        cero += 1
    elif (i > 0):
        mayorCero += 1
    else:
        menorCero += 1

print(f"""{cero} números son cero
{mayorCero} números son mayores que cero
{menorCero} números son menores que cero""")