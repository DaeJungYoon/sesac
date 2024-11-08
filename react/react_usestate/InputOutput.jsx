import React, { useState } from "react";

export default function InputOutput() {
  const [content, setContent] = useState(" ");
  return (
    <>
      <input
        type="text"
        onChange={(e) => {
          setContent(e.target.value, content);
        }}
      />
      <div>{content}</div>
    </>
  );
}
