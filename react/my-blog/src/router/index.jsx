import { createBrowserRouter } from 'react-router-dom';
import Home from '../pages/Home';
import PostList from '../pages/PostList';
import Hello from '../pages/Hello';
import RootLayout from '../RootLayout';
import PostDetail from '../pages/PostDetail';
import Music from '../pages/Music';
import MusicList from '../pages/MusicList';
import NotFound from '../pages/NotFound';
import RootLayout2 from '../RootLayout2';

const router = createBrowserRouter([
  {
    path: '/',
    element: <RootLayout />,
    errorElement: <NotFound></NotFound>,
    children: [{ index: true, element: <Home></Home> }],
  },
  {
    // path: '/',
    path: '/posts',
    element: <RootLayout />,
    children: [
      // { index: true, element: <Home></Home> },
      // { path: '/posts', element: <PostList /> },
      { index: true, element: <PostList /> },
      { path: '/posts/:postId', element: <PostDetail /> }, //: 은 변수로 쓰겠다
    ],
  },
  {
    // path: '/',
    path: '/music',
    element: <RootLayout2 />,
    children: [
      // { index: true, element: <Home></Home> },
      // { path: '/music', element: <Music /> },
      { index: true, element: <Music /> },
      { path: '/music/list', element: <MusicList></MusicList> },
    ],
  },
]);

export default router;
