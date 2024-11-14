import React from "react";
import { Link } from "react-router-dom";

export default function NovelHeader() {
  return (
    <header>
      <ul>
        <li>
          <Link to="/">Home으로</Link>
        </li>
        <li>
          <Link to="/novel/fan">판타지</Link>
        </li>
        <li>
          <Link to="/novel/mord">현대</Link>
        </li>
        <li>
          <Link to="/novel/reasn">추리</Link>
        </li>
        <li>
          <Link to="/novel/romen">로맨스</Link>
        </li>
        <li>
          <Link to="/novel/sf">SF</Link>
        </li>
        <li>
          <Link to="/webtoon">웹툰</Link>
        </li>
      </ul>
    </header>
  );
}
