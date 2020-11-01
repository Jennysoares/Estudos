import csv

#Faça um programa que receba o nome de um arquivo .csv e monte uma lista de adjacências e a tabela de "in and Out".
# O arquivo irá conter N linhas, cada linha com a identificação de 2 vértices separados por ";".

contador = 0

def lerArquivo(arquivo):
    ares = list()
    final = list()
    with open(arquivo, 'r', encoding='utf-8-sig') as ficheiro:
        reader = csv.reader(ficheiro, delimiter=';')
        for linha in reader:
            ares.append(linha[0].split(";"))
        
    for valores in ares:
        for i in valores:
            final.append(i)

    vert = sorted(set(final))

    return ares, vert

def popularLista(indices, arestas):
    dictLista = dict()
    for i in indices:
        conjunto = []
        for a in arestas:
            if a[0] == i:
                conjunto.append(a[1])
            if a[1] == i:
                conjunto.append(a[0])

        lfinal = sorted(set(conjunto))
        dictLista.update({i: lfinal})
    
    return dictLista

def mostrarLista(dic):
    print("\nLista Adjacências:")
    for key in dic:
        chave = key
        valor = dic[chave]
        print(" %s => %s" % (chave,valor))

def DFS(chave, flag, sequencia, dicIn, dicOut):
    global contador 
    contador += 1

    if flag[chave] == 0:
        sequencia.append(chave)
        flag[chave] = 1
        dicIn[chave] = contador

        valores = dic[chave]
        
        for valor in valores:
            if flag[valor] == 0:
                DFS(valor, flag, sequencia, dicIn, dicOut)

        contador += 1
        dicOut[chave] = contador

arestas, vertices = lerArquivo('pratica4.csv')
dic = popularLista(vertices, arestas)

sequencia = list()
flag = dict()
dicIn = dict()
dicOut = dict()

for i in vertices: 
    flag.update({i: 0})
    dicIn.update({i: 0})
    dicOut.update({i: 0})

for val in vertices:
    DFS(val, flag, sequencia, dicIn, dicOut)

mostrarLista(dic)
print('\nIN  -> {}'.format(dicIn))
print('OUT -> {}\n'.format(dicOut))