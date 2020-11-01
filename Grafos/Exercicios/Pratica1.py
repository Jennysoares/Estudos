#Faça um programa que receba o nome de um arquivo .csv e monte uma matriz de adjacências e uma lista de adjacências.
#O arquivo irá conter N linhas, cada linha com a identificação de 2 vértices separados por ";".

import csv

def popularLista(lista,indices):
    for i in indices:  
        conjunto = []
        conjunto.append(i)
        for valores in vertices:
            if valores[0] == i:
                conjunto.append(valores[1])
            if valores[1] == i:
                conjunto.append(valores[0])

        lista.append(conjunto)
def mostrarLista(lista):
    for i in lista:
        x = 0
        for cont in i:
            if x == 0:
                print(f'{cont:^3}', end='')
                print(f'->', end='')
            else:
                print(f'{cont:^3}', end='')
            x = +1
        print()
def inicializarMatriz(obj,tamanho):
    for i in range(0, tamanho):
        l = []
        for j in range(0, tamanho):
            l.append(0)
        obj.append(l)
def popularMatriz(tamanho, indices,matriz):
    x = 0
    for i in range(1, tamanho):
        matriz[0][i] = indices[x]
        matriz[i][0] = indices[x]
        x += 1

    for i in vertices:
        valor1 = i[0]
        valor2 = i[1]

        for i in range(1, tamanho):
            if matriz[i][0] == valor1:
                for j in range(1, tamanho):
                    if matriz[0][j] == valor2:
                        matriz[i][j] = 1
                        matriz[j][i] = 1
def mostrarMatriz(tamanho, matriz):
    for i in range(0, tamanho):
        for j in range(0, tamanho):
            print(f'{matriz[i][j]:^3}', end='')
        print()

arquivo = open('exercicio.csv')

linhas = csv.reader(arquivo)
vertices = []
final = []

for linha in linhas:
    vertices.append(linha[0].split(";"))

for valores in vertices:
    for i in valores:
        final.append(i)

indices = sorted((set(final)))
tamanho = len(indices) + 1
lista = []
popularLista(lista,indices)
print("Lista:")
mostrarLista(lista)
print()


matriz = []
inicializarMatriz(matriz, tamanho)
popularMatriz(tamanho, indices, matriz)
print("Matriz:")
mostrarMatriz(tamanho, matriz)
print()




