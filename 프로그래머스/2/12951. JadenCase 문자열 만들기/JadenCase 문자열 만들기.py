def solution(s):
    answer = ''
    arr = s.split(' ')    
    for i in range(len(arr)):
        arr[i] = arr[i].capitalize()
        answer += arr[i] + ' '
        
    if answer[-2] == ' ':
        answer = answer[:-1]
        
    else:
        answer = answer.rstrip()
        
    return answer