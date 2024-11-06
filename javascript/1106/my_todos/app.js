// API 베이스 URL
const URL = 'http://localhost:3000/todos';

// DOMContentLoaded : HTML 문서 로딩이 끝나면 실행되는 이벤트
// 페이지가 로드되면 Todo 목록 초기화 함수를 실행한다.
document.addEventListener('DOMContentLoaded', initTodos); //DOM이 랜더링을 완료하면 initTodos를 해(즉 db를 가져와서 보여줘)

/////////////////////////////////////////
// Todo 생성
/*
  데이터의 관점
   - 데이터를 받아다가 db에 저장한다

  사용자의 관점-참고사항에 불과함
   - 데이터를 입력한다
   - 추가 버튼을 누른다
    -> todo가 추가된다
  
  front의 관점-이 관점만 보면 됨
   - 사용자의 관점 {입력을 받아서 추가버튼을 누르면 (입력값을 받아서 서버에 전달해서)} 
   - 데이터의 관점 {db에 저장을 시키고}
   - 데이터를 rendering한다(데이터를 보여줌)

   
   */
//버튼을 누르면 동작이 실행됨
const addButton = document.querySelector('#add-todo');
addButton.addEventListener('click', addTodo); //addButton에 addEventListener 한다 click 이벤트가 발생하면 동작(함수)이(가) 실행한다

async function addTodo() {
  //fetch는 비동기이기 때문에 async 필요
  // 1.입력을 받아다가 -> 2.db에 저장하고 -> 3.보여준다.
  // (입력값 필요)      ()            ()
  // 현재(input type, #todo-input이 있음)
  // 입력값 => 입력 태그에 입력된 값 따라서 입력태그가 필요
  //1
  const inputTag = document.querySelector('#todo-input');
  const value = inputTag.value;
  // console.log(value); // 입력값이 잘오는지 확인

  // 2
  // value를 가지고 db에 데이터를 저장하고 싶음
  // URL / data / POST method(저장하고 싶으니) 필요
  const response = await fetch(URL, {
    method: 'POST',
    body: JSON.stringify({
      content: value, //동적인 값인 value
      completed: false, //사용자가 입력하는 것이 아닌 내가 입력한 것
    }),
    headers: {
      'Content-type': 'application/json; charset=UTF-8',
    },
  });
  const data = await response.json();
  // console.log(data); //잘 저장되는 지 확인 데이터 베이스도 확인
}
/////////////////////////////////////////

// 초기값 세팅
async function initTodos() {
  // 1. 데이터 가져오기
  const todos = await fetchTodos();

  // 2. 데이터 보여주기
  // liTag 만들고
  const todoListTag = document.querySelector('#todo-list');
  renderTodos(todoListTag, todos); 
  /**
   // renderTodos는 todos를 입력받아서 for문만 돌리는 역할일수도 있음
   //  todos.forEach라고 하는 것이 initTodos에 들어가는 것 보다 감싸진 형태가 좋음
   //  todoListTag 랜더링을 할 때 필요할 수도 있음 but 필요없음
  const todoListTag = document.querySelector('#todo-list'); 이렇게 들어가는 것이 아니라
  renderTodos는 todoListTag, todos를 받는 것이 맞음
1:56:54
   */
  
  /*
  
  // li태그 만들고 todos한테 foreach를 돌리는데 todo가 addTodo() todo를 넣어서 만들지
  // renderToodos는 유지하고 addTodo를 따로 빼서 만들지
  // 원래 코드치기 전에 생각해야하는 문제

   */
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
  // const todoListTag = document.querySelector('#todo-list'); 

  todos.forEach((todo) => {
    renderTodo(todoListTag, todo);
    // //하나의 todo에 대한 tag들
    // const liTag = document.createElement('li');

    // // span => todo에 들어있는 content가 필요함
    // const spanTag = document.createElement('span');
    // const { content } = todo; // content는 todo를 뜯어온 것
    // spanTag.textContent = content; // spantag에 textContent한테 content를 집어 넣음

    // // complete
    // const completeButton = document.createElement('button');
    // completeButton.textContent = '완료';

    // // delete
    // const deleteButton = document.createElement('button');
    // deleteButton.textContent = '삭제';

    // // li에 spanTag, completeButton, deleteButton를 append할 거임
    // liTag.append(spanTag, completeButton, deleteButton);

    // // todoList에 liTga append
    // todoListTag.append(liTag);
  });
}

function renderTodo(todoListTag, todo) {
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
}
