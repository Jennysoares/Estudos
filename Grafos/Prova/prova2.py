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
def dfs(chave, flag, sequencia):
    if flag[chave] == 0:
        sequencia.append(chave)
        flag[chave] = 1
        valores = dic[chave]

        for valor in valores:
            if flag[valor] == 0:
                dfs(valor,flag,sequencia)
    else:
        return 1

arquivo = open('prova2.csv', encoding='utf-8-sig')

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
fracamente = 0

for i in indices:
    flag.update({i: 0})

for chave in dic:
    if dfs(chave, flag, sequencia) != 1:
        fracamente += 1

print("\nSequência:")
print(sequencia)
print('\nQuantidade de componentes fracamente conectados = {}'.format(fracamente))








