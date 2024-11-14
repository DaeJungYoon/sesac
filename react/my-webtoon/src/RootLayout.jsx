import React from "react";
import { Outlet } from "react-router-dom";
import Header from "./components/Header";

export default function RootLayout() {
  return (
    <div>
      <Header></Header>
      <Outlet></Outlet>
      <footer>footer</footer>
    </div>
  );
}
