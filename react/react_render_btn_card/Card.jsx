import React from "react";

export default function Card() {
  const boxCardInfo = [
    { width: "100px", height: "100px", border: "1px solid black" },
  ];
  const boxCard = boxCardInfo.map((info) => {
    return (
      <div
        style={{ width: info.width, height: info.height, border: info.border }}
      >
        Card
      </div>
    );
  });
  return (
    <>
      {boxCard}
      {boxCard}
      {boxCard}
      {boxCard}
    </>
  );
}
