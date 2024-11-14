function multNum(x) {
  return x * 2;
}
console.log(multNum(3));

function checkPrime(num) {
  let isPrime = true;
  for (let i = 2; i < num; i++) {
    if (num % i === 0) {
      isPrime = false;
      return isPrime; // 효율적인 코드 10까지만 해도 아무런 문제가 없기 때문
    }
  }
  // return isPrime;
}

console.log(checkPrime(6));

function nDan(n) {
  let n_dan = [];
  for (let i = 1; i <= 9; i++) {
    n_dan.push(n * i);
  }
  return n_dan;
}

const gugudan = [];
for (let i = 1; i <= 9; i++) {
  gugudan.push(nDan(i));
}
console.log(nDan(4));
// console.log(gugudan);
