# 9명의 키들을 조회하고 
# 7명의 키를 합할 때 100이 나오는 키들을만 오름차순으로 출력 해야
# 오름차순은 sort()
#20
# 7
# 23
# 19
# 10
# 15
# 25
# 8
# 13
# 입력을 받아서 리스트에 저장 
# 리스트에 안 넣고 가능한가?
import sys
input = sys.stdin.readline

from itertools import combinations

dwarf_list = []
for i in range(9):
  T=int(input())
  dwarf_list.append(T)
  # print(dwarf_list)
#dwarf list의 인덱스 0번째부터 8번째까지 조회를 하고 
# 7개를 합해서 100이 나오는 함수? 로직을 만들어야한다?
for comb in combinations(dwarf_list,7):
  # print(comb)
  total = sum(comb)
  if total == 100:
    total_list = list(comb)
    total_list.sort()
    for idx in range(len(total_list)):
      print(total_list[idx])
    break