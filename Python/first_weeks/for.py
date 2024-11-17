dwarfs = [int(input()) for _ in range(9)]
dwarfs.sort()
#2중 for문을 활용
flag = False
for i in range(9):
    for j in range(9):
        #만약 i번째 난쟁이 키와 j번째 난쟁이 키를 전체에 빼서 100이 된다면?
        if sum(dwarfs) - dwarfs[i] - dwarfs[j] ==100:
        #i,j를 보관
            spy = [i,j]
        #2중for문을 종료
            flag=True
            break
    if flag:
        break
# 하나씩 출력
for idx in range(9):
# (i, j 번째는 출력하지 않음)
    if idx in spy:
        continue
    print(dwarfs[idx])