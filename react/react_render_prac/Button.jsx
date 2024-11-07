import React from "react";

export default function Button({ backgroundColor, color = "white", text }) {
  return <button style={{ backgroundColor, color }}>{text}</button>;
}
