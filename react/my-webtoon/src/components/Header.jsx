import React from "react";
import { Link } from "react-router-dom";

export default function Header() {
  return (
    <header>
      <ul>
        <li>
          <Link to="/">Home으로</Link>
        </li>
        <li>
          <Link to="/webtoon">웹툰</Link>
        </li>
        <li>
          <Link to="/novel">소설</Link>
        </li>
      </ul>
    </header>
  );
}
