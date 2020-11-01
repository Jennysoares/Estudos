import csv

# Faça um programa que receba o nome de um arquivo .csv e monte uma lista de adjacências . O arquivo irá conter N
# linhas, cada linha com a identificação de 2 vértices separados por ";". Levando em consideração que o grafo que
# será informado atende as propriedades de ordenação topológica, implemente o algorítmo de Kahn's para ilustrar a
# ordem topológica do grafo informado.

listaDegree = []


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
    vert = set(final)

    return ares, vert, r


def popularLista(indices, arest, vert):
    dictLista = dict()
    for k in indices:
        conjunto = []
        for a in arest:
            if a[0] == k:
                conjunto.append(a[1])
                valor = vert[a[1]]['degree']
                valor = valor + 1
                vert[a[1]]['degree'] = valor

        dictLista.update({k: conjunto})

    return dictLista


def mostrarLista(lista):
    print("\nLista Adjacências:")
    for key in lista:
        chave = key
        valor = lista[chave]
        if len(valor) > 0:
            print(" %s => %s" % (chave, valor))
        else:
            print(" %s => Não possui adjacentes" % chave)


def kahns(key, vertice, seq):
    global listaDegree

    seq.append(key)
    valores = dic[key]

    for valor in valores:
        val = vertice[valor]['degree']
        val = val - 1
        vertice[valor]['degree'] = val
        if vertice[valor]['degree'] == 0:
            listaDegree.append(valor)

    if len(listaDegree) > 0:
        listaDegree.pop(0)
    else:
        return

    if len(listaDegree) > 0:
        kahns(listaDegree[0], vertice, seq)


arestas, vertices, raiz = lerArquivo('teste.csv')

dicVertice = dict()
for i in vertices:
    dici = {}
    dici.update({'degree': 0})
    dicVertice.update({i: dici})

dic = popularLista(vertices, arestas, dicVertice)

sequencia = list()
for chave in dicVertice:
    degree = dicVertice[chave]['degree']
    if degree == 0:
        listaDegree.append(chave)

mostrarLista(dic)

if len(listaDegree) > 0:
    kahns(listaDegree[0], dicVertice, sequencia)
    print('\nSequência topológica = {}'.format(sequencia))
else:
    print('\n Esse grafo possui cilcos, logo não é possível efetuar a ordem topológica.')
