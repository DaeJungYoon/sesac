import sys
input = sys.stdin.readline

# i번째 수 분터 j번째 수 => 리스트
# 1 2 3 4 2 5 3 1 1 2 => [1, 2, 3, 4, 2, 5, 3, 1, 1, 2]
#입력의 제한값 => 시간 복잡도 계산할 때 사용
# O(N^2) N=10000 1억-> 1초 걸림

# for i = 0
  # for j
# 왜 비효율?

N, M = map(int, input().split())
nums = list(map(int, input().split()))


# 밥복을 하다가 특정한 조건에 따라 이동

# 세팅
# 두 포인터를 각각의 변수에 할당
i = j =0 #각각의 포인트의 조건에 이동?
# 왼쪽끝에서 시작하는 투 포인터이기 때문에 0으로 설정
#정답 변수, 임시값
tmp = ans = 0
# i인덱스와 j인덱스의 합
# ans는 정답을 셀때마다 정답을 하나씩 늘려줌
# tmp 포인터가 이동하면서 i와 j의 범위가 유지 되어야하는 데 

# 현재 왼쪽포인터는 포함을 한 상태
# 오른쪽은 포함x
# 1차원 선형을 탐색하는 알고리즘

# 언제 움직이는지 와 언제 종료시키는지가 중요
# 두 개의 포인트가 일정하게 이동하는 것이 
# 조건은 i 이동, j 이동, 종료
# 계속 반복 (while)
  # 임시값(tmp)과 타켓하고 있는 M값과 
  # 비교하여 포인터 이동?
while True:
  # tmp < M => l 포인터 j 포인트 임시값이 너무 작은 상황
  if tmp < M:   
    # 오른쪽 j포인터가 N에 가있으면
    if j == N:
      # 탑색 종료
      break
    # 오른쪽 포인터가 가맄키는 값을 tmp 에 더하고
    tmp += nums[j]
    # 오른쪽 포인터 이동
    j += 1
  # tmp > M =>
  elif tmp > M:
    # 왼쪽 포인터가 가리키는 값ㄱ을 tmp에서 빼고
    tmp -=  nums[i]
    # 왼쪽 포인터를 이동
    i += 1
  # tmp == M
  else:
    # 정답하나 세어주고
    ans += 1
    # 왼쪽 포인터가 가리키는 값을 tmp에서 빼고
    tmp -= nums[i]
    # 왼쪽 포인터를 이동
    i += 1

print(ans)

# 두 포인트가 일정하게 앞으로 이동하여 시간 복잡도 O(N)