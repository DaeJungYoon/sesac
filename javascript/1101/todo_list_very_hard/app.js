// API 베이스 URL
const URL = 'http://localhost:3000/todos';

// DOMContentLoaded : HTML 문서 로딩이 끝나면 실행되는 이벤트
// 페이지가 로드되면 Todo 목록 초기화 함수를 실행한다.
document.addEventListener('DOMContentLoaded', initTodos);

async function initTodos() {
  console.log('Hello World');
}


// export const getTodos = function () {};

async function getTodos() {
  // const daejung = 'a';
  // console.log(daejung);
  try {
    const response = await fetch(URL);
    const todos = await response.json();
    return todos;
  } catch (error) {
    console.log('Error', error);
  }
}
async function getTodosExample() {
  let response = await getTodos();
  console.log(response);  
}
