// 1.배열
let color = ['red', 'green', 'blue'];
console.log(color); // ['red', 'green', 'blue']
console.log(color[1]); // green

let nums = [1, 2, '3'];
console.log(nums); // [1, 2, '3']
console.log(nums[1]); // 2
console.log(nums[2]); // 3
console.log('--------배열--------');

// 2. 배열 메서드
// 2-1. push(x)
color.push('yellow');
console.log(color); //['red', 'green', 'blue', "yellow"]
console.log('--------push--------');

// 2-2. pop()
color.pop();
console.log(color); // ['red', 'green', 'blue']
let pop_color = color.pop(); // 재사용성을 위해 선언
console.log(pop_color); // blue
console.log('--------pop--------');

// 2-3. unshift(x)
color = ['red', 'green', 'blue'];
color.unshift('black');
console.log(color); // ['black', 'red', 'green', 'blue']
console.log('--------unshift--------');

// 2-4. shift()
color = ['red', 'green', 'blue'];
let shift_color = color.shift();

console.log(color); // ['green', 'blue']
console.log(shift_color); // red
console.log('--------shift--------');

// 2-5. slice(start, end)
color = ['red', 'green', 'blue', 'yellow'];
let slice_color = color.slice(0, 3);

console.log(slice_color); // ['red', 'green', 'blue']
console.log('--------slice--------');

// 3. 객체
let user = {
  name: '김민수',
  age: '39',
  job: 'homeprotector',
}; //user는 3개의 속성을 가짐

console.log(user.name); // 김민수
console.log(user['job']); //homeprotector
user.age = 20;
console.log(user);
// {
//   name: '김민수',
//   age: '20',
//   job: 'homeprotector',
// }

// 4. 집합
// 4-1. Set method
let uniqueValues = new Set(['red', 'blue', 'green', 'blue', 'yellow']); //순서 보장 X
console.log(uniqueValues); //Set(4) { 'red', 'blue', 'green', 'yellow' }

// 4-1-1. add(x)
let uniqueColor = new Set(['red', 'blue', 'green', 'blue', 'yellow']);
uniqueColor.add(2);
uniqueColor.add(3);
uniqueColor.add('blue');
uniqueColor.add('black');
console.log(uniqueColor); //Set(7) { 'red', 'blue', 'green', 'yellow', 2, 3,'black'}

// 4-1-2. has(x)
let colorUnique = new Set(['red', 'blue', 'green', 'yellow', 2, 3, 'black']);
console.log(colorUnique.has('pink')); // false
console.log(colorUnique.has('red')); // true
console.log(colorUnique.has(2)); // true
console.log(colorUnique.has(1)); // false

// 4-1-3. delete()
let colorUniqs = new Set(['red', 'blue', 'green', 'yellow', 2, 3, 'black']);
colorUniqs.delete(2);
colorUniqs.delete('red');
colorUniqs.delete(1); //1을 찾아봤지만 존재하지 않아서 실행X
colorUniqs.delete('pink');
console.log(colorUniqs); //Set(5) { 'blue', 'green', 'yellow', 3, 'black' }
colorUniqs.delete(2);
console.log(colorUniqs); //Set(5) { 'blue', 'green', 'yellow', 3, 'black' }
