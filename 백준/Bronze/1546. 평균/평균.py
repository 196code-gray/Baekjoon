n = int(input())
score = list(map(int, input().split()))
high = max(score)
new = []

for i in score:
  new.append(i/high *100)
answer = sum(new)/n
print(answer)