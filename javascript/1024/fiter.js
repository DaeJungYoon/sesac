const nums = [2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13];
// filter를 가지고 소수 만 모아보기

const evenNumbers = nums.filter((num) => {
  let isPrime = true;
  for (let i = 2; i < num; i++) {
    if (num % i === 0) {
      isPrime = false;
    }
  }
  return isPrime;
}, 0);
console.log(evenNumbers);
