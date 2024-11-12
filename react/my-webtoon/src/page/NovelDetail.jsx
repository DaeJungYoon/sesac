import React from "react";
import { useLocation, useParams } from "react-router-dom";

export default function NovelDetail() {
  const { novelId } = useParams();
  const location = useLocation();

  const { novel } = location.state;
  const { gerne } = novel;

  return (
    <div>
      <h3>{gerne}</h3>
    </div>
  );
}
