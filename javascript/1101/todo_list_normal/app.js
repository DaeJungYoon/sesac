// API 베이스 URL
const URL = "http://localhost:3000/todos";

// HTML 요소 선택
const todoInput = document.querySelector("#todo-input");
const addTodoButton = document.querySelector("#add-todo");
const todoList = document.querySelector("#todo-list");

// DOMContentLoaded : HTML 문서 로딩이 끝나면 실행되는 이벤트
// 페이지가 로드되면 Todo 목록 초기화 함수를 실행한다.
document.addEventListener("DOMContentLoaded", initTodos);

// Todo 추가 버튼 클릭 이벤트 리스너
addTodoButton.addEventListener("click", addTodo);

// 개별 Todo 요소를 화면에 그리는 함수
function renderTodo(todo) {
  // 매개변수로 입력받은 Todo 객체로 요소를 생성하고, 목록에 추가한다.
  // 요소에는 Todo 내용 텍스트, Todo 완료 버튼, Todo 삭제 버튼을 추가한다.
  // 완료, 삭제 버튼에 대한 click 이벤트에 적절한 기능을 설정한다.
}

// Todo 목록 초기화 (GET 요청)
async function initTodos() {
  console.log("Hello World");
  // 서버로부터 모든 Todo를 가져와 화면에 표시한다.
  // Todo 목록을 반복해서 개별 Todo를 화면에 그린다. renderTodo()
}

// Todo 추가하기 (POST 요청)
async function addTodo() {
  // 입력 필드에서 새로운 Todo의 내용을 가져와 서버에 저장하고, 해당 요소를 목록에 추가한다.
  // Todo 추가 요청이 정상적으로 끝나면 해당 Todo를 화면에 그린다. renderTodo()
}

// Todo 완료 상태 토글 (PATCH 요청)
async function toggleComplete(id) {
  // 특정 Todo의 완료(completed) 상태를 변경하고, 화면에 반영한다.
  // 상태 변경 후 요소의 completed 클래스를 토글한다.
}

// Todo 삭제하기 (DELETE 요청)
async function deleteTodo(id) {
  // 특정 Todo를 서버에서 삭제하고, 화면에서 제거한다.
  // 삭제가 완료되면, 화면에서 해당 요소를 제거한다.
}
