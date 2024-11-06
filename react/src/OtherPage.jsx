import React from "react";
import ManagerPage from "./ManagerPage";
import AdminPage from "./AdminPage";
import UserPage from "./UserPage";

function MyPage(props) {
  let { userType } = props;
  // console.log(userType);
  if (userType === "admin") {
    return <AdminPage></AdminPage>;
  } else if (userType === "user") {
    return <UserPage></UserPage>;
  } else if (userType === "manager") {
    return <ManagerPage></ManagerPage>;
  }
}

export default function OtherPage(props) {
  let { userType } = props;
  console.log(userType);
  // if (userType === "admin") {
  //   return (
  //     <>
  //       <h1>MyPage</h1>
  //       <AdminPage></AdminPage>;
  //     </>
  //   );
  // } else if (userType === "user") {
  //   return (
  //     <>
  //       <h1>MyPage</h1>
  //       <UserPage></UserPage>;
  //     </>
  //   );
  // } else if (userType === "manager") {
  //   return (
  //     <>
  //       <h1>MyPage</h1>
  //       <ManagerPage></ManagerPage>;
  //     </>
  //   );
  // }
  return (
    <>
      <h1>mypage</h1>
      <MyPage userType={userType}></MyPage>
    </>
  );
}
