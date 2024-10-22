for (let i = 1; i < 9 + 1; i++) {
  console.log(i * 3);
}
console.log('---------for 3단-------');

let nums = 0;
while (nums < 9) {
  nums++;
  console.log(nums * 3);
}
console.log('---------while 3단-------');

const names = ['jun', 'beemo', 'ken', 'lynda'];
for (let index = 0; index < names.length; index++) {
  let name = names[index];
  console.log(index + 1, name);
}
console.log('---------for 출석-------');

let index = 0;
while (index < names.length) {
  let name = names[index];
  console.log(index + 1, name);
  index++;
}
console.log('---------while 출석-------');

const names1 = ['jun', 'beemo', 'ken'];
const ages = [18, 28, 37];
for (let i = 0; i < 3; i++) {
  let name1 = names1[i];
  let age = ages[i];
  console.log(age, name1);
}
console.log('---------for 나이-------');

let i = 0;
while (i < 3) {
  let name2 = names1[i];
  let age2 = ages[i];
  console.log(age2, name2);
  i++;
}
console.log('---------while 나이-------');

let total = 0;
const nums1 = [1, 2, 3, 4, 5, 6, 7, 8, 9];
for (let i = 0; i < nums1.length; i++) {
  let index = nums1[i];
  // console.log(index);
  // console.log(total);
  total += index;
}
console.log(total);
console.log('---------for 합계------');

const nums2 = [1, 2, 3, 4, 5, 6, 7, 8, 9];
let total2 = 0;
let p = 0;
while (p < nums2.length) {
  let index1 = nums2[p];
  p++;
  total2 += index1;
}
console.log(total2);
console.log('---------while 합계-------');
