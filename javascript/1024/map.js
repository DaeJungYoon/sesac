const strNumbers = ['1', '2', '3', '4'];
const changeArr = strNumbers.map((num) => {
  // let intNum = parseInt(num);
  // intNum += 1;
  // return intNum;
  // num = parseInt(num);
  // return (num += 1);
  num = parseInt(num);
  num += 1;
  return num;
});
console.log(changeArr);
