
| Tag Name         | Description                                                           | body                                     | footer                                      |
| ---------------- | --------------------------------------------------------------------- | ---------------------------------------- | ------------------------------------------- |
| Feat             | 새로운 기능을 추가                                                            | 본문은 한 줄당 72자 내로 작성한다.                    | 이슈 트래커 ID를 작성한다.                            |
| Fix              | 버그 수정                                                                 | 양에 구애받지 않고 최대한 상세히 작성한다.                 | "유형: #이슈 번호" 형식으로 작성한다.                     |
| Design           | CSS 등 사용자 UI 디자인 변경                                                   | 어떻게 변경했는지 보다 무엇을 변경했는지 또는 왜 변경했는지를 설명한다. | Fixes: 이슈 수정 중 (아직 해결되지 않은 경우)              |
| !BREAKING CHANGE | 커다란 API 변경의 경우                                                        | 어떻게 변경했는지 보다 무엇을 변경했는지 또는 왜 변경했는지를 설명한다. |                                             |
| !HOTFIX          | 급하게 치명적인 버그를 고쳐야하는 경우                                                 | 어떻게 변경했는지 보다 무엇을 변경했는지 또는 왜 변경했는지를 설명한다. |                                             |
| Refactor         | 프로덕션 코드 리팩토링                                                          | 어떻게 변경했는지 보다 무엇을 변경했는지 또는 왜 변경했는지를 설명한다. | Resolves: 이슈를 해결한 경우                        |
| Comment          | 필요한 주석 추가 및 변경                                                        | 어떻게 변경했는지 보다 무엇을 변경했는지 또는 왜 변경했는지를 설명한다. | Related to: 해당 커밋에 관련된 이슈 번호(아직 해결되지 않은 경우) |
| Docs             | 문서 수정                                                                 | 어떻게 변경했는지 보다 무엇을 변경했는지 또는 왜 변경했는지를 설명한다. | 여러 개의 이슈 번호를 적을 때는 쉼표(,)로 구분한다.             |
| Test             | 테스트 코드, 리펙토링 테스트 코드 추가, Production Code(실제로 사용하는 코드) 변경 없음            | 어떻게 변경했는지 보다 무엇을 변경했는지 또는 왜 변경했는지를 설명한다. | Ref: 참고할 이슈가 있을 경우                          |
| Chore            | 빌드 업무 수정, 패키지 매니저 수정, 패키지 관리자 구성 등 업데이트, Production Code 변경 없음, 기타 등등 | 어떻게 변경했는지 보다 무엇을 변경했는지 또는 왜 변경했는지를 설명한다. | Ref: 참고할 이슈가 있을 경우                          |
| Rename           | 파일 혹은 폴더명을 수정하거나 옮기는 작업만인 경우                                          | 어떻게 변경했는지 보다 무엇을 변경했는지 또는 왜 변경했는지를 설명한다. | ex) Fixes: #45 Related to: #34, #23         |
| Remove           | 파일을 삭제하는 작업만 수행한 경우                                                   | 어떻게 변경했는지 보다 무엇을 변경했는지 또는 왜 변경했는지를 설명한다. | ex) Fixes: #45 Related to: #34, #23         |


