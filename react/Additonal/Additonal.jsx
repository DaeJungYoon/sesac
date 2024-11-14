import React, { useState } from "react";

export default function Additional() {
  const [twoValue, setTwoValue] = useState({
    x: 0,
    y: 0,
  });
  return (
    <>
      <button
        onClick={() => {
          twoValue.x += 1;
          console.log(twoValue);
        }}
      >
        x +, 작동 X
      </button>
      <button
        onClick={() => {
          setTwoValue({
            x: twoValue.x + 1,
            y: twoValue.y,
          });
        }}
      >
        x +, 작동 O
      </button>
      <button
        onClick={() => {
          setTwoValue({
            ...twoValue,
            x: twoValue.x + 1,
          });
        }}
      >
        x +, 작동 O, spread
      </button>
      <button onClick={() => console.log(twoValue)}>출력</button>
      <div>x : {twoValue.x}</div>
      <div>y : {twoValue.y}</div>
    </>
  );
}
