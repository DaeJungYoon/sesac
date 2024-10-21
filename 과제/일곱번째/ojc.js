let person = {
  name: '홍길동',
  age: 30,
  job: '개발자',
}
for (let key in person) {
  console.log(`${key}:${person[key]}`);
}
