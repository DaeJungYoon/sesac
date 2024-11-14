import Button from "./Button";
import Card from "./Card";

function App() {
  const names = ["김철수", "이영희", "박민수", "정지원", "최동욱"];
  const divNames = names.map((name) => {
    return (
      <ul>
        <li>{name}</li>
      </ul>
    );
  });

  const users = [
    { id: 1, name: "김철수", age: 25, hobby: "독서" },
    { id: 2, name: "이영희", age: 28, hobby: "요리" },
    { id: 3, name: "박민수", age: 23, hobby: "게임" },
  ];
  const divUsers = users.map((user) => {
    // console.log(user);
    return (
      <li>
        <div>id:{user.id}</div>
        <div>name: {user.name}</div>
        <div>age: {user.age}</div>
        <div>hobby: {user.hobby}</div>
      </li>
    );
  });
  // const divUsers = users.map((user) => {
  // const {id, name, age, hobby} = user
  //   return (
  // <li>
  //   <div>id:{id}</div>
  //   <div>name: name}</div>
  //   <div>age: age}</div>
  //   <div>hobby: hobby}</div>
  // </li>
  //   );
  // });
  const products = [
    { id: 1, name: "노트북", price: 55000 },
    { id: 2, name: "마우스", price: 15000 },
    { id: 3, name: "키보드", price: 45000 },
    { id: 4, name: "마우스패드", price: 8000 },
    { id: 5, name: "모니터", price: 150000 },
  ];
  const thirtyUsdProduct = products
    .filter((products) => {
      // console.log(thirty);
      return products.price >= 30000;
      // console.log(thirty);
    })
    .map((products) => {
      return (
        <li>
          <div>제품:{products.name}</div>
          <div>가격:{products.price}원</div>
        </li>
      );
    });

  const imgUrls = [
    "https://images.dog.ceo/breeds/gaddi-indian/Gaddi.jpg",
    "https://images.dog.ceo/breeds/terrier-westhighland/n02098286_3154.jpg",
    "https://images.dog.ceo/breeds/malamute/n02110063_16752.jpg",
    "https://images.dog.ceo/breeds/bulldog-english/jager-2.jpg",
  ];

  const jpgPng = imgUrls.map((photo) => {
    return <img src={photo} />;
  });

  return (
    <>
      <ul>{divNames}</ul>
      <ul>{divUsers}</ul>
      <ul>{thirtyUsdProduct}</ul>
      <div>{jpgPng}</div>
      <Button></Button>
      <Card></Card>
    </>
  );
}
export default App;
