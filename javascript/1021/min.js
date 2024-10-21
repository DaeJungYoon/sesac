const nums = [10, 6, 8, 5, 4, 2, 3, 11];
let minNum = Infinity;
for (num of nums) {
  if (minNum > num) {
    minNum = num;
  }
}

console.log(minNum);
