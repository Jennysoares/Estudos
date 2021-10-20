# Questao 01

while True:
    alunosBagunceiros = int(input())
    if 1000 > alunosBagunceiros > 0:
        break
    else:
        print('Digite novamente entre 0 e 1000')

alunosSeqReport = input()
Pi = list()
furos = dict()
print()

for report in alunosSeqReport:
    if report != ' ':
        Pi.append(report)

for i in range(1, alunosBagunceiros + 1):
    for alunos in range(1, alunosBagunceiros + 1): furos.update({alunos: 0})
    furos[i] += 1

    for reportado in Pi:
        furos[int(reportado)] += 1

        if furos[int(reportado)] == 2:
            print(reportado, end=' ')
            break
