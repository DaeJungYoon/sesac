for (i = 1; i < 9 + 1; i++) {
  console.log(i * 3);
}
console.log('---------for3 단-------');

let nums = 0;
while (nums < 9) {
  nums++;
  console.log(nums * 3);
}
console.log('---------while3 단-------');

const names = ['jun', 'beemo', 'ken', 'lynda'];
for (let index = 0; index < names.length; index++) {
  let name = names[index];
  console.log(index + 1, name);
}
console.log('---------for 출석-------');
