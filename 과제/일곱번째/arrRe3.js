arr = [0, 1, 2, 3, 4, 5];
for (let index in arr) {
  let arrValue = arr[index];
  if (arrValue % 2 === 0) {
    console.log(arrValue);
  }
}
