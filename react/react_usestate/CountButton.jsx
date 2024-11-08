import React, { useState } from "react";

export default function CountButton() {
  const [num, setNum] = useState(0);
  return (
    <>

      <button onClick={() => setNum(num - 1)}>decline</button>
      <button onClick={() => setNum(num + 1)}>increaseNum</button>
    </>
  );
}
