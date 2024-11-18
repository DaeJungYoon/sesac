import { createBrowserRouter } from "react-router-dom";
import Home from "../pages/Home";
import PostList from "../pages/PostList";
import Hello from "../pages/Hello";
import RootLayout from "../RootLayout";
import PostDetail from "../pages/PostDetail";
import NotFound from "../pages/NotFound";
import PostCreate from "../pages/PostCreate";
const router = createBrowserRouter([
  {
    path: "/",
    element: <RootLayout />,
    // errorElement: <NotFound />,
    children: [
      {
        index: true,
        element: <Home />,
      },
      {
        path: "/posts",
        element: <PostList />,
      },
      {
        path: "/posts/create",
        element: <PostCreate />,
      },
      {
        path: "/posts/:postId",
        element: <PostDetail />,
      },
    ],
  },
  { path: "/not-found", element: <NotFound></NotFound> },
  // {
  //   path: '/music',
  //   element: <musiclayout></musiclayout>
  // }
]);

export default router;
