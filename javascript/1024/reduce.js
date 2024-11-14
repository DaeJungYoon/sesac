const num = [5, 8, 2, 5, 9, 4];
// minValue를 reduce를 통해 계산하시오.

const minValue = num.reduce((acc, cur) => {
  let minNumber = acc;
  if (minNumber > cur) {
    minNumber = cur;
  }
  return minNumber;
}, Infinity);
console.log(minValue);
