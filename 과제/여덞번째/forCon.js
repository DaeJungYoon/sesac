let arr = [1, 9, 3, 11, 4, 5, 2, 7];

for (i = 1; i <= arr.length; i++) {
  let index = arr[i];

  if (index % 2 === 0) continue;
  console.log(arr[i]);
}
