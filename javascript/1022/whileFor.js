let num = 2;
while (true) {
  console.log(num);
  num += 2;
  if (num === 10) {
    break;
  }
}
console.log('------------------');
for (let num2 = 2; num2 < 10; num2 += 2) {
  console.log(num2);
}
console.log('------------------');

const arr = [2, 3, 5, 1, 3];

while (arr.length) {
  el = arr.pop();
  console.log(el);
}
if ([]) {
  console.log('빈 arr도 true다.');
}
// for (arr = arr[0]; arr < arr[arr.length]; arr.pop()) {
//   console.log(arr);
// }
