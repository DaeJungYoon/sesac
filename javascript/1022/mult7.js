const newSeven = [];
for (let i = 1; i < 100; i++) {
  if (i % 7 === 0) {
    newSeven.push(i);
  }
}
console.log(newSeven.length);
console.log('---------1--------');

let a = 0;
for (let i = 7; i <= 100; i += 7) {
  a++;
}
console.log(a);
console.log('---------2--------');

let count = 0;
for (let i = 1; i * 7 <= 100; i++) {
  count++;
  continue;
}
console.log(count);
console.log('--------3---------');

count = 0;
for (let i = 1; i <= 100; i++) {
  if (i % 7) continue;
  count++;
}
console.log(count);
console.log('--------4---------');

count = 0;
for (let i = 1; i <= 100; i++) {
  if (i % 7 === 0) {
    count++;
  }
}
console.log(count);
console.log('--------5---------');
