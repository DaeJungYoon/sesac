// const arr1 = [1, 2, 3, 4, 5];
// const newArr1 = [];
// arr1.map((num) => {
//   newArr1.push(num ** 2);

//   return newArr1;
// });
// console.log(newArr1);

// const arr2 = ['1', '2', '3', '4', '5'];
// // console.log(arr2);
// const newArr2 = [];
// arr2.map((num) => {
//   newArr2.push(Number(num));

//   return newArr2;
// });
// console.log(newArr2);

const arr3 = [
  {
    name: 'jun',
    age: 18,
  },
  {
    name: 'alex',
    age: 28,
  },
  {
    name: 'ken',
    age: 38,
  },
];
const newArr3 = arr3.map((el) => el.age);
// const newArr3 = [];
// for (i = 0; i < arr3.length; i++) {
//   const arrIndex = arr3[i];
//   // console.log(arrIndex.age);
//   newArr3.push(arrIndex.age);
// }
console.log(newArr3);

const arr4 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
const evenArr = arr4.filter((el) => el % 2 === 0);
const evenFiveArr = arr4.filter((el) => el % 2 === 0 && el >= 5);
// const evenArr = [];
// const evenFiveArr = [];
// for (i = 0; i < arr4.length; i++) {
//   const arrIndex = arr4[i];
//   if (arrIndex % 2 === 0) {
//     evenArr.push(arrIndex);
//     if (arrIndex >= 5) {
//       evenFiveArr.push(arrIndex);
//     }
//   }
// }

console.log(evenArr);
console.log(evenFiveArr);

const arr5 = [
  {
    name: 'jun',
    age: 18,
  },
  {
    name: 'alex',
    age: 28,
  },
  {
    name: 'ken',
    age: 38,
  },
  {
    name: 'beemo',
    age: 48,
  },
  {
    name: 'lynda',
    age: 8,
  },
];
const ageThirtyInfoArr = arr5.filter((el) => el.age <= 30);
const ageThirtyNameArr = arr5.filter((el) => el.age <= 30).map((el) => el.name);
// 중첩 메소드 가능
// const ageThirtyNameArr = ageThirtyInfoArr.map((el) => el.name);
// const ageThirtyInfoArr = [];
// const ageThirtyNameArr = [];

// for (i = 0; i < arr5.length; i++) {
//   const arrIndex = arr5[i];
//   // console.log(arrIndex.age);
//   if (arrIndex.age <= 30) {
//     ageThirtyInfoArr.push(arrIndex);
//     ageThirtyNameArr.push(arrIndex.name);
//   }
// }
console.log(ageThirtyInfoArr);
console.log(ageThirtyNameArr);
