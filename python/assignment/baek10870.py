# 1. 함수
  # 로직을 담아서 반복 사용
  # def를 이용하여 정의

# 2. LEGB 규칙
  #1) local 영역에서 global 영역 변수를 재할당할 수 없다
    #재할당하고 싶을 때에는 global 처리
  #2) local 영역에서 global 영역 변수를 참조할 수는 있다
  #3) 참조할 때에는 LEGB 순서로 참조한다
    #Local Enclosed(자식 함수) Global Buil-in
    

# a= 5
# def my_func():
#   b = 10
#   b += 5
#   return b
# print(my_func())
#UnboundLocalError: cannot access local variable 'a' where it is not associated with a value
# 3. 재귀함수
  # 자기 자신으로써 정의되는 함수

# 재귀함수를 이용해서 nums에서 가장 큰 수를 탐색
# nums = [-5, 2, 7, -3, 2, 10, 8, 6, 5, -1]
# ans = -float("INF") 
# def my_func(idx):  
#   global ans
#   # 재귀의 종료 조건
#   # idx가 len(nums) 일 때 종료
#   if idx == len(nums):
#     return 
#   # 탐색 및 갱신 로직 
#   # nums[idx]와  ans를 비교하여 큰 값으로 갱신
#   # ans = max(nums[idx], ans)
#   if ans < nums[idx]:
#     ans = nums[idx] 

#   my_func(idx+1)


# def my_func(idx, ans):  
#   # 재귀의 종료 조건
#   # idx가 len(nums) 일 때 종료
#   if idx == len(nums):
#     return ans
  
#   # 탐색 및 갱신 로직 
#   # nums[idx]와  ans를 비교하여 큰 값으로 갱신
#   ans = max(nums[idx], ans)

#   return my_func(idx+1, ans)

# print(my_func(0, -float("INF")))


# def find(depth):
#   if depth == 10:
#     print("find it!")
#     return
#   print(f'탐색하는 중... 깊이는 {depth}')
#   find(depth+1)

#   print(f'올라가는 중... 깊이는{depth}')
# find(0)

n= int(input())
# fibo(n) = fibo(n-1) + fibo(n-2) (단 n>=2)
def fibo(n):
  # 리턴 조건
  if n<=1:
    return n
  #탐색 조건
  return fibo(n-1) + fibo(n-2)
print(fibo(n))
