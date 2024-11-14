import sys
input = sys.stdin.readline
# 백준에서만 사용

#입력 받기
N =int(input())

# 검색을 많이 한다 하면 해시구조로 만들고 이것은 집합으로 하는 것이 좋다
A = set(map(int, input().split()))
M = int(input())
B = list(map(int, input().split()))

#아래에 있는 배열을 선형을 탐색하면서(하나씩 검색)
for num in B:
    # 위에 있는 배열에 있다면 => 1 출력
    if num in A:
        print(1)
    # 없다면 => 0 출력
    else:
        print(0)