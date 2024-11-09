import sys
input = sys.stdin.readline

T = int(input())

# 데이터셋 제작(해시, 집합)
company = set()

# n번에 걸쳐서 로그가 입력
for _ in range(n):
    #입력을 받은 후
    name, status =input().split()
    # 상태가 enter라면? => 데이터셋에 추가
    if status == "enter":
        company.add(name)
    # 상태가 leave라면? => 데이터셋에서 삭제
    elif status == "leave":
        company.discard(name)
# 데이셋을 역순으로 정렬 .sort() 원본 리스트 변경
sorted_company = sorted(company, reverse=True) # sorted()원본 그대로 새로운 객체

# 하나씩 출력
for member in sorted_company:
    print(member)