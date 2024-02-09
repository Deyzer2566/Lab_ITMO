def getColumn(matrix, column):
    return [matrix[i][column] for i in range(len(matrix))]
def setColumn(matrix, column, data):
    if type(data)==list or type(data)==tuple:
        for i in range(len(matrix)):
            matrix[i][column] = data[i]
    else:
        for i in range(len(matrix)):
            matrix[i][column] = data
def print_matrix(matrix: list):
    if len(matrix) > 1:
        print('/', '\t'.join(list(map(lambda x: "{:.4f}".format(x),matrix[0]))),'\\')
        for j in range(1,len(matrix)-1):
            print('|', '\t'.join(list(map(lambda x: "{:.4f}".format(x),matrix[j]))), '|')
        print('\\', '\t'.join(list(map(lambda x: "{:.4f}".format(x),matrix[-1]))),'/')
    else:
        print('(','\t'.join(list(map(lambda x: "{:.4f}".format(x),matrix))),')')
def getNorma(matrix: list):
    s = [abs(sum(matrix[i])) for i in range(len(matrix))]
    return max(s)
def cast(matrix: list):
    count_columns = len(matrix[0])
    count_rows = len(matrix)
    columns = [i for i in range(count_columns)]
    rows = [i for i in range(count_rows)]
    for j in range(count_rows):
        col = getColumn(matrix, j)[j:count_rows]
        col = [abs(i) for i in col]
        k = max(col)
        ind = col.index(k)+j
        rows[ind], rows[j] = rows[j], rows[ind]
        for i in range(0, count_columns):
            matrix[ind][i],a[j][i] = a[j][i], a[ind][i]
        b[ind], b[j] = b[j], b[ind]

        k = max([abs(i) for i in matrix[j][j:count_rows]])
        ind = matrix[j].index(k,j)
        columns[j], columns[ind] = columns[ind], columns[j]
        for i in range(0, count_rows):
            matrix[i][ind],a[i][j] = a[i][j], a[i][ind]
    return matrix, columns, rows
def simple_iterations_method(matrix: list, b: list, epsilon):
    matrix, columns, rows = cast(matrix)
    print('Матрица после перестановок:')
    print_matrix(matrix)
    oneIsStrong = False
    for j in range(0, n):
        if a[j][j] == 0:
            return "0 в одной из диагональ!"
        elif sum(a[j]) > 2*a[j][j]:
            return "Условие преобладания не выполнено!"
        elif sum(a[j]) < 2*a[j][j]:
            oneIsStrong = True
    if not oneIsStrong:
        return "Условие преобладания не выполнено!"
    C = [[0 for i in range(n)] for j in range(n)]
    d = [0 for j in range(n)]
    for j in range(0, n):
        for i in range(0, n):
            if i != j:
                C[j][i] = - matrix[j][i] / matrix[j][j]
        d[j] = b[j] / matrix[j][j]
    print('Матрица после преобразований')
    print_matrix(C)
    print('Вектор b')
    print(d)
    x = d.copy()
    error = epsilon+1
    iterations = 0
    print('\t'.join(['№']+['x'+str(i) for i in range(1,n+1)]+['max(x^k-x^k-1)']))
    print('\t'.join(['0']+list(map(str,x))+['-']))
    while error > epsilon:
        x1 = [0 for j in range(n)]
        for i in range(n):
            for j in range(n):
                if i != j:
                    x1[i] += C[i][j] * x[j]
            x1[i] += d[i]
        error = max([abs(x1[j]-x[j]) for j in range(n)])
        x = x1
        iterations += 1
        print('\t'.join([str(iterations)]+list(map(lambda x: "{:.4f}".format(x),x))+["{:.4f}".format(error)]))
    return x
with open('test.txt', 'r') as f:
    n = int(f.readline())
    a = []
    for j in range(n):
        a.append(list(map(int, f.readline().split())))
    b = list(map(int, f.readline().split()))
    print(simple_iterations_method(a,b, 1e-2))