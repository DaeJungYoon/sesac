## 실습

- `Post` entity에 대해
	- @NotBlank, @Size(max=20), @Pattern(regxp="정규식")
    - 제목 : 값이 있어야하고 최대 20글자
	- @NotBlank, @Size(min=5), @Pattern(regxp="정규식")
	- 내용 : 값이 있어야하고 최소 5글자
	- @Length(min=2, max=6), @Pattern(regxp="정규식")
    - 작가 : null을 허용하며 2 ~ 6글자