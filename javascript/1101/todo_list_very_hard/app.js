// API 베이스 URL
const URL = 'http://localhost:3000/todos';

const todoList = document.querySelector('#todo-list');
const todoInput = document.querySelector('#todo-input');
const addTodoButton = document.querySelector('#add-todo');
// DOMContentLoaded : HTML 문서 로딩이 끝나면 실행되는 이벤트
// 페이지가 로드되면 Todo 목록 초기화 함수를 실행한다.
// document.addEventListener('DOMContentLoaded', initTodos);

// async function initTodos() {
//   console.log('Hello World');
// }

async function getTodos() {
  //   <li>
  //   <span>todo의 컨텐트</span>
  //   <button>완료</button>
  //   <button>삭제</button>
  // </li>
  // 를 만들어다가
  // ul에 push하고 싶다.
  try {
    const response = await fetch(URL);
    const todos = await response.json();
    return todos;
  } catch (error) {
    console.log('Error', error);
  }
}
// get을 사용해서 데이터를 가져옴 V

async function getTodosExample() {
  const response = await getTodos();

  // const createTodoList = document.createElement('li');
  // createTodoList.textContent = response.content;
  // todoList.appendChild(createTodoList);

  for (let i = 0; i < response.length; i++) {
    const createTodoList = document.createElement('li');
    //요소를 생성하고 V
    createTodoList.textContent = response[i].content;
    //그 요소에 데이터를 집어 넣고?
    todoList.appendChild(createTodoList);
    //데이터 집어넣은 요소를 todolist에 추가
  }
}
document.addEventListener('DOMContentLoaded', getTodosExample);
