const nums = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9],
];

//[12, 15, 18]이것을 만들거야
/* 
  배열을 만들고
  12를 만들고
  배열에 넣고
  15를 만들고
  배열에 넣고
  18를 만들고
  배열에 넣는다

*/
let newArr = [];
let sum1 = 0;
let sum2 = 0;
let sum3 = 0;

sum1 += nums[0][0];
sum1 += nums[1][0];
sum1 += nums[2][0];
//----------12----------

sum2 += nums[0][1];
sum2 += nums[1][1];
sum2 += nums[2][1];
//----------15----------

sum3 += nums[0][2];
sum3 += nums[1][2];
sum3 += nums[2][2];
//----------18----------

newArr.push(sum1, sum2, sum3);
// console.log(newArr);

let newArr1 = [];

let sum = 0;

sum = 0;
sum += nums[0][0];
sum += nums[1][0];
sum += nums[2][0];
newArr1.push(sum);
//----------12----------

sum = 0;
sum += nums[0][1];
sum += nums[1][1];
sum += nums[2][1];
newArr1.push(sum);
//----------15----------

sum = 0;
sum += nums[0][2];
sum += nums[1][2];
sum += nums[2][2];
newArr1.push(sum);
//----------18----------

console.log(newArr1);



// let arr;
// for (let i in nums) {
//   let arr = nums[i];
//   for (let j in arr) {
//     let num = arr[j];
//     console.log(num);
//   }
// }

// let n = nums.length;
// let m = nums[0].length;
// const ne = [];
// for (let i = 0; i < n; i++) {
//   let sum = 0;
//   for (let j = 0; j < m; j++) {
//     //  console.log(nums[i][j]);
//     // console.log(sum);
//     // sum += nums[i][j];
//     sum += nums[i][j];
//   }
//   console.log(sum);
//   ne.push(sum);
// }
// // console.log(ne);
// let n = nums.length;
// let m = nums[0].length;
// const ne = [];
// for (let i = 0; i < n; i++) {
//     let sum = 0;
//   for (let j = 0; j < m; j++) {
//     //  console.log(nums[i][j]);
//     // console.log(sum);
//     // sum += nums[i][j];
//     sum += nums[i][j];
//   }
//   console.log(sum);
//   ne.push(sum);
// }
// console.log(ne);
