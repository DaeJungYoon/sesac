const minNumber = (arr) => {
  let min = Infinity;
  for (i = 0; i <= arr.length; i++) {
    let index = arr[i];
    if (index < min) {
      min = index;
    }
  }
  // console.log(min);
  return min;
};

let newArr = [12, 52, 11, 19, 54];
console.log(newArr);
const minValue = minNumber(newArr);

console.log(minValue);
