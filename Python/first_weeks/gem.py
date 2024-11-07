gems = [3, 3, 1, 2, 3, 2, 2, 3, 3, 1]

# 1. 리스트 안에 1이 존재라는지 여부?
    # 반복문을 이용해서 리스트를 순회하며
for gem in gems:
    # 순회하다가 1 이라는 데이터가 발견되었으면?
    if gem ==1:
    # 찾았음을 표시하고 종료
        print("find it")
        break # [2]에 1이 발견되어 순회 종료

# for idx in range(0, 10): # 0부터 시작해서 10개를 뽑을거야 첫 시작이 0이면 생략가능
#     if gems[idx] ==1:
#         print("find it")
#         break
for idx in range(len(gems)): # gems 길이까지
    if gems[idx] ==1:
        print("find it")
        break
# # 2. 리스트에서 가장 큰 숫자를 찾는 방법
# lst = [56, 23, 43, 87, 12, 457, 86]
# for idx in range(len(lst)):
#     #아주 아주 작은 수를 맥스넘 변수에 할당하고
#     maxNum = -infinity
#     # if로 lst 값고 maxNum을 비교하여 
#     if lst[idx] > maxNum:
#         #큰 수를 maxNum으로 재할당
#         maxNum = lst[idx]
#         print(maxNum)
#         break
# 2. 리스트에서 가장 큰 숫자를 찾는 방법
lst = [56, 23, 43, 87, 12, 457, 86]
ans = -float("INF")
ans = lst[0]
# 반복문을 이용해서 리스트를 선형 탐색
for num in lst:
    # 만약 방금 뽑은 그 값이 후보보다 크다면?
    if num > ans:
    # 큰 수로 갱신
            ans = num
print(ans)

# 3. 집계 알고리즘
gems = [3, 3, 1, 2, 3, 2, 2, 3, 3, 1]

# 딕셔너리를 이용한 집계
# 해당 딕셔너리에 1:0, 2:0, 3:0 이라는 키 값을 만든다.
grades = {1:0, 2:0, 3:0}

# 반복문을 이용해서 리스트를 선형 탐색
for gem in gems:    
    # 방금 뽑은 그 등급에 따라서 밸류값을 갱신한다.
    grades[gem] += 1
    
print(grades)