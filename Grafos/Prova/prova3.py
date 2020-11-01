import csv

backedges = 0
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
        print(" %s => %s" % (chave,valor))

def dfs(chave, flag, sequencia, pai):
    if flag[chave] == 0:
        sequencia.append(chave)
        flag[chave] = 1
        valores = dic[chave]
        for valor in valores:
            if flag[valor] == 0:
                dfs(valor, flag, sequencia, chave)
            else:
                if valor != pai and pai != None:
                    global backedges
                    backedges = 1



vertices = list()
final = list()

with open('prova3.csv', 'r', encoding='utf-8-sig') as ficheiro:
    reader = csv.reader(ficheiro, delimiter=';')
    for linha in reader:
        vertices.append(linha[0].split(";"))

for valores in vertices:
    for i in valores:
        final.append(i)

indices = sorted(set(final))
dic = dict()
popularLista(dic, indices)

sequencia = list()
flag = dict()
distancia = dict()
for i in indices: flag.update({i: 0})

dfs('1', flag, sequencia, None)

mostrarLista(dic)
print("\nSequência:")
print(sequencia)

if backedges > 0:
    print('\nEsse grafo possui ciclos')
else:
    print('\nNão há ciclos nesse grafo.')

