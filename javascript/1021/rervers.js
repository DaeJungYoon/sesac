const nums = [10, 6, 8, 5, 4];

const reversedNum = [];

for (let index in nums) {
  let newIndex = nums.length - 1 - index;
  let newValue = nums[newIndex];
  reversedNum.push(newValue);
}
console.log(reversedNum);
