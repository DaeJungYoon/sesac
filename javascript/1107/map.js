map
[x, y, z] => [f(x), f(y), f(z)]
f(..)를 모아서 새로운 array를 만든다.
arr1.map((el)=>{
  f: 무언가의 기능을 하는 것
  return el + 1
  //return f(el)
})
함수가 아닌 함수의 결과값을 넣을 수는 없다.


filter
[x, y, z] => f(x), f(y), f(z) => [x,z]
f(..)의 결과가 T인 경우만 모아서 새로운 array를 만든다.


const arr= ['1','2','3','4','5']
arr.map(parseInt)