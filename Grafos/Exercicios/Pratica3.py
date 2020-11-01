import csv


# Dado uma árvore representada por um arquivo igual ao exercício prático 1, faça um programa que
# leia os dados dá arvore e mostre ao usuário a distância entre o nó raiz e cada um dos outros nós dessa árvore.

def popularLista(dic, indices):
    for i in indices:
        conjunto = []
        for v in vertices:
            if v[0] == i:
                conjunto.append(v[1])
            if v[1] == i:
                conjunto.append(v[0])

        lfinal = sorted(set(conjunto))
        dic.update({i: lfinal})


def mostrarLista(dic):
    print("\nLista Adjacências:")
    for key in dic:
        chave = key
        valor = dic[chave]
        print(" %s => %s" % (chave, valor))


def DFS(chave, flag, sequencia, distancia, pai):
    if flag[chave] == 0:
        sequencia.append(chave)
        flag[chave] = 1

        valores = dic[chave]

        if pai is None:
            distancia.update({chave: 0})
            pai = chave
        print('chave = {}'.format(chave))
        for valor in valores:
            print(valor)
            if flag[valor] == 0:
                if distancia[valor] != 0:
                    distancia.update({valor: distancia[pai] + 1})
                DFS(valor, flag, sequencia, distancia, chave)


vertices = list()
final = list()
with open('teste.csv', 'r', encoding='utf-8-sig') as ficheiro:
    reader = csv.reader(ficheiro, delimiter=';')
    for linha in reader:
        vertices.append(linha[0].split(";"))

for valores in vertices:
    for i in valores:
        final.append(i)
indices = sorted(set(final))
dic = dict()
popularLista(dic, indices)
mostrarLista(dic)

sequencia = list()
flag = dict()
distancia = dict()

for i in indices: flag.update({i: 0})
raiz = '4'
DFS(raiz, flag, sequencia, distancia, None)

for key in distancia:
    if distancia[key] == 0:
        print('\nRaiz = %s' % key)
    else:
        print('   Nó %s -> Distância = %s' % (key, distancia[key]))
