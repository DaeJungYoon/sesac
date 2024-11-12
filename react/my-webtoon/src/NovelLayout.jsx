import React from "react";
import { Outlet } from "react-router-dom";
import NovelHeader from "./components/NovelHeader";

export default function NovelLayout() {
  return (
    <>
      <NovelHeader></NovelHeader>
      <Outlet></Outlet>
      <footer>footer</footer>
    </>
  );
}
