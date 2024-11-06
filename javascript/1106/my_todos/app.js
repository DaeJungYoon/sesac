// API 베이스 URL
const URL = 'http://localhost:3000/todos';

// DOMContentLoaded : HTML 문서 로딩이 끝나면 실행되는 이벤트
// 페이지가 로드되면 Todo 목록 초기화 함수를 실행한다.
document.addEventListener('DOMContentLoaded', initTodos); //DOM이 랜더링을 완료하면 initTodos를 해(즉 db를 가져와서 보여줘)

// 초기값 세팅
async function initTodos() {
  // 1. 데이터 가져오기
  const todos = await fetchTodos();

  // 2. 데이터 보여주기
  renderTodos(todos);
}

//Todos JSON형태로 가져오기(fetchTodos 역할)
async function fetchTodos() {
  const response = await fetch(URL);
  const data = await response.json();
  return data;
}

// todos를 입력받아 보여주기
function renderTodos(todos) {
  //      <li>
  //         <span> todo의 컨텐트 </span>
  //         <button>완료</button>
  //         <button>삭제</button>
  //       </li>
  // 를 만들어서 ul에 push하고 싶음
  const todoListTag = document.querySelector('#todo-list');

  todos.forEach((todo) => {
    //하나의 todo에 대한 tag들
    const liTag = document.createElement('li');

    // span => todo에 들어있는 content가 필요함
    const spanTag = document.createElement('span');
    const { content } = todo; // content는 todo를 뜯어온 것
    spanTag.textContent = content; // spantag에 textContent한테 content를 집어 넣음

    // complete
    const completeButton = document.createElement('button');
    completeButton.textContent = '완료';

    // delete
    const deleteButton = document.createElement('button');
    deleteButton.textContent = '삭제';

    // li에 spanTag, completeButton, deleteButton를 append할 거임
    liTag.append(spanTag, completeButton, deleteButton);

    // todoList에 liTga append
    todoListTag.append(liTag);
  });
}
