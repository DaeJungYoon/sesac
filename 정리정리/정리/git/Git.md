

1. git init은 바탕화면, c드라이브 등 일상적으로 쓰는 공간에서는 하지 않는다.
	1. 우리가 사용하는 프로젝트 폴더에서만 사용한다.
2. gitinit은 중첩하여 실행하지 않는다
	1. a폴더를 git으로 관리하는 도중, a폴더 안의 b폴더에서 git init하지 않는다.
---
- git으로 관리 시작
	- 관리하고 싶은 폴더에서 최초 1회
	- `git init`
- 저장을 하고 싶음.
- 변경 사항을 만든다.
	- `touch b.txt`
	- 직접 수정을 하든
- 변경 사항을 staging area에 올립니다
	- `git add b.txt`
	- `git add . `
		- 현재 폴더 전체 add
	- add 후
		- `git diff head`
		- 변경 사항 추적
- 변경 사항을 저장합니다.
	- `git commit -m 'b.txt'`

- 커밋 기록 확인
	- git log
	- git log --oneline
		- 한 줄로 보여줌
	- git log -n
		- n개만 보여줌
- 수시로 파일들 관리 상태 확인
	- git status



