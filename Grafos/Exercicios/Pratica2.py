#Leia o arquivo CSV que irá conter em cada linha um par de nós de um grafo simbolizando a ligação entre esses nós;
#Monte uma lista de adjacência com os valores lidos no arquivo. Utilizar como referência de ordenação a ordem crescente numérica ou a ordem alfabética.
#Mostre a lista de adjacência construída e a sequência dos nós caso esse grafo seja percorrido no formato DFS.

import csv

def popularLista(dic,indices):
    for i in indices:
        conjunto = []
        for valores in vertices:
            if valores[0] == i:
                conjunto.append(valores[1])
            if valores[1] == i:
                conjunto.append(valores[0])

        final = sorted(set(conjunto))
        dic.update({i:final})
def mostrarLista(dic):
    print("\nLista Adjacências:")
    for key in dic:
        chave = key
        valor = dic[chave]
        print(" %s => %s" % (chave,valor))
def sequencias(chave, flag, sequencia):
    if flag[chave] == 0:
        sequencia.append(chave)
        flag[chave] = 1
        valores = dic[chave]

        for valor in valores:
            if flag[valor] == 0:
                sequencias(valor,flag,sequencia)

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
dic = {}
popularLista(dic,indices)
mostrarLista(dic)
sequencia = []
flag = {}

for i in indices:
    flag.update({i: 0})

for chave in dic:
    sequencias(chave, flag, sequencia)

print("\nSequência:")
print(sequencia)








