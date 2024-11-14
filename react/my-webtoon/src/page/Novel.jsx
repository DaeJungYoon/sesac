import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { Link } from "react-router-dom";

export default function Novel() {
  const navigate = useNavigate();

  const [novels, setNovels] = useState([
    {
      id: "fan",
      genre: "판타지",
    },
    {
      id: "modn",
      genre: "현대소설",
    },
    {
      id: "reasn",
      genre: "추리",
    },
    {
      id: "rom",
      genre: "로맨스",
    },
    {
      id: "sf",
      genre: "공상과학",
    },
  ]);
  return (
    <>
      <div>Novel</div>
      <ul>
        {novels.map((novel) => {
          const { id, genre } = novel;
          return (
            <li key={id}>
              <Link to={`/novel/${id}`} state={{ novel }}>
                <h3>{genre}</h3>
              </Link>
              <h3
                onClick={() => {
                  // 이동을 하고 싶다
                  navigate(`/novel/${id}`);
                }}
              ></h3>
            </li>
          );
        })}
      </ul>
    </>
  );
}
