import React from "react";

export default function LoginNeces(props) {
  const { isLogin } = props;
  // if (isLogin) {
  //   return null;
  // }
  // return <div>로그인이 필요합니다.</div>;
  // return <div>{isLogin ? null : "로그인이 필요합니다"}</div>;
  return <div>{!isLogin && "로그인이 필요합니다"}</div>;
}
