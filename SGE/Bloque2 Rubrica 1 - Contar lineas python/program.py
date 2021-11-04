from colorama import Fore, Style

url = input("Introduce el path del fichero: ")
words = []
while True:
    words += input("Introduce las palabras que deseas buscar: ").split()

    r = input("¿Has introducido todas las palabras que querias buscar? [Y/n] ").lower()

    if (r != "n"):
        break

with open(url, "r") as f:
    content = f.read().lower().split("." "\n")


def areWordsInLine(words, line):

    for word in words:

        if word in line.split():
            return True
            
for line in content:

    if areWordsInLine(words, line):

        nline = ""
        for lineWord in line.split():

            if (lineWord in words):

                nline = nline + " " +  Fore.GREEN + lineWord + Style.RESET_ALL
            else:
                
                nline = nline + " " + lineWord

        print(nline)

