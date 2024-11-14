import AdminPage from "./AdminPage";
import UserPage from "./UserPage";

function MyPage(props) {
  let { userType } = props;
  console.log(userType);
  if (userType === "admin") {
    return <AdminPage></AdminPage>;
  } else if (userType === "user") {
    return <UserPage></UserPage>;
  }
}

export default function Page(props) {
  let { userType } = props;
  // if (userType === "admin") {
  //   return (
  //     <>
  //       <h1>MyPage</h1>
  //       <AdminPage></AdminPage>
  //     </>
  //   );
  // } else if (userType === "user") {
  //   return (
  //     <>
  //       <h1>MyPage</h1>
  //       <UserPage></UserPage>
  //     </>
  //   );
  // }
  return (
    <>
      <h1>my app</h1>
      <MyPage userType={userType} />
    </>
  );
}
