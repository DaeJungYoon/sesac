// fetch('https://jsonplaceholder.typicode.com/posts/1')
// .then((response) => response.json())
// .then((json) => {
//   const title = json.title;
//   console.log(title);
// })
// .catch((error) => console.error(error));

async function getPostById(postId) {
  const response = await fetch(
    `https://jsonplaceholder.typicode.com/posts/${postId}`
  );
  const data = await response.json();
  console.log(data);
  // const title = json.title;
  // console.log(title);
}
async function getPosts() {
  const response = await fetch(`https://jsonplaceholder.typicode.com/posts`);
  const data = await response.json();
  data.forEach((value) => {
    console.log(value.title);
  });
  const titles = data.map((value) => value.title);
  console.log(titles);
  // console.log(data);
  // const title = json.title;
  // console.log(title);
}
getPosts();

async function createPost() {
  try {
    const response = await fetch('https://jsonplaceholder.typicode.com/posts', {
      method: 'POST',
      body: JSON.stringify({
        title: 'foo',
        body: 'bar',
        userId: 1,
      }),
      headers: {
        'Content-type': 'application/json; charset=UTF-8',
      },
    });

    const data = await response.json();
    console.log(data);
  } catch (error) {
    console.error('Error:', error);
  }
}

createPost();