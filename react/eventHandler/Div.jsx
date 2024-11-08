import React from "react";
export default function Div() {
  const divStyle = [
    {
      bgColor: "blue",
      border: "1px solid black",
      width: "100px",
      height: "100px",
    },
  ];
  function eventHandlerColor(e) {
    // console.log("click event 발생");
    // divColor = "black";
    console.log(e.target);
  }
  const realDiv = divStyle.map((css) => {
    let divColor = css.bgColor;
    console.log(eventHandlerColor());
    return (
      <div
        onMouseEnter={eventHandlerColor()}
        style={{
          backgroundColor: divColor,
          width: css.width,
          height: css.height,
          border: css.border,
        }}
      ></div>
    );
  });
  return <>{realDiv};</>;
}
