arr = [1, 2, 3, 4, 5];

for (let index in arr) {
  let arrIndex = arr[index];
  arrIndex = arrIndex ** 2;
  console.log(arrIndex);
}
