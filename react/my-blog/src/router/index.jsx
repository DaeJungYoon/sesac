import { createBrowserRouter } from "react-router-dom";
import Home from "../pages/Home";
import PostList from "../pages/PostList";
import Hello from "../pages/Hello";
import RootLayout from "../RootLayout";

const router = createBrowserRouter([
  {
    path: "/",
    element: <RootLayout />,
    children: [
      { index: true, element: <Home></Home> },
      { path:"/posts", element: <PostList /> },
    ],
  },
]);

export default router;
