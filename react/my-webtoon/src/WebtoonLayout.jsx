import React from "react";
import { Outlet } from "react-router-dom";
import WebtoonHeader from "./components/WebtoonHeader";

export default function WebtoonLayout() {
  return (
    <>
      <WebtoonHeader></WebtoonHeader>
      <Outlet></Outlet>
      <footer>footer</footer>
    </>
  );
}
