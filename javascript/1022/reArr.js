const arr = [];
for (let i = 1; i < 10; i++) {
  let square = i ** 2;
  if (square >= 10 && square <= 50) {
    arr.push(i);
  }
}

console.log(arr);
