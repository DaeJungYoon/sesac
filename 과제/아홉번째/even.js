const evenNumber = (arr) => {
  let new_arr = [];
  for (i = 0; i <= arr.length; i++) {
    let index = arr[i];
    if (index % 2 === 0) {
      new_arr.push(index);
    }
  }
  return new_arr;
};

let anoArr = [12, 22, 34, 65, 3];
console.log(anoArr);
const evenCheck = evenNumber(anoArr);
console.log(evenCheck);
