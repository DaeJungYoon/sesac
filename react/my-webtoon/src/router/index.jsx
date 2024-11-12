import { createBrowserRouter } from "react-router-dom";
import RootLayout from "../RootLayout";
import WebtoonLayOut from "../WebtoonLayout";
import NovelLayout from "../NovelLayout";
import NotFound from "../page/NotFound";
import Home from "../page/Home";
import Webtoon from "../page/Webtoon";
import Novel from "../page/Novel";
import WebtoonDetail from "../page/WebtoonDetail";
import NovelDetail from "../page/NovelDetail";

const router = createBrowserRouter([
  {
    path: "/",
    element: <RootLayout />,
    errorElement: <NotFound></NotFound>,
    children: [
      { index: true, element: <Home></Home> },
      { path: "/novel", element: <Novel></Novel> },
    ],
  },
  {
    path: "/webtoon",
    element: <WebtoonLayOut />,
    children: [
      { index: true, element: <Webtoon></Webtoon> },
      { path: "/webtoon/:webtoonId", element: <WebtoonDetail></WebtoonDetail> },
    ],
  },
  {
    path: "/novel",
    element: <NovelLayout />,
    children: [
      { index: true, element: <Novel></Novel> },
      { path: "/novel/:novelId", element: <NovelDetail></NovelDetail> },
    ],
  },
]);

export default router;
