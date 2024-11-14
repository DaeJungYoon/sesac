import React, { useState } from "react";

export default function Insta() {
  const [like, setLike] = useState("Like");
  const [isliked, setIsLiked] = useState(true)
  const [bgColor, setBgColor] = useState("red");
  function changeLike(e) {
    // console.log(e.target.textContent);
    // console.log(like);
    setLike(like === "Like" ? "Like Cancel" : "Like");
    setBgColor(bgColor === "red" ? "gray" : "red");
    // setLike(like === "Like" ? (like = "Like Cancel") : "Like");
    // e.target.value === "Like" ? "Like Cancel" : "Like"
    setIsLiked(prev => !prev)
  }
  return (
    <>
      <div
        onClick={changeLike}
        style={{
          backgroundColor:bgColor,
          width: "100px",
          height: "100px",
        }}
      >
        {like}
        {isliked ? 'like' : "like cancel"}
      </div>
    </>
  );
}
