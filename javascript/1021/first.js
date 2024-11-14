let money = true;
let car = true;

// // money car 조합해서 False가 나오도록

// let result = money != car ? 'T' : 'F';
// let result2 = money != car ? 'T' : 'F';
// console.log(result);

// XOR 러ㅏ는 것은, OR는 OR인테, T - T 쌍인 경우를 제외한 것.

// money || car 이면서 둘 다 트루인 것이 아닌 것
console.log((money || car) && !(money && car));
