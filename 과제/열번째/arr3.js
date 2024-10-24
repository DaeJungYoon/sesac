const matrix = [
  [4, 2],
  [3, 2],
  [5, 7],
  [10, 1],
];
// const n = matrix.length;
// const m = matrix[0].length;
// const newArr = [];
// for (let j = 0; j < m; j++) {
//   sum = 0;
//   for (let i = 0; i < n; i++) {
//     sum += matrix[i][j];
//   }
//   if (sum % 2 === 0) {
//     newArr.push(sum);
//   }
// }
// console.log(newArr);
// const sum2dArray = matrix.filter((nums) => {
//   const n = nums.length;
//   const m = nums[0].length;
//   const newArr = [];
//   for (let j = 0; j < m; j++) {
//     sum = 0;
//     for (let i = 0; i < n; i++) {
//       sum += nums[i][j];
//     }
//     if (sum % 2 === 0) {
//       newArr.push(nums);
//     }
//   }
//   console.log(newArr);
// });

// sum2dArray;
let newArr = matrix.filter((arr) => {
  let total = arr[0] + arr[1];
  return total % 2 === 0;
});
console.log(newArr);
