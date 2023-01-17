n = list(range(1, 10001))
remove = []
for i in n:
  for a in str(i):
    i += int(a)
  if i <= 10000:
    remove.append(i)
for remove_num in set(remove):
  n.remove(remove_num)
for self_num in n:
  print(self_num)