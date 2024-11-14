// API 베이스 URL
const URL = "http://localhost:3000/todos";

// DOMContentLoaded : HTML 문서 로딩이 끝나면 실행되는 이벤트
// 페이지가 로드되면 Todo 목록 초기화 함수를 실행한다.
document.addEventListener("DOMContentLoaded", initTodos);

// Todo 추가 버튼 클릭 이벤트 리스너
addTodoButton.addEventListener("click", addTodo);

// 개별 Todo 요소를 화면에 그리는 함수
function renderTodo(todo) {
}

// Todo 목록 초기화 (GET 요청)
async function initTodos() {
  console.log("Hello World");
}

// Todo 추가하기 (POST 요청)
async function addTodo() {
}

// Todo 완료 상태 토글 (PATCH 요청)
async function toggleComplete(id) {
}

// Todo 삭제하기 (DELETE 요청)
async function deleteTodo(id) {
}
