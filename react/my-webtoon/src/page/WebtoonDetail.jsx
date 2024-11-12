import React from "react";
import { useLocation, useParams } from "react-router-dom";

export default function PostDetail() {
  const { webtoonId } = useParams();
  const location = useLocation();

  const { webtoon } = location.state;
  const { day } = webtoon;

  return (
    <div>
      <h3>{day}</h3>
    </div>
  );
}
