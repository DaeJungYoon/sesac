let number1 = 2;
console.log(number1);
if (typeof number1 === 'number') {
  if (number1 < 10) {
    console.log('number1은 10보다 작다');
  } else if (number1 > 10) {
    console.log('number1은 10보다 크다');
  } else if (number1 === 10) {
    console.log('number1은 10이다');
  }
} else {
  console.log('숫자가 아니다');
}

let number2 = "hello world"
console.log(number2);
if (typeof number2 === 'number') {
  if (number2 < 10) {
    console.log('number2은 10보다 작다');
  } else if (number2 > 10) {
    console.log('number2은 10보다 크다');
  } else if (number2 === 10) {
    console.log('number2은 10이다');
  }
} else {
  console.log('숫자가 아니다');
}