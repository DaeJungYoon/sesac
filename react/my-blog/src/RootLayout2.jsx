import React from 'react';
import { Outlet } from 'react-router-dom';
import Header from './components/Header';
import MusicHeader from './components/MusicHeader';

export default function RootLayout2() {
  return (
    <>
      <MusicHeader></MusicHeader>
      <Outlet></Outlet>
      <footer>footer</footer>
    </>
  );
}
