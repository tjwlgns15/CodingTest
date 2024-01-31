def solution(s):
    arr = []
    arr = s.split(' ')
    for i in range(len(arr)):
        arr[i] = int(arr[i])
    arr = sorted(arr)
    mi = str(arr[0])
    ma = str(arr[-1])
    
    return mi + ' ' + ma