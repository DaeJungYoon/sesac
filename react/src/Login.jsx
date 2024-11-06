import React from "react";

export default function Login(props) {
  const { isLogin } = props;
  return <div>{isLogin ? "환영합니다" : "로그인이 필요합니다"}</div>;
}
