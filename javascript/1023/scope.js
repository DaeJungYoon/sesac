const al = 'dl';
let global = '밖';
{
  console.log(al);
  console.log(global);
}
/*
global 환경에서 변수 선언 -> 블럭 안에서 사용
global 환경에서 변수 선언 -> 블럭 안에서 변경
global 환경에서 변수 선언 -> 블럭 밖에서 변경
global 환경에서 변수 선언 -> 블럭 밖에서 사용

global 환경에서 변수 선언 -> 함수 밖에서 사용
global 환경에서 변수 선언 -> 함수 밖에서 변경
global 환경에서 변수 선언 -> 함수 안에서 변경
global 환경에서 변수 선언 -> 함수 안에서 사용
 */


const const2="const2"
let let2="let2"