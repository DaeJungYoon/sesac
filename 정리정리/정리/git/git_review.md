# git
- 분산 버전 관리 시스템
	- 변경사항 만 저장을 한다
	- 변경사항 - 커밋
- 변경사항의 발생
	- mkdir
	- 파일 수정
	- touch
- 임시 저장소로 이동
	- staging area
	- git add
- 변경사항 최종 저장
	- git commit -m 'message'
	- message! 가 중요함
	- 커밋 메시지를 제목 - 본문으로 나눠서 작성 가능!

- 커밋 확인
	- git log
	- git log --oneline
	- 로그들이 많아지면
		- enter쳐서 다음 로그 확인
		- q를 누르면 로그 확인창 취소

- git으로 관리되는 파일들의 상태
	- git status




# github
- 프로젝트의 관리를 local에서만 하는 것이 아니라, 
  원격 환경, 즉 인터넷을 활용해서 하고 싶다.
1. 내가 어디서든 나의 프로젝트에 접근할 수 있다.
2. 다른사람도 나의 프로젝트에 접근할 수 있다.
	1. 접근 권한은 내가 컨트롤 합니다ㅏ.

---
## 업로드

1. 나의 local에 git repository가 존재.
2. 온라인 상, github에 업로드를 하고 싶습니다
3. 업로드를 하기 위한 공간이 필요합니다.
	1. github repository 생성.
		1. 여기에 업로드를 하고 싶음.
		2. github repo에 대한 url로 repo를 식별
	2. 나의 local repo와 github repo를 연결시킵니다.
		1. git remote add origin {url}
		2. local 레포에게 원격 repo를 인식시킨다.
	3. 업로드
		1. git push origin main
		2. origin이라는 원격 레포에 main브랜치를 업로드 하겠어.


## 다운로드
0. 나의 레포지토리가 원격으로 업로드 되어 있다.
1. 원격 레포의 커밋들을 다운로드한다.
	1. git clone {url}
	2. 나의 폴더에 원격 레포지토리 이름을 갖는 폴더가 생성됩니다.
	3. 그것이 "git"으로 관리되는 폴더.
	4. 나의 폴더를 "git"으로 관리되도록 한다.

2. 이미 원격 레포와 연결된 상태에서, 
   나의 로컬 레포와 원격 레포를 동기화 시킨다.
   - 원격 레포의 커밋들을 다운받는다.
   - git pull origin main

---
# Conflict
- 서로 다른 두개의 local 레포에서 각자의 새로운 commit이 발생하고, 그것을 동시에 원격에 push하려고 할 때 발생
- ![[Pasted image 20241011094412.png]]
- 원격에서 해결이 불가능한 상황
	- github는 정답(올바른 해결 방법)을 몰라요.
- 로컬에서 해결을 해야 합니다.
	- git pull origin main
- 로컬에서 conflict
	- 좋은 코드로 변경하면 끝!
	- 변경사항 => add => commit


---
# branch
- 개별 작업 공간
	- 기능별로 작업 공간을 분리
- git branch {브랜치 이름}
	- 브랜치 이름을 적을 때
		- feature/auth/login
		- feature/auth/logout
		- feature/articles/create
		- hotfix/articles/validation
- git switch {브랜치 이름}
	- 변경사항 - add - commit

- 하나의 프로젝트이기 때문에, 언젠가 브랜치들은 합쳐야 합니다.
- 기준이 되는 branch에서 합치고 싶은 branch를 병합합니다.
	- git merge {합치고 싶은 브랜치}
	- 합친 후, 합쳐진 브랜치는 더이상 필요가 없습니다.
		- git branch -d {삭제할 브랜치}