// 1.산술 연산자
let a = 1;
let b = 2;
let c = 3;
let d = 4;
c++;
d++;
let e = 3;
let f = 4;

// 1-1. 사칙연산
console.log(a + b); //3
console.log(a - b); //-1
console.log(a * b); //2
console.log(a / b); //0.5 나눗셈한 값
// 1-2. 추가 연산
console.log(c % d); //4 나머지
console.log(f % e); //1 나머지
console.log(a ** b); //1
console.log(c); //4
console.log(d); //5
console.log(Math.floor(9 / 7)); //1 몫

console.log('-----------------------');

// 2. 할당 연산자
// 2-1 할당 연산자
let v = 5; // = 할당:변수에 값을 할당(저장)한다

// 2-2 복합 할당 연산자
x += 2;

console.log(x); //7

//
let y = 2;

y -= 2;

console.log(y); //0

let z = 2;

z *= 2;

console.log(z); //4

let i = 2;

i /= 2;

console.log(i); //1

let n = 2;

n %= 2;

console.log(n); //0

console.log('-----------------------');

// 3. 비교 연산자
console.log(5 == '5'); //ture 사용하지 않는 것을 권장
console.log(5 === '5'); //false
console.log(5 != 5); //false
console.log(5 !== 5); //false
console.log(5 > 5); //false
console.log(5 < 5); //false
console.log(5 >= 5); //ture
console.log(5 <= 5); //ture

console.log('-----------------------');

// 4. 논리연산자
let po = true;
let ho = false;

console.log(po && ho); //false
console.log(po || ho); //true
console.log(!po); //false

console.log(typeof 12); //number
console.log(typeof 'ho'); //string
console.log(typeof po); //boolean

console.log('-----------------------');
