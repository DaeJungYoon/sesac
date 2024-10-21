const nums = [1, 2, 3, 4, 5, 6, 7, 8, 9];

for (let index in nums) {
  console.log(index);
  let mul = 3 * nums[index];
  console.log(mul);
}
console.log('-------------------');
