import React, { useState } from "react";

export default function InputColor() {
  const [content, setContent] = useState("yellow");
  return (
    <>
      <input
        type="text"
        onChange={(e) => {
          setContent(e.target.value, content);
        }}
      />
      <div
        style={{ width: "100px", height: "100px", backgroundColor: content }}
      ></div>
    </>
  );
}
