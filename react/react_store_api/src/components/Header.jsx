import React from "react";
import { useDispatch, useSelector } from "react-redux";
import { Link } from "react-router-dom";
import { login, logout } from "../store/slices/authSlice";

export default function Header() {
  const { isLoggedIn } = useSelector((state) => state.auth);
  const dispatch = useDispatch();

  return (
    <header>
      <div>
        <button onClick={() => console.log(isLoggedIn)}>출력</button>
        {isLoggedIn ? (
          <button
            onClick={() => {
              dispatch(logout());
              // 홈으로 보내
            }}
          >
            로그아웃
          </button>
        ) : (
          <button
            onClick={() => {
              dispatch(login());

            }}
          >
            로그인
          </button>
        )}
      </div>
      <ul>
        <li>
          <Link to="/">Home으로</Link>
        </li>
        <li>
          <Link to="/posts">게시글로</Link>
        </li>
        {/* 로그인을 한 경우에만 보여주고 싶어요 */}
        {/* 근데, 보여주는게 좋을 수도 있음. */}
        {isLoggedIn && (
          <li>
            <Link to="/posts/create">게시글 생성</Link>
          </li>
        )}
      </ul>
    </header>
  );
}
