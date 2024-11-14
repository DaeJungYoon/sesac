import sys
input = sys.stdin.readline

N, K = map(int, input().split())
nums = list(map(int, input().split()))

#첫 번째 구간의 합은 직접 구한다
max_num = tmp = sum(nums[:K]) # K개까지 뽑아준 것을 다 더함
# N-K 번 반복하여 
for idx in range(N-K):
    # 맨 왼쪽은 빼고 오른쪽은 더한다               
    tmp += nums[idx+K] - nums[idx]  #내가 가지고 있는 임시값에서 다음번 걸 구하려면 제일 왼쪽에 있는 것을 빼 
    #갱신할 수 있으면 갱신하다       #그것은 제일 왼쪽에 있눈 nums[idx]일 것이고 제일 오른쪽 있는 nums[ids+3] 더해   
    max_num = max(max_num, tmp)     # 갱신 min_max 로직과 동일 

print(max_num)