const maxNumber = (arr) => {
  let max = -Infinity;
  for (i = 0; i <= arr.length; i++) {
    let index = arr[i];
    if (index > max) {
      max = index;
    }
  }
  // console.log(max);
  return max;
};

let newArr = [12, 52, 11, 19, 54];
console.log(newArr);
const maxValue = maxNumber(newArr);

console.log(maxValue);
