import csv

# Faça um programa, que leia N linhas de um arquivo csv da seguinte forma: A;B;3 Onde A e B simbolizam vértices e o 3
# simboliza o peso da aresta (não orientado) entre eles. Utilizando o algoritmo de Djikstra, mostre qual a menor
# distância entre o primeiro par de vértices informado e os outros pares.

listaPop = list()

def lerArquivo(arquivo):
    ares = list()
    final = list()
    with open(arquivo, 'r', encoding='utf-8-sig') as ficheiro:
        reader = csv.reader(ficheiro, delimiter=';')
        for linha in reader:
            ares.append(linha[0].split(";"))

    for valores in ares:
        for j in valores[0:2]:
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


def djikstra(chave, distanciaA, dictDjik):
    global listaPop
    global arestas

    adjacentes = dic[chave]
    for valor in adjacentes:
        soma = 0

        if distanciaA < dictDjik[valor] or dictDjik[valor] == -1:
            for cont in range(0, len(arestas)):
                if (arestas[cont][0] == chave and arestas[cont][1] == valor) or (
                        arestas[cont][0] == valor and arestas[cont][1] == chave):
                    distanciaEntreVert = arestas[cont][2]
                    soma = int(distanciaEntreVert) + int(distanciaA)

            if (soma < dictDjik[valor]) or dictDjik[valor] == -1:
                dictDjikstra[valor] = soma
                listaPop.append([valor, soma])



    if len(listaPop) > 0:
        menor = 99999999
        indice = 0
        print(listaPop)

        for k in range(0, len(listaPop)):
            if listaPop[k][1] < menor:
                menor = listaPop[k][1]
                chave = listaPop[k][0]
                indice = k
        del listaPop[indice]
        print(chave)
        print(menor)
        djikstra(chave, menor, dictDjik)


arestas, vertices, raiz = lerArquivo('exemplo.csv')
dic = popularLista(vertices, arestas)
sequencia = list()
dictDjikstra = dict()

for i in vertices:
    dictDjikstra.update({i: -1})

dictDjikstra[raiz] = 0
djikstra(raiz, dictDjikstra[raiz], dictDjikstra)

mostrarLista(dic)
print('\nDistância Djikstra:\n {}'.format(dictDjikstra))
