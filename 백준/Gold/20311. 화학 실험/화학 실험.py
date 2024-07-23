import sys, heapq
input = sys.stdin.readline
n, k = map(int, input().split())
arr = list(map(int, input().split()))
maxH = []
for i in range(k):
    heapq.heappush(maxH, [-arr[i], i])

flag = True
result = []
temp = []
while maxH:
    
    value, index = heapq.heappop(maxH)
    result.append(index+1)
    if len(result) >= 2 and result[-1] == result[-2]:
        flag = False
        break

    if temp:
        x = temp.pop()
        if x[0] < 0:
            heapq.heappush(maxH, x)    
    

    temp.append([value + 1, index])


if not flag or temp[0][0] <= -1:
    print(-1)

else:
    for x in result:
        print(x, end = ' ')