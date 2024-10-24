const todos = [
  {
    todoId: 1,
    content: '예습하기',
    isCompleted: false,
  },
  {
    todoId: 2,
    content: '강의듣기',
    isCompleted: false,
  },
  {
    todoId: 3,
    content: '복습하기',
    isCompleted: false,
  },
];
// console.log(todos[0]);
// console.log(todos[1]);
// console.log(todos[2]);
// for (i = 0; i < todos.length; i++) {
//   let index = 0;
//   index = todos[i];
//   console.log(index);
// }
// const reArr = todos.filter((value) => {
//   console.log(value);
//   // for (i = 0; i < todos.length; i++) {
//   //   let index = 0;
//   //   index = todos[i];
//   //   console.log(index);
//   // }
// });
const reArr = todos.forEach((value) => {
  console.log(value);
});
reArr;
console.log('-------1-----');
const todos2 = [
  {
    todoId: 1,
    content: '예습하기',
    isCompleted: false,
  },
  {
    todoId: 2,
    content: '강의듣기',
    isCompleted: true,
  },
  {
    todoId: 3,
    content: '복습하기',
    isCompleted: true,
  },
];
const todoCheck = todos2.filter((value) => {
  if (value.isCompleted === true) {
    console.log(value);
  }
});

todoCheck;
