T = int(input())  # 첫 번째 줄에서 테스트 케이스의 개수 입력받기
for _ in range(T):  # T번 반복
    idx, word = input().split()  # 각 테스트 케이스에서 오타 위치와 단어 입력받기
    idx = int(idx)  # 오타 위치를 정수로 변환 input으로 받을때는 문자열로 받기 때문에 int(idx 사용)
    new_word = word[:idx-1] + word[idx:] # idx-1은 제거할 문자의 앞부분, idx는 제거할 문자의 뒷부분
    print(new_word)
