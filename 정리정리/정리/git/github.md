0. 이미 local에서 git으로 관리되고 있는 폴더가 존재하고, 하나 이상의 commit이 존재.
	1. git init
	2. 변경사항
	3. git add .
	4. git commmit -m "message"
1. github에서 repository 만들기
	1. 빈 공간을 만들었다.
2. local의 git repo / 원격의 repo를 연결
	1. local을 업로드 하기 위해서.
	2. git remote add origin {url}
3. 업로드
	1. git push origin main
	2. origin : url의 별명
	3. main : 업로드할 branch

- local 환경에서 
	- add -> commit
	- 한번더 push