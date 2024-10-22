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
