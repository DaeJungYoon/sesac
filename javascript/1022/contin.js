const arr = [1, 2, 4, 3, 3, 5, 5, 6, 9, 7];

const notLogSet = new Set([1, 4, 5, 7]);
for (let num of arr) {
  if (notLogSet.has(num)) continue;

  console.log(num);
}
