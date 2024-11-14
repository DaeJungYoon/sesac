let a = 5;
let b = 2;

let tmp = a;
a = b;
b = tmp;

console.log(a, b);

let n1 = 5;
let n2 = 2;

if (n1 > n2) {
  let tmp = n1;
  n1 = n2;
  n2 = tmp;
}

let total = 0;
for (let i = n1; i <= n2; i++) {
  total += i;
}
console.log(total);
