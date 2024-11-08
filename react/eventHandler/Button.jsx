import React from "react";

function eventHandlerAlert() {
  return alert("버튼 클릭");
}

export default function Button() {
  return <button onClick={eventHandlerAlert}>button</button>;
}
