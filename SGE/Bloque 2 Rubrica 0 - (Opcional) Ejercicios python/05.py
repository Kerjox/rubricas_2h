"""Implementa un programa Python que solicite al usuario una cadena de caracteres (String) y muestre por pantalla el número de veces que aparece la sub-cadena “aaa” dentro de dicho String."""

import re
inputString = input('Introduce una frase y te diré ceuntos "aaa" tiene: ')


print(f'La frase tiene {len(re.findall("aaa", inputString))} aaa')