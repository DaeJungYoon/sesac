import React from "react";

export default function Button() {
  const kindOfButton = [
    { text: "확인", backgroundColor: "blue", color: "white" },
    { text: "취소", backgroundColor: "red", color: "white" },
    { text: "보류", backgroundColor: "gray", color: "white" },
    { text: "1억년", backgroundColor: "pink", color: "white" },
  ];
  const realButton = kindOfButton.map((info) => {
    // console.log(info.backgroundColor);
    // console.log(info.color)
    // console.log(info.text);
    // 만약

    // const backgroundColor = info.backgroundColor
    // // 의 형태로 할당을 한다면,
    // // object에 집어 넣을 때 key : value의 형태가 아니라, value의 형태로만으로도 집어넣을 수 있음
    // return <button style={{backgroundColor }}>{info.text}</button>;
    // return <button style={{backgroundColor : backgroundColor}}>{info.text}</button>;
                                                                
    return (
      <button
        style={{ backgroundColor: info.backgroundColor, color: info.color }}
      >
        {info.text}
      </button>
    );
  });
  return <div>{realButton}</div>;
}
