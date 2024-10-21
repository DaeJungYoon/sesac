const names = ['jun', 'beemo', 'ken', 'lynda'];
for (let index in names) {
  // console.log(index);
  let call = names[index];
  // console.log(typeof index);
  index++;
  console.log(index, call);
}

// 객체는 전부 string으로 받아
// index = index + 1;
// index를 스트링으로 인식하고 스트링에 스트링을 더하는 것 아니냐 라고 자바스크립트에서 인식을 함
