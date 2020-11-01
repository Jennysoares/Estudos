import csv

# Faça um programa que receba o nome de um arquivo .csv e monte uma lista de adjacências. O arquivo irá conter N
# linhas, cada linha com a identificação de 2 vértices separados por ";". Mostre na tela qual seria a ordem caso esse
# grafo seja percorrido no formato BFS utilizando o primeiro vértice do primeiro par de vértices lido como vértice root.

listaBFS = []


def lerArquivo(arquivo):
    ares = list()
    final = list()
    with open(arquivo, 'r', encoding='utf-8-sig') as ficheiro:
        reader = csv.reader(ficheiro, delimiter=';')
        for linha in reader:
            ares.append(linha[0].split(";"))

    for valores in ares:
        for j in valores:
            final.append(j)
    r = final[0]
    vert = sorted(set(final))

    return ares, vert, r


def popularLista(indices, arest):
    dictLista = dict()
    for k in indices:
        conjunto = []
        for a in arest:
            if a[0] == k:
                conjunto.append(a[1])
            if a[1] == k:
                conjunto.append(a[0])

        lfinal = sorted(set(conjunto))
        dictLista.update({k: lfinal})

    return dictLista


def mostrarLista(lista):
    print("\nLista Adjacências:")
    for key in lista:
        chave = key
        valor = lista[chave]
        print(" %s => %s" % (chave, valor))


def BFS(chave, visitado, seq):
    global listaBFS

    seq.append(chave)
    visitado[chave] = 1
    valores = dic[chave]

    for valor in valores:
        if flag[valor] == 0:
            listaBFS.append(valor)
            visitado[valor] = 1

    listaBFS.pop(0)
    if len(listaBFS) > 0:
        BFS(listaBFS[0], flag, seq)


arestas, vertices, raiz = lerArquivo('pratica5.csv')
dic = popularLista(vertices, arestas)

sequencia = list()
flag = dict()

for i in vertices:
    flag.update({i: 0})

listaBFS.append(raiz)
BFS(raiz, flag, sequencia)

mostrarLista(dic)
print('\nSequência BFS = {}'.format(sequencia))
