# 문자열에서 O가 나오면 점수 +1 X가 나오면 0으로 반환하는데 
T = int(input())
# 몇번 반복 탐색을 해서 찾을 건지
for score in range(T):
  #OX 입력 받는 근데 O, O, X 이런식으로 나누어 받아서 하나씩 봐야할 것 같은데
  answer=input()
  result = 0
  total = 0
  for idx in range(len(answer)):
    # print(total)
    if answer[idx] == "O":
      result += 1
      total =total + result
    else:
      result = 0
      #total의 인데스 값을 뽑아서 합을 한 후에 출력?
      #sum = sum +x
  print(total)
