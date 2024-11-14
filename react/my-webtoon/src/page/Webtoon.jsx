import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { Link } from "react-router-dom";

export default function Webtoon() {
  const navigate = useNavigate();

  const [webtoons, setWebtoons] = useState([
    {
      id: "sun",
      day: "일요일",
    },
    {
      id: "mon",
      day: "월요일",
    },
    {
      id: "tus",
      day: "화요일",
    },
    {
      id: "wen",
      day: "수요일",
    },
    {
      id: "thr",
      day: "목요일",
    },
    {
      id: "fri",
      day: "금요일",
    },
    {
      id: "sat",
      day: "토요일",
    },
  ]);
  return (
    <>
      <div>Webtoon</div>
      <ul>
        {webtoons.map((webtoon) => {
          const { id, day } = webtoon;
          return (
            <li key={id}>
              <Link to={`/webtoon/${id}`} state={{ webtoon }}>
                <h3>{day}</h3>
              </Link>
              <h3
                onClick={() => {
                  // 이동을 하고 싶다
                  navigate(`/webtoon/${id}`);
                }}
              ></h3>
            </li>
          );
        })}
      </ul>
    </>
  );
}
