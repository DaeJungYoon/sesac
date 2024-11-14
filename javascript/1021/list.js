const names = ['jun', 'beemo', 'ken'];
const ages = [18, 28, 37];

for (let index in (names, ages)) {
  let name = names[index];
  let age = ages[index];
  // console.log(name, age);
  console.log(`${age}살 ${name}`);
}

// 18살 jun
// 28살 beemo
// 37살 ken
// 을 출력하시오.
