import React from 'react';
import { Link } from 'react-router-dom';

export default function Header() {
  return (
    <header>
      <ul>
        <li>
          <Link to="/">Home으로</Link>
        </li>

        <li>
          <Link to="/music">Music</Link>
        </li>
        <li>
          <Link to="/music/list">MusicList</Link>
        </li>
      </ul>
    </header>
  );
}
