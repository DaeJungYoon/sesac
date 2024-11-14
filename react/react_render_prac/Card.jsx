import React from "react";

export default function Card(props) {
  const { width, height, border } = props;
  // console.log({ width, height, border });
  return <div style={{ width, height, border }}>Card</div>;
}
