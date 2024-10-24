let arr = [1, 3, 5, -3, 9, 10, 23, -6, 44, 22, -10, 5, 20];

const plusNum = arr.forEach((num) => {
  if (num > 0) {
    console.log(num);
  }
});
console.log('----------1----------');

const multNum = arr.map((num) => {
  let mult = num * 2;
  console.log(mult);
  return mult;
});
console.log('----------2----------');

const plusOdNum = arr.filter((num) => {
  if (num > 0 && num % 2 === 1) {
    console.log(num);
  }
});
console.log('----------3----------');

