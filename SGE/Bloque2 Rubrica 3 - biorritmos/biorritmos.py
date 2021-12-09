from math import sin, pi
import datetime

#imput datetime format 01/12/2002
day = int(input("Introduce el día en el que naciste: "))
month = int(input("Introduce el mes en el que naciste: "))
year = int(input("Introduce el año en el que naciste (2000): "))

days = (datetime.datetime.now() - datetime.datetime(year, month, day)).days


pysical_cicle = round(sin(2 * pi * days/ 23) * 100)
emotional_cicle = round(sin(2 * pi * days / 28) * 100)
intellectual_cicle = round(sin(2 * pi * days / 33) * 100)

print("\nCiclo físico", pysical_cicle, "%")
print("Ciclo emocional", emotional_cicle, "%")
print("Ciclo intelectual", intellectual_cicle, "%")