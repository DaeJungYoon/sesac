import React from "react";
import { Link } from "react-router-dom";

export default function WebtoonHeader() {
  return (
    <header>
      <ul>
        <li>
          <Link to="/">Home으로</Link>
        </li>
        <li>
          <Link to="/webtoon/sun">일요일</Link>
        </li>
        <li>
          <Link to="/webtoon/mon">월요일</Link>
        </li>
        <li>
          <Link to="/webtoon/tus">화요일</Link>
        </li>
        <li>
          <Link to="/webtoon/wen">수요일</Link>
        </li>
        <li>
          <Link to="/webtoon/thr">목요일</Link>
        </li>
        <li>
          <Link to="/webtoon/fri">금요일</Link>
        </li>
        <li>
          <Link to="/webtoon/sat">토요일</Link>
        </li>
        <li>
          <Link to="/novel">소설</Link>
        </li>
      </ul>
    </header>
  );
}
