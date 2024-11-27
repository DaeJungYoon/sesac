
# 0. [movies world git init](https://github.com/DaeJungYoon/Movie-world/commit/414e3a8dc0e7f2302986f8d4634a67fa5ed670a4 "movies world git init")

```
npm create vite@latest movies-world -- --template react
cd movies-world
npm i @reduxjs/toolkit react-redux
npm i react-router-dom axios
```
후 기본적인 파일 추가 후 정리
했지만 나중엔 npm i 도 나누어 세분화하여 commit 남기면 좋을 듯 함
# 1.[[feat]RootLayout 파일 추가 #1](https://github.com/DaeJungYoon/Movie-world/commit/011329271fd6c769c1d5b782cc93328b365789f3 "[feat]RootLayout 파일 추가 #1")
RootLayout.jsx
```
@@ -0,0 +1,13 @@
import React from "react";
import { Outlet } from "react-router-dom";
import Header from "./components/Header";

export default function RootLayout() {
  return (
    <>
      <Header></Header>
      <Outlet></Outlet>
      <footer>footer</footer>
    </>
  );
}
```
헤더와 footer는 한 두 페이지 빼고는 동일하게 사용하기 위해 레이아웃 구현
# 2. [[rename]components/Mainpage.jsx와 pages/Header.jsx 파일 위치 변경 #2](https://github.com/DaeJungYoon/Movie-world/commit/3d6bb832eacf02e1367dd5a700fd744b3632d806 "[rename]components/Mainpage.jsx와 pages/Header.jsx 파일 위치 변경 #2")
왜 이렇게 했냐? 
=> 컴포넌트 폴더에는 헤더 페이지 폴더에 메인페이지가 들어가는 것이 자연스럽기 때문
커밋 내용 그대로입니다
# 3. [[rename]components/Mainpage.jsx와 pages/Header.jsx 파일 위치 변경 #3](https://github.com/DaeJungYoon/Movie-world/commit/8b94da7b6596be8263b797d3cc022c3b2edce627 "[rename]components/Mainpage.jsx와 pages/Header.jsx 파일 위치 변경 #3")
3번과 동일한 이유
# 4. [[feat]MainPage 임시 구현 #4](https://github.com/DaeJungYoon/Movie-world/commit/790755d7d3f19f347e801e8c033196009a8ae595 "[feat]MainPage 임시 구현 #4")
```
@@ -0,0 +1,36 @@
import React from "react";

export default function MainPage() {
  return (
    <>
      <h1>Movie World</h1>
      <ul>
        <li>
          <h3>현재 상영중</h3>
        </li>
        <li>
          <img src="./preImg.png"></img>
          <p>제목</p>
        </li>
      </ul>
      <ul>
        <li>
          <h3>인기있는 영화</h3>
        </li>
        <li>
          <img src="./preImg.png"></img>
          <p>제목</p>
        </li>
      </ul>
      <ul>
        <li>
          <h3>영화 순위</h3>
        </li>
        <li>
          <img src="./preImg.png"></img>
          <p>제목</p>
        </li>
      </ul>
    </>
  );
}
```
메인페이지가 잘 나오는 지와 메인페이지에 대충 어떻게 나와야하는 지 보기 위해 작성 및 생성
# 5. [[feat]Now Playing Movie 정보 받아오는 api 구현하기 #5](https://github.com/DaeJungYoon/Movie-world/commit/deee1861fe0079678486de4f6da649ad9f721c52 "[feat]Now Playing Movie 정보 받아오는 api 구현하기 #5")
nowPlayingApi.jsx
```
@@ -0,0 +1,18 @@
import api from "./nowPlayingAxios";

const nowPlayingApi = {
  getNowPlaying: async () => {
    const resposne = await api.get("");
    return resposne.data;
  },
  // getNowPlayingById: async (postId) => {
  //   const response = await api.get(`/${postId}`);
  //   return response.data;
  // },
  // createNowPlaying: async (data) => {
  //   const resposne = await api.post("", data);
  //   return resposne.data;
  // },
};

export default nowPlayingApi;
```
nowPlayingAxios.jsx
```
@@ -0,0 +1,11 @@
import axios from "axios";

const instance = axios.create({
  baseURL:
    "https://api.themoviedb.org/3/movie" +
    "/now_playing" +
    import.meta.env.VITE_API_KEY +
    import.meta.env.VITE_API_LANG,
});

export default instance;
```
메인페이지에서 api 정보를 활용하여 각 카테고리 별 포스터와 이미지를 렌더링을 하기 위해
# 6. [[feat] 임시 카테고리 컴포넌트 구현 #6](https://github.com/DaeJungYoon/Movie-world/commit/b89490f45217ed9385673f415997e79ea4059283 "[feat] 임시 카테고리 컴포넌트 구현 #6")
MovieKategorie.jsx
```
@@ -0,0 +1,66 @@
import React, { useEffect, useState } from "react";
import { useSelector } from "react-redux";
import { Link, useNavigate } from "react-router-dom";
import axios from "axios";
import postApi from "../api/postsApi";

export default function MovieKategorie() {
  const navigate = useNavigate();
  const [nowPlaying, setNowPlaying] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    async function fetchNowPlay() {
      try {
        const data = await postApi.getNowPlay();

        setNowPlaying(data);
      } catch (err) {
        setError(err.message);

        console.error(err);
        console.log("에러남 ㅠㅠ");
      } finally {
        setLoading(false);
      }
    }

    fetchNowPlay();
  }, []);

  if (loading) {
    return <div>로딩중</div>;
  }

  if (error) {
    return <div>{error}</div>;
  }

  return (
    <div>
      <h2>NowPlay</h2>
      <ul>
        {nowPlaying.map((nowPlay) => {
          const { id, title, poster_path } = nowPlay;
          return (
            <li key={id}>
              {/* <Link to={`/posts/${id}`} state={{ nowPlay }}>
                <h3>{title}</h3>
              </Link>
              <h3
                onClick={() => {
                  navigate(`/posts/${id}`);
                }}
              >
                {title}
              </h3> */}
              <img src={poster_path} />
              <h4>{title}</h4>
            </li>
          );
        })}
      </ul>
    </div>
  );
}
```
컴포넌트를 만들어서 메인페이지에서 각 카테고리 별로 재활용하기 위해
# 7. [[feat] 임시 카테고리 컴포넌트 메인페이지에 렌더링 #7](https://github.com/DaeJungYoon/Movie-world/commit/cfe0e09fa4136ce4a1cae2b18155fa864ac083d4 "[feat] 임시 카테고리 컴포넌트 메인페이지에 렌더링 #7")
MainPage.jsx
```
import React from "react";
import MovieKategorie from "./MovieKategorie";

export default function MainPage() {
return (
<>
<h1>Movie World</h1>
      <ul>
        <li>
          <h3>현재 상영중</h3>
        </li>
        <li>
          <img src="./preImg.png"></img>
          <p>제목</p>
        </li>
      </ul>
      <MovieKategorie></MovieKategorie>
<ul>
<li>
<h3>인기있는 영화</h3>
</li>
<li>
<img src="./preImg.png"></img>
<p>제목</p>
</li>
</ul>
<ul>
<li>
<h3>영화 순위</h3>
</li>
<li>
<img src="./preImg.png"></img>
<p>제목</p>
</li>
</ul>
</>
);
}
```
원하는대로 렌더링이 되는지 확인하기 위해 
# 8. [[fix] import가 잘못되었다는 오류 발생 후 MovieKategorie.jsx에서 잘못 가져온 api와 import 그리고 리스트를 가져오는 16번 라인 getNowPlay()에서 getNowPlaying()으로 수정 Resolves:#8](https://github.com/DaeJungYoon/Movie-world/commit/d534835b7f788e0f3d929a139af8f81d912e9182 "[fix] import가 잘못되었다는 오류 발생 후 MovieKategorie.jsx에서 잘못 가져온 api와 import 그리고 리스트를 가져오는 16번 라인  getNowPlay()에서 getNowPlaying()으로  수정 Resolves:#8")

```
import React, { useEffect, useState } from "react";
import { useSelector } from "react-redux";
// import { useSelector } from "react-redux";
import { Link, useNavigate } from "react-router-dom";
import axios from "axios";
import postApi from "../api/postsApi";
// import axios from "axios";
import nowPlayingApi from "../api/nowPlayingApi";

export default function MovieKategorie() {
  const navigate = useNavigate();
  // const navigate = useNavigate();
const [nowPlaying, setNowPlaying] = useState([]);
const [loading, setLoading] = useState(true);
const [error, setError] = useState(null);

useEffect(() => {
async function fetchNowPlay() {
try {
        const data = await postApi.getNowPlay();
        const data = await nowPlayingApi.getNowPlaying();

setNowPlaying(data);
} catch (err) {
```
 api 변수명이 잘못된 것을 확인
api 파일에서 변수명을 제대로 가지고 와서 해결을 함
# 9. [[fix] nowPlayingApi에서 영화 데이터들을 mapping 불가능한 오류 발생 nowPlyapi 파일에서 response를 출력하고 영화 데이터들을 얻을 수 있는 위치를 다시 파악하여 6라인에서 코드 수정 Resolves:#9](https://github.com/DaeJungYoon/Movie-world/commit/cc06fdf738aeaac917bcfeb911ab13a38cccc5b0 "[fix] nowPlayingApi에서 영화 데이터들을  mapping 불가능한 오류 발생 nowPlyapi 파일에서 response를 출력하고 영화 데이터들을 얻을 수 있는 위치를 다시 파악하여 6라인에서 코드 수정 Resolves:#9")
```
const nowPlayingApi = {
getNowPlaying: async () => {
const resposne = await api.get("");
    return resposne.data;
    return resposne.data.results;
},
// getNowPlayingById: async (postId) => {
//   const response = await api.get(`/${postId}`);
//   return response.data;
// },
// createNowPlaying: async (data) => {
//   const resposne = await api.post("", data);
//   return resposne.data;
// },
};

export default nowPlayingApi;
```
api를 받아서 데이터를 반환을 하려고 했음
의도대로 데이터를 가져올 수 없는 오류 발생하여
우선 console.log(response.data)를 하며 어떤 데이터를 받아오는 지 확인을 하고
그 결과에 따라 위치를 정확히 파악을 하여 코드를 수정함
# 10. [[refactor] nowPlayAxios baseURL 리펙토링 #10](https://github.com/DaeJungYoon/Movie-world/commit/10901038c7001b081de8727800d4ab9ccf7bd75a "[refactor] nowPlayAxios baseURL 리펙토링 #10")
```
const instance = axios.create({
baseURL:
    "https://api.themoviedb.org/3/movie" +
    "/now_playing" +
    import.meta.env.VITE_NOW_MOVIES +
import.meta.env.VITE_API_KEY +
import.meta.env.VITE_API_LANG,
});
```
환경변수로 url, api key, lang를 관리하는 것이 더 좋을 것 같아서
환경변수를 사용하여 베이스 url 코드 변경

# 11. [[remove] nowPlayingApi.js && nowPlayingAxios.js 제거 #11](https://github.com/DaeJungYoon/Movie-world/commit/3c2d0e2fc46f8407ef30e2a22e5d7835d8987af8 "[remove] nowPlayingApi.js && nowPlayingAxios.js 제거 #11")
api와 axios를 각 카테고리별로 나눌 필요가 없을 것 같다라고 판단이 되어
파일 제거
# 12. [[feat] api 재구성 후 구현 #12](https://github.com/DaeJungYoon/Movie-world/commit/66279be4d261a3126e19d8d35158b5d34fcb9712 "[feat] api 재구성 후 구현 #12")
각 카테고리 별로 instance가 있어야 되겠다 라고 생각을 했고 
환경변수를 활용하여 구성을 함
[refactor,feat]으로 commit 남겼으면 더 좋았을 것 같음
# 13. [[refactor,feat] nowplay 리팩토링, popular&&topRated 기능 구현 #13](https://github.com/DaeJungYoon/Movie-world/commit/39420e8328faaba67de0c6d3590d640f6e2106a2 "[refactor,feat] nowplay 리팩토링, popular&&topRated 기능 구현 #13")

카테고리 별 데이터를 각 state에 저장하여 그 데이터를 
화면에 나타날 수 있도록 구현을 함


# 14. [[refactor,feat] MainPage에 불필요한 코드 정리 후 MovieKategorie 렌더링 #14](https://github.com/DaeJungYoon/Movie-world/commit/7b8ced6302d3c8e6446532c1802682d3fec8315d "[refactor,feat] MainPage에 불필요한 코드 정리 후  MovieKategorie 렌더링 #14")
좀 더 깔끔하게 화면에 렌더링하기 위해 카테고리페이지만 보기 위해
처음에 구조를 보기 위해 만들었던 태그들을 지웠음  

# 15. [[feat] Header 구현 #15](https://github.com/DaeJungYoon/Movie-world/commit/ef9d3ec14e4535ef01acfd3eb27db0c7db03003e "[feat] Header 구현 #15")
카테고리 페이지, 각 카테고리 별 페이지 , 마이페이지 등을
같은 형태의 헤더 가지고 있는 구조를 처음 계획할 때 설계했기 때문에
header를 구현함
# 16. [[feat] RootLayout 기능 구현 #16](https://github.com/DaeJungYoon/Movie-world/commit/44a7880d581c2c6c52d85c6443bcfe939d54584c "[feat] RootLayout 기능 구현 #16")
같은 헤더와 같은 푸터를 사용하고 
그 사이 부분만 바뀌면 되겠다라고
생각을 하고 outlet을 사용하기 위해 레이아웃 기능 구현
//페이지를 이동할 때 새로 고침되는 느낌이 아닌 페이지가 부드럽게 갈아 껴지는 
# 17. [[refactor] mainPage 임시 재구성 #17](https://github.com/DaeJungYoon/Movie-world/commit/3f8a19d79f8a4078f1db2f42d7ae874fa6b45b37 "[refactor] mainPage 임시 재구성 #17")
사이트 메인페이지의 구조를 구상하여 직관적으로 보기 위해 재구성
# 18. [[feat] MovieKategorie ...more p태그 추가 #18](https://github.com/DaeJungYoon/Movie-world/commit/fde8750803d2f3c110e2eb6afb7a602d10531468 "[feat] MovieKategorie ...more p태그 추가 #18")
카테고리 별 더보기 페이지로 이동하기 위한 
무언가가 필요하여 일단 직관적으로 보기 위해 추가
# 19. [[feat] router/index에서 path 설정 #19](https://github.com/DaeJungYoon/Movie-world/commit/8eed0eff5a669c1d93526bcef557b21944b97904 "[feat] router/index에서 path 설정 #19")
path에 따른 페이지 이동을 할 수 있도록 하기 위해 router 구현
# 20. [[refactor] src/app.jsx 라우터 설정 #20](https://github.com/DaeJungYoon/Movie-world/commit/2f866904d00b4b34d54312827b7d6e664cffeffc "[refactor] src/app.jsx 라우터 설정 #20")
path에 따른 페이지 이동을 할 수 있도록 하기 위해 router 구현 한 것을 사용하기 위해 
app.jsx에서 라우터 설정을 router/index.js로 설정
# 21. [[refactor] api/movieApi.js 불필요한 주석 제거 #21](https://github.com/DaeJungYoon/Movie-world/commit/d08ac8f3215827163998708aa24b8c2f5152e70e "[refactor] api/movieApi.js 불필요한 주석 제거 #21")

가독성을 위해 
더 이상 필요없는 주석을 제거
# 22. [[feat] MovieList 컴포넌트 기능 구현 #22](https://github.com/DaeJungYoon/Movie-world/commit/a80df092cd9cfc455de47ca2698f81164cebff84 "[feat] MovieList 컴포넌트 기능 구현 #22")
어차피 카테고리 페이지 각 카테고리 별로 영화들을 뿌려주는데 구조는 똑같다고 생각하여
카테고리 페이지에서 받은 카테고리타이틀, 영화 데이터 정보를 받아 
카테고리 타이틀, more 텍스트, 영화 제목과 포스터 이미지를 보여주는 컴포넌트를 구현하여
차후 이 컴포넌트를 재활용하기 위해
# 23. [[refactor] MovieList 컴포넌트 기능 구현 후 kategoriePage에 렌더링을 위해 MovieKategorie.jsx 리펙토링 #23](https://github.com/DaeJungYoon/Movie-world/commit/a19fbdf178a5e6efc10d5560516b639b3333fb71 "[refactor] MovieList 컴포넌트 기능 구현 후 kategoriePage에 렌더링을 위해 MovieKategorie.jsx 리펙토링 #23")

만든 컴포넌트를 사용하기 위해 
기존에 컴포넌트를 사용하지 않고 만들었던 코드들을 제거하고 컴포넌트 사용

# 24. [[remove] 사용하지 않는 파일 preimg.png 삭제 #24](https://github.com/DaeJungYoon/Movie-world/commit/ac8e79a3cbf6c25977a9120fcb8a38edaeef28d3 "[remove] 사용하지 않는 파일 preimg.png 삭제 #24")

이미지가 잘 렌더링 되는 것을 보기위해 
임의의 이미지를 만들어서 폴더에 넣었지만 
사용하지 않으니 제거
# 25. [[refactor] MovieList 컴포넌트를 하나만 쓰고 props 정보를 MovieLise컴포넌트에 넘겨서 렌더링 될 수 있게 MovieKategorie.jsx 리펙토링 #25](https://github.com/DaeJungYoon/Movie-world/commit/cba4c027aedcb5f5de259ed0e4bb6f3be26c6d57 "[refactor] MovieList 컴포넌트를 하나만 쓰고 props 정보를 MovieLise컴포넌트에 넘겨서 렌더링 될 수 있게 MovieKategorie.jsx 리펙토링 #25")
커밋 내용 그대로 인데 정확하게 기억이 안나지만 
아마 이미지가 안 불러와져서 강사님께 도움을 요청했던 것으로 기억

# 26. [[refactor] 상속받은 props 정보를 잘 받고 코드 가시성을 향상 시킬 수 있게 MovieList.jsx 리펙토링 #26](https://github.com/DaeJungYoon/Movie-world/commit/16e3714e641541ee3b0974312b72de8e753ba20a "[refactor] 상속받은 props 정보를 잘 받고 코드 가시성을 향상 시킬 수 있게 MovieList.jsx 리펙토링 #26")
커밋 내용 그대로
25번 작업내용과 발 맞춰 그에 따른 props 받은 이름들을 변경
# 27. [[feat] MovieList컴포넌트에게 item이라는 props받는 컴포넌트 구현 MovieCard.jsx추가 #27](https://github.com/DaeJungYoon/Movie-world/commit/4fcdceeae640ba6cc20b523c4780ef0a193d0269 "[feat] MovieList컴포넌트에게 item이라는 props받는 컴포넌트 구현 MovieCard.jsx추가 #27")
22번 작업과 마찬가지로 
어차피 카테고리 페이지 각 카테고리 별로 영화들을 뿌려주는데 
그 영화의 구조는 똑같다고 생각하여
카테고리 리스트 컴포넌트에서 받은 카테고리 타이틀, 영화 데이터 정보를 받아 
영화 제목과 포스터 이미지를 보여주는 컴포넌트를 구현하여
차후 이 컴포넌트를 재활용하기 위해
# 28. [[refactor] MovieCard컴포넌트에게 id,poster_path,title의 정보가 담긴 items props 전달하는 MovieList.jsx 리펙토링 #28](https://github.com/DaeJungYoon/Movie-world/commit/7e7b1cdd61e511ed93cced4519a585b622fe65b5 "[refactor] MovieCard컴포넌트에게 id,poster_path,title의 정보가 담긴 items props 전달하는 MovieList.jsx 리펙토링 #28")
커밋 내용 그대로
이렇게 해야 잘 넘어가고 가독성이 좋기 때문

# 29. [[feat]더보기 컴포넌트와 더보기 페이지들 내용없이 파일만 구현#29](https://github.com/DaeJungYoon/Movie-world/commit/a760c6e4275b627cda80d6b96d9fa9e1562f4730 "[feat]더보기 컴포넌트와 더보기 페이지들 내용없이 파일만 구현#29")

만들기 전에 파일 구조를 파악하기 위해
# 30. [[feat]nowplay 페이지 렌더링 #30](https://github.com/DaeJungYoon/Movie-world/commit/db7e4f04e7ccf40e0842d233d37526e63618dbf4 "[feat]nowplay 페이지 렌더링 #30")

nowplay 더보기 페이지를 렌더링 하기위해 
router/index.jsx에서 미리 만들어뒀었지만 
주석 처리 한 부분을 주석을 풀어 렌더링 될 수 있도록 설정 
# 31. [[refactor] MovieCard컴포넌트에서 받아온 props 명 items에서 item으로 변경 MovieCard.jsx 리펙토링 #31](https://github.com/DaeJungYoon/Movie-world/commit/8714af4aa447144916e4049f57f374e335359636 "[refactor] MovieCard컴포넌트에서 받아온 props 명 items에서 item으로 변경  MovieCard.jsx 리펙토링 #31")

items 보다 item이 더 자연스럽다고 피드백을 받아 변경
# 32. [[feat, design, refactor] Kategorie별 더보기페이지로 연결되는 Link 추가, card에 flex css 추가, MovieCard에 key 추가, props 명 변경, MovieList.jsx 기능 추가, 디자인 추가, 리펙토링 #32](https://github.com/DaeJungYoon/Movie-world/commit/3402250c719bb421f7918fb55cac0ebdb8f000d5 "[feat, design, refactor] Kategorie별 더보기페이지로 연결되는 Link 추가, card에 flex css 추가, MovieCard에 key 추가, props 명 변경, MovieList.jsx 기능 추가, 디자인 추가, 리펙토링  #32")
커밋 내용 그대로
무비들을 가시성 좋게 볼 수 있게 css 적용하고 
more 텍스트를 누를때 각 카테고리 more페이지에 이동 할 수 있도록 
p태그에서 Link로 바꿔주고 ```
```
to={`/kategorie/${kategorieTitle}`}
```
이렇게 한 이유는 props에서 받은 kategorieTitle을 토대로 이동을 하기 위해
key 값을 넣어주는 것이 좋다고 하고 warning console로그가 너무 거슬려 key 값 추가해줌
31번과 발 맞춰 props 명 변경
# 33. [[refactor, chore] kategorieTitle 변경, MovieList 키 추가, 기능 실험 코드 주석처리 MovieKategorie.jsx 리펙토링 #33](https://github.com/DaeJungYoon/Movie-world/commit/a01d8baf7d7aff86fa6e46518d40dc1b0e1ee953 "[refactor, chore] kategorieTitle 변경, MovieList 키 추가, 기능 실험 코드 주석처리  MovieKategorie.jsx 리펙토링 #33")

Link로 더보기 페이지로 이동하려고 했으나 
router에 설정한 path와 달라서 이동이 불가능한 것을 인지하고 
path와 같은 이름으로 kategorieTitle 변경하고 
key 값은 32번과 같은 이유
주석처리는 가독성을 위해
# 34. [[feat] NowPlayMore페이지 구현 NowPlayMore.jsx #34](https://github.com/DaeJungYoon/Movie-world/commit/d2ff9c41f1829871e2d9d4d34d04c257dd63142c "[feat] NowPlayMore페이지 구현  NowPlayMore.jsx  #34")
NowPlay에 대한 api를 받고 
그 데이터를 새로운 배열에 그 배열을 state에 저장을 하고
```
import React from 'react'
import React from "react";
import MovieCard from "../components/MovieCard";
import { useState, useEffect } from "react";
import { nowPlayingApi } from "../api/movieApi";

export default function NowPlayMore() {
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [datas, setDatas] = useState([]);

  useEffect(() => {
    async function fetchMovieData() {
      try {
        const nowdata = await nowPlayingApi.getNowPlaying();

        const newArr = [
          {
            kategorieTitle: "now_playing_more",
            movies: nowdata,
          },
        ];

        // 렌더링 할 데이터 상태 변경
        setDatas(newArr);
      } catch (err) {
        setError(err.message);

        console.error(err);
      } finally {
        setLoading(false);
      }
    }

    fetchMovieData();
  }, []);

  if (loading) {
    return <div>로딩중</div>;
  }

  if (error) {
    return <div>{error}</div>;
  }
return (
    <div>NowPlayMore</div>
  )
    <>
      {datas.map((data) => {
        const now = data.movies;
        return now.map((item) => {
          return <MovieCard item={item}></MovieCard>;
        });
      })}
      ;
    </>
  );
}
```

이 데이터를 MovieCard 컴포넌트에 props로 전달하기위해
이렇게 짰음
# 35. [[feat] TopRatedMore페이지 구현 TopRatedMore.jsx #35](https://github.com/DaeJungYoon/Movie-world/commit/7001cfb845e9c294afe142effb4338e0bb2105f5 "[feat] TopRatedMore페이지 구현  TopRatedMore.jsx  #35")
34, 35, 36 모두 같은 이유임

# 36. [[feat] PopularMore페이지 구현 PopularMore.jsx #36](https://github.com/DaeJungYoon/Movie-world/commit/5e380528efbae6bc6df8f5a1c30d3d36d44f9543 "[feat] PopularMore페이지 구현  PopularMore.jsx  #36")
34, 35, 36 모두 같은 이유임

# 37. [[feat] 카테고리 별 more페이지 router 연결 index.jsx #37](https://github.com/DaeJungYoon/Movie-world/commit/b7018af95ba405b91cf3b3664361903a52a1d0ca "[feat] 카테고리 별 more페이지 router  연결  index.jsx #37")

커밋 그대로
# 38. [[fix] 카테고리 별 more페이지 접근 중 more path가 undifined되는 현상 발생 props보내주는 카테고리 타이틀명에 오타가 있었음 MovieKategorie.jsx Resolves:#38](https://github.com/DaeJungYoon/Movie-world/commit/4eacb8ede6f202105eb11704f6965660f276c9e1 "[fix] 카테고리 별 more페이지 접근 중 more path가 undifined되는 현상 발생 props보내주는 카테고리 타이틀명에 오타가 있었음  MovieKategorie.jsx Resolves:#38")

```
return (
<MovieList
key={data.kategorieTitle}
            kategoriTitle={data.kategorieTitle}
            kategorieTitle={data.kategorieTitle}
movies={data.movies}
></MovieList>
);
```
커밋 내용 그대로
# 39. [[refactor] Api 재구성 movieApi.js, movieAxios.js 리펙토링 #39](https://github.com/DaeJungYoon/Movie-world/commit/30a1ccd9351d55f056d1c9839af63c07daa5714e "[refactor] Api 재구성 movieApi.js, movieAxios.js 리펙토링 #39")

```

import axios from "axios";

const nowPlayInstance = axios.create({
  baseURL:
    import.meta.env.VITE_NOW_MOVIES +
    "/now_playing" +
    import.meta.env.VITE_API_KEY +
    import.meta.env.VITE_API_LANG,
  baseURL: import.meta.env.VITE_NOW_MOVIES,
  params: {
    api_key: import.meta.env.VITE_API_KEY,
    language: import.meta.env.VITE_API_LANG,
  },
});

// baseURL: "https://api.themoviedb.org/3",
// params: {
//   api_key: "2211333",
//   language: "ko-KR",
// },
const popularInstance = axios.create({
  baseURL:
    import.meta.env.VITE_NOW_MOVIES +
    "/popular" +
    import.meta.env.VITE_API_KEY +
    import.meta.env.VITE_API_LANG,
  baseURL: import.meta.env.VITE_NOW_MOVIES,
  params: {
    api_key: import.meta.env.VITE_API_KEY,
    language: import.meta.env.VITE_API_LANG,
  },
});
const topRatedInstance = axios.create({
  baseURL:
    import.meta.env.VITE_NOW_MOVIES +
    "/top_rated" +
    import.meta.env.VITE_API_KEY +
    import.meta.env.VITE_API_LANG,
  baseURL: import.meta.env.VITE_NOW_MOVIES,
  params: {
    api_key: import.meta.env.VITE_API_KEY,
    language: import.meta.env.VITE_API_LANG,
  },
});
// const popularInstance = axios.create({
//   baseURL:
//     import.meta.env.VITE_NOW_MOVIES +
//     "/popular" +
//     import.meta.env.VITE_API_KEY +
//     import.meta.env.VITE_API_LANG,
// });
// const topRatedInstance = axios.create({
//   baseURL:
//     import.meta.env.VITE_NOW_MOVIES +
//     "/top_rated" +
//     import.meta.env.VITE_API_KEY +
//     import.meta.env.VITE_API_LANG,
// });
// const movieDetailInstance = axios.create({
//   baseURL:
//     import.meta.env.VITE_NOW_MOVIES +
//     `/${movie.id}` +
//     import.meta.env.VITE_API_KEY +
//     import.meta.env.VITE_API_LANG,
// });

// const movieDetailInstance = axios.create({
//   baseURL: import.meta.env.VITE_NOW_MOVIES,
```
잘못 이해한 instance구조를 다시 알아보고 api를 재구성 
# 40. [[refactor] key값 부여 MovieList.jsx 리펙토링 #40](https://github.com/DaeJungYoon/Movie-world/commit/dd39888725c20c66f8fd4d74e8562e7aec5df185 "[refactor] key값 부여 MovieList.jsx 리펙토링 #40")
```
<h2>{kategorieTitle}</h2>

<p>
        <Link to={`/kategorie/${kategorieTitle}`}>...more</Link>
        <Link key={kategorieTitle} to={`/kategorie/${kategorieTitle}`}>
          ...more
        </Link>
</p>
<ul style={{ display: "flex" }}>
{movies.map((item) => {
```
key값을 넣으라는 권고 사항이 출력되어 key값 부여

key 쓸 때
컴포넌트를 반복문을 활용하여 생성할 때
-> react입장에서 컴포넌트도 객체로 보는데 
-> 반복문을 활용할 때 변수를 사용하고 
-> 컴포넌트를 생성할 때 각각의 컴포넌트가 무엇인지 알기위해 key를 사용

# 41. [[refactor] key값 부여 NowPlayMore.jsx 리펙토링 #41](https://github.com/DaeJungYoon/Movie-world/commit/8ac81e27315c00d9d207c5fb72c485c6d9b0e54d "[refactor] key값 부여  NowPlayMore.jsx 리펙토링 #41")

key값을 넣으라는 권고 사항이 출력되어 key값 부여

# 42. [[refactor] instance 하나로 합치면서 Api 재구성 movieApi.js, movieAxios.js 리펙토링 #42](https://github.com/DaeJungYoon/Movie-world/commit/63527e19155c763127f361882cd2dc1ee50e114b "[refactor] instance 하나로 합치면서  Api 재구성 movieApi.js, movieAxios.js 리펙토링 #42")

커밋내용 그대로 재구성을 하였고 불필요한 주석들 제거
# 43. [[feat] detailApi 구현 movieApi.js, movieAxios.js #43](https://github.com/DaeJungYoon/Movie-world/commit/016fb026f429289b9640aff7dae427add34ae826 "[feat] detailApi 구현  movieApi.js, movieAxios.js #43")

```
import axios from "axios";

const instance = axios.create({
const movieListsInstance = axios.create({
baseURL: import.meta.env.VITE_NOW_MOVIES,
params: {
api_key: import.meta.env.VITE_API_KEY,
language: import.meta.env.VITE_API_LANG,
},
});


export { instance };
const moviesInstance = axios.create({
  baseURL: import.meta.env.VITE_NOW_MOVIES + `/${movieId}`,
  params: {
    api_key: import.meta.env.VITE_API_KEY,
  },
});
export { movieListsInstance, moviesInstance };
```
영화 상세페이지에서 사용할 데이터를 받아올 instance 구성하고 detailApi구성
# 44. [[fix]detail api path 수정 movieApi.js #44](https://github.com/DaeJungYoon/Movie-world/commit/b3affe41dbc1eb309ed905c13a23e1825f1f911e "[fix]detail api path 수정  movieApi.js #44")


```

const detailApi = {
getDetail: async () => {
    const resposne = await moviesInstance.get(`/&{movieId}`);
    const resposne = await moviesInstance.get(`/${movieId}`);
return resposne.data;
},
};
```
커밋 내용 그대로
# 45. [[refactor]movie id를 인자로 받아오는 것 추가 movieApi.js #45](https://github.com/DaeJungYoon/Movie-world/commit/093e24a174b110f53665c6c1695e1ac9dce759af "[refactor]movie id를 인자로 받아오는 것 추가  movieApi.js #45")


```
};

const detailApi = {
  getDetail: async () => {
  getDetail: async (movieId) => {
const resposne = await moviesInstance.get(`/${movieId}`);
return resposne.data;
},
};

export { nowPlayingApi, popularApi, topRatedApi };
export { nowPlayingApi, popularApi, topRatedApi, detailApi };
```
기존의 상태면 어떤 것을 받아오는 지가 선언?명시가 되지 않아서 데이터를 받아올 수 없음
# 46. [[refactor]moviesInstance import해서 받아오기 movieApi.js #46](https://github.com/DaeJungYoon/Movie-world/commit/bd03967dfddbba4f1e3896fc86772eafdb3f25c0 "[refactor]moviesInstance import해서 받아오기 movieApi.js #46")

```
import { movieListsInstance } from "./movieAxios";
import { movieListsInstance, moviesInstance } from "./movieAxios";

const nowPlayingApi = {
getNowPlaying: async () => {
```
커밋 내용 그대로 import하기
# 47. [[feat] movieDetail페이지 구현 movieDetail.jsx #47](https://github.com/DaeJungYoon/Movie-world/commit/b8dd24d1d466519b7231535b88bcefa2e41af68b "[feat] movieDetail페이지 구현  movieDetail.jsx #47")

```
@@ -0,0 +1,31 @@
import React, { useEffect, useState } from "react";
import { detailApi } from "../api/movieApi";
import { useParams } from "react-router-dom";

export default function movieDetail() {
  const { movieId } = useParams();
  const [movie, setMovie] = useState();
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    async function fetchMovie() {
      try {
        const data = await detailApi.getDetail(movieId);
        setMovie(data);
      } catch (err) {
        console.error(err);
      } finally {
        setLoading(false);
      }
    }
    fetchMovie();
  }, []);
  if (loading) return <div>Loading</div>;
  return (
    <>
      <img src={`https://image.tmdb.org/t/p/w200${movie.poster_path}`} />
      <h1>{movie.title}</h1>
      <p>{movie.overview}</p>
    </>
  );
}
```
detail 데이터를 받아와서 렌더링을 잘 해주는지 보기 위해 일단 poster_path와 title, overview 로 구성
# 48. [[refactor]movieApi 재구성 movieApi.js #48](https://github.com/DaeJungYoon/Movie-world/commit/2c7b735cc45f49b7168737dcda293d4b920185f4 "[refactor]movieApi 재구성  movieApi.js #48")

movidId라는 변수를 이미 사용중이라고 해서 다른 변수명 movieDetailId으로 변경

# 49. [[refactor, rename] movie Id 변수명 변경&파일명 movieDetail에서 MovieDetail로 변경 movieDetail.jsx #49](https://github.com/DaeJungYoon/Movie-world/commit/bb350e144804ed96031996aa2f12d9411473e450 "[refactor, rename] movie Id 변수명 변경&파일명 movieDetail에서 MovieDetail로 변경   movieDetail.jsx #49")

```
import { detailApi } from "../api/movieApi";
import { useParams } from "react-router-dom";

export default function movieDetail() {
  const { movieId } = useParams();
export default function MovieDetail() {
  const { movieDetailId } = useParams();
const [movie, setMovie] = useState();
const [loading, setLoading] = useState(true);

useEffect(() => {
async function fetchMovie() {
try {
        const data = await detailApi.getDetail(movieId);
        const data = await detailApi.getDetail(movieDetailId);
        console.log(data);
setMovie(data);
} catch (err) {
console.error(err);
@@ -20,7 +21,7 @@ export default function movieDetail() {
}
fetchMovie();
}, []);
  if (loading) return <div>Loading</div>;
  if (loading) return <div>...Loading...</div>;
return (
<>
<img src={`https://image.tmdb.org/t/p/w200${movie.poster_path}`} />
```
48번 커밋 내용과 마찬가지로 발 맞춰 변수명 변경 & JSX 파일 규칙을 지키기 위해 movieDetail에서 MovieDetail로 변경
# 50. [[feat] movieDetail페이 router 설정 #50](https://github.com/DaeJungYoon/Movie-world/commit/bbfe2ca672752798a2c7e089299ecb9fb7860493 "[feat] movieDetail페이 router 설정  #50")

```
import NowPlayMore from "../pages/NowPlayMore";
import PopularMore from "../pages/PopularMore";
import TopRatedMore from "../pages/TopRatedMore";
import MovieDetail from "../pages/movieDetail";

const router = createBrowserRouter([
{
@@ -17,6 +18,16 @@ const router = createBrowserRouter([
// },
],
},
  {
    path: "/movie/:movieDetailId",
    element: <RootLayout></RootLayout>,
    children: [
      {
        index: true,
        element: <MovieDetail></MovieDetail>,
      },
    ],
  },
{
path: "/kategorie",
element: <RootLayout />,
```
영화 상세정보를 보여주는 detail 페이지를 보기위해 router설정
# 51. [[chore]detailApi 데이터 잘 받아오는지 확인한 console.log 제거 #51](https://github.com/DaeJungYoon/Movie-world/commit/425387c2a97d281d91cf3895ff854ec71b10781c "[chore]detailApi 데이터 잘 받아오는지 확인한 console.log 제거 #51")

```
async function fetchMovie() {
try {
const data = await detailApi.getDetail(movieDetailId);
        console.log(data);
setMovie(data);

} catch (err) {
console.error(err);
} finally {
```
커밋 내용 그대로
# 52. [[feat] MovieCard 컴포넌트에서 영화를 누르면 해당 MovieDetail로 이동할 수 있도록 Link추가 #52](https://github.com/DaeJungYoon/Movie-world/commit/4209ee16270394845c9a9c833035931b3a3c6fd8 "[feat] MovieCard 컴포넌트에서 영화를 누르면 해당 MovieDetail로 이동할 수 있도록 Link추가  #52")

```
import React from "react";
import { Link, useParams } from "react-router-dom";

export default function MovieCard(props) {
// console.log(props);
const { item } = props;

return (
    <li key={item.id}>
      <img src={`https://image.tmdb.org/t/p/w200${item.poster_path}`} />
      <h4>{item.title}</h4>
    </li>
    <>
      <Link to={`/movie/${item.id}`}>
        <li key={item.id}>
          <img src={`https://image.tmdb.org/t/p/w200${item.poster_path}`} />
          <h4>{item.title}</h4>
        </li>
      </Link>
    </>
);
}
```
클릭을 하면 이동을 할 수 있도록 각 영화 id 별로 상세페이지로 이동하는 Link 구현
# 53. [[feat] MovieDetail페이지 상세정보 리뷰 제외하고 구현 #53](https://github.com/DaeJungYoon/Movie-world/commit/a75118ac979759f62ad8aaa31521b314bc2a73e8 "[feat] MovieDetail페이지 상세정보 리뷰 제외하고  구현  #53")

```
try {
const data = await detailApi.getDetail(movieDetailId);
setMovie(data);

} catch (err) {
console.error(err);
} finally {
@@ -25,8 +24,31 @@ export default function MovieDetail() {
return (
<>
<img src={`https://image.tmdb.org/t/p/w200${movie.poster_path}`} />
      <h1>{movie.title}</h1>
      <p>{movie.overview}</p>
      <ul>
        <li>
          <h1>제목: {movie.title}</h1>
        </li>
        <li>
          <p>줄거리: {movie.overview}</p>
        </li>
        <li>
          <p>상영시간: {movie.runtime}</p>
        </li>
        <li>
          <p>개봉일: {movie.release_date}</p>
        </li>
        <li>
          <p>평점: {movie.vote_average}</p>
        </li>
        <li>
          <p>투표수: {movie.vote_count}</p>
        </li>
      </ul>
      <ul>
        <li>
          <h4>리뷰</h4>
        </li>
      </ul>
</>
);
}
```
상세정보 데이터를 잘 받아오는 것을 확인했기 때문에 나머지 요소들 구현
# 54. [[feat] movieApi review 데이터가져오는 api 추가 #54](https://github.com/DaeJungYoon/Movie-world/commit/a40d719036bb73b3e5662000b78cac8c625e0aa5 "[feat] movieApi review 데이터가져오는 api 추가 #54")

```
const nowPlayingApi = {
getNowPlaying: async () => {
const resposne = await movieListsInstance.get("/now_playing");
return resposne.data.results;
},
};
const popularApi = {
getPopular: async () => {
const resposne = await movieListsInstance.get("/popular");
return resposne.data.results;
},
};
const topRatedApi = {
getTopRated: async () => {
const resposne = await movieListsInstance.get("/top_rated");
return resposne.data.results;
},
};

const detailApi = {
getDetail: async (movieDetailId) => {
const resposne = await moviesInstance.get(`/${movieDetailId}`);
return resposne.data;
},
  getDetailReview: async (movieDetailId) => {
    const resposne = await moviesInstance.get(`/${movieDetailId}/reviews`);
    return resposne.data.results;
  },
};

export { nowPlayingApi, popularApi, topRatedApi, detailApi };
```
review의 데이터를 가져오려면 detail path에 reviews 만 추가하면 가져올 수 있기 때문에
detailApi에 getDetailReview 추가
# 55. [[feat] movieApi review 데이터가져와서 작성자 이름과 리뷰내용 가져오는 코드 추가 #55](https://github.com/DaeJungYoon/Movie-world/commit/1baa578810a86a4ca1d3806ff2f9e391e046a588 "[feat] movieApi review 데이터가져와서 작성자 이름과 리뷰내용 가져오는 코드 추가 #55")


```
export default function MovieDetail() {
const { movieDetailId } = useParams();
const [movie, setMovie] = useState();
  const [movieReview, setMovieReview] = useState();
const [loading, setLoading] = useState(true);

useEffect(() => {
@@ -18,15 +19,29 @@ export default function MovieDetail() {
setLoading(false);
}
}
    async function fetchMovieReview() {
      try {
        const data = await detailApi.getDetailReview(movieDetailId);
        for (let i in data) {
          setMovieReview(data[i]);
        }
        console.log(movieReview);
      } catch (err) {
        console.error(err);
      } finally {
        setLoading(false);
      }
    }
fetchMovie();
    fetchMovieReview();
}, []);
if (loading) return <div>...Loading...</div>;
return (
<>
<img src={`https://image.tmdb.org/t/p/w200${movie.poster_path}`} />
<ul>
<li>
          <h1>제목: {movie.title}</h1>
          <h3>제목: {movie.title}</h3>
</li>
<li>
<p>줄거리: {movie.overview}</p>
@@ -44,10 +59,10 @@ export default function MovieDetail() {
<p>투표수: {movie.vote_count}</p>
</li>
</ul>
      <h4>리뷰</h4>
<ul>
        <li>
          <h4>리뷰</h4>
        </li>
        <li>닉네임: {movieReview.author}</li>
        <li>{movieReview.content}</li>
</ul>
</>
);
```
상세정보의 제목이 너무 큰 것 같아 태그 변경
getDetailReview의 data는 데이터구조가

```
1. Array(4)

1. 0: {author: 'r96sk', author_details: {…}, content: "A solid enough send off for this <em>'Venom'</em> …Ejiofor stick out most from the other characters.", created_at: '2024-10-25T18:25:18.286Z', id: '671be28e9ff681d9e0a410bd', …}
2. 1: {author: 'Mangoturtle', author_details: {…}, content: "The other two at the very least were enjoyable. Th…e of Eddie's flashbacks he wasn't even there for.", created_at: '2024-10-27T14:01:38.601Z', id: '671e47c2427c5c19f0264707', …}
3. 2: {author: 'CinemaSerf', author_details: {…}, content: "Perhaps this was just one sequel too many as the s… but it's not a patch on the first one from 2018.", created_at: '2024-10-31T11:02:06.190Z', id: '672363aed9a8a77b5da47a0d', …}
4. 3: {author: 'TurkBinge', author_details: {…}, content: 'Venom: The Last Dance expands on the chaotic relat…t go through to see but no MORE BLACK symbiote...', created_at: '2024-11-12T20:12:08.312Z', id: '6733b6982d237511a019dec1', …}
5. length: 4
6. [[Prototype]]: Array(0)
```

이런 배열로 들어있기 때문에 배열의 인덱스를 가져오는 것이 맞다고 판단하여 
for 문으로 index를 뽑아 데이터를 movieReview에 넣기
# 56. [[feat] MainPage와 LoginPage에서 사용할 Header구현 #56](https://github.com/DaeJungYoon/Movie-world/commit/da83423ffb8873f609a023a3a5d03bc028dc38ea "[feat] MainPage와 LoginPage에서 사용할 Header구현 #56")

```
@@ -0,0 +1,12 @@
import React from "react";
import { Link } from "react-router-dom";

export default function Header() {
  return (
    <header>
      <Link to="/">
        <h1>Movie World</h1>
      </Link>
    </header>
  );
}
```
커밋 내용 그대로
# 57. [[feat] MainPage와 LoginPage을 구성하는 HomeLayout구현 #57](https://github.com/DaeJungYoon/Movie-world/commit/9704fc8663a8dc83afcbe6467dc8e684f8a9ae4c "[feat] MainPage와 LoginPage을 구성하는 HomeLayout구현 #57")

```
@@ -0,0 +1,12 @@
import React from "react";
import { Outlet } from "react-router-dom";
import HomeHeader from "./components/Header";

export default function HomeLayout() {
  return (
    <>
      <HomeHeader></HomeHeader>
      <Outlet></Outlet>
    </>
  );
}
```
커밋 내용 그대로인데 왜 이렇게 생각을 했냐 
처음에 와이어 프레임을 짤 때 MainPage와 LoginPage 같은 구성을 하고 있고 나머지 페이지는 다르게 구성을 했기 때문에
![[Pasted image 20241125201014.png]]
![[Pasted image 20241125201040.png]]
![[Pasted image 20241125201116.png]]
![[Pasted image 20241125201134.png]]
# 58. [[feat] LoginPage구현 #58](https://github.com/DaeJungYoon/Movie-world/commit/041694686d0c169f1adc6aea1cc028b585ed34a5 "[feat] LoginPage구현 #58")

렌더링을 잘 해주는지 확인을 위해 임시로 구현
# 59. [[feat] LoginPage와 MainPage의 경로를 설정하는 router 설정 추가 #59](https://github.com/DaeJungYoon/Movie-world/commit/f3fd540bb7958ef3df4b8cbd23ddc5505e2b3025 "[feat] LoginPage와 MainPage의 경로를 설정하는 router 설정 추가 #59")

```
import PopularMore from "../pages/PopularMore";
import TopRatedMore from "../pages/TopRatedMore";
import MovieDetail from "../pages/movieDetail";
import HomeLayout from "../HomeLayout";
import LoginPage from "../pages/LoginPage";

const router = createBrowserRouter([
{
path: "/",
    element: <MainPage />,
    element: <HomeLayout></HomeLayout>,
children: [
      // {
      //   path: "/login",
      //   element: <Login />,
      // },
      {
        index: true,
        element: <MainPage />,
      },
      {
        path: "/login",
        element: <LoginPage />,
      },
],
},
{
```
HomeLayout을 사용하여 MainPage와 LoginPage를 잘 나오게하고 각 경로로 잘 이동시키기 위해 router 설정
# 60. [[refector] 자연스러운 구성을 위해 Header컴포넌트와 MainPage refactor #60](https://github.com/DaeJungYoon/Movie-world/commit/1811292389aa1a5eebe8465e5ab5feeb5a5966b4 "[refector] 자연스러운 구성을 위해  Header컴포넌트와  MainPage refactor #60")

```
import React from "react";
import { useDispatch, useSelector } from "react-redux";
import { Link } from "react-router-dom";

export default function Header() {
export default function HomeHeader() {
return (
<header>
<ul>
<li>
<Link to="/">Movie World</Link>
</li>
        <button>
          <Link to="/login">login</Link>
        </button>
       
</ul>
</header>
);
```


```
export default function MainPage() {
return (
<>
      <h1>Movie World</h1>
      <button>Login</button>
      <Link to="/login">
        <button>login</button>
      </Link>
<Link to="/kategorie">Movie ON!</Link>
</>
);
```

우선 Header라는 함수명에서 HomeHaeder로 변경
HomeLayout에선 Login 버튼을 헤더에 사용하지 않기 때문에 Login 버튼은 제거하고
MainPage에 LoginPage로 이동할수있는 Login button Link 추가
# 61. [[chore] 필요없는 consoloe.log 제거 MovieDetail.jsx #61](https://github.com/DaeJungYoon/Movie-world/commit/36742e28bca96e9c956d9e0379b3c074b084f2b6 "[chore] 필요없는 consoloe.log 제거  MovieDetail.jsx #61")

movieReview를 확인하려고 한 필요한 console.log 제거인데
이제 보니 

```

export default function MovieDetail() {
const { movieDetailId } = useParams();
const [movie, setMovie] = useState();
const [movieReview, setMovieReview] = useState();
const [loading, setLoading] = useState(true);

useEffect(() => {
async function fetchMovie() {
try {
const data = await detailApi.getDetail(movieDetailId);
setMovie(data);
} catch (err) {
console.error(err);
} finally {
setLoading(false);
}
}
async function fetchMovieReview() {
try {
const data = await detailApi.getDetailReview(movieDetailId);
for (let i in data) {
setMovieReview(data[i]);
}
        console.log(movieReview); // undefined여기가 아니라
} catch (err) {
console.error(err);
} finally {
setLoading(false);
}
}
fetchMovie();
fetchMovieReview();
}, []);
console.log(movieReview) //여기가 맞았을 듯 사실 여기도 아니고

  

  useEffect(() => {

    console.log(movieReview);

  }, [movieReview]);
  이렇게 useEffect로 movieReview를 받아올 때 한 번만 보기 위해 해야됨

if (loading) return <div>...Loading...</div>;
return (
<>
<img src={`https://image.tmdb.org/t/p/w200${movie.poster_path}`} />
<ul>
<li>
<h3>제목: {movie.title}</h3>
</li>
<li>
<p>줄거리: {movie.overview}</p>
</li>
<li>
<p>상영시간: {movie.runtime}</p>
</li>
<li>
```
어떤 데이터를 보고 싶을때 밖에서 출력하는 것이 아닌 useEffect를 사용하여 console.log를 사용하여 출력 해야함 왜냐면 밖에서 출력하는 것은 부정확할 수 있음
리뷰 렌더링은 반복문을 사용하여 렌더링해야함 by. map() 사용
# 62. [[refactor] review가 하나만 나오는 것을 map을 사용하여 렌더링함 MovieDetail.jsx 리펙토링 #62](https://github.com/DaeJungYoon/Movie-world/commit/de8ebae283cb8e9f192212e49da1255cd75d1f91 "[refactor] review가 하나만 나오는 것을 map을 사용하여 렌더링함  MovieDetail.jsx 리펙토링 #62")

```

export default function MovieDetail() {
const { movieDetailId } = useParams();
const [movie, setMovie] = useState();
  const [movieReview, setMovieReview] = useState();
  const [movieReview, setMovieReview] = useState([]);
const [loading, setLoading] = useState(true);

useEffect(() => {
@@ -22,9 +22,10 @@ export default function MovieDetail() {
async function fetchMovieReview() {
try {
const data = await detailApi.getDetailReview(movieDetailId);
        for (let i in data) {
          setMovieReview(data[i]);
        }
        // for (let i in data) {
        //   setMovieReview(data);
        // }
        setMovieReview(data);
} catch (err) {
console.error(err);
} finally {
@@ -34,6 +35,7 @@ export default function MovieDetail() {
fetchMovie();
fetchMovieReview();
}, []);

if (loading) return <div>...Loading...</div>;
return (
<>
@@ -59,10 +61,15 @@ export default function MovieDetail() {
</li>
</ul>
<h4>리뷰</h4>
      <ul>
        <li>닉네임: {movieReview.author}</li>
        <li>{movieReview.content}</li>
      </ul>
      {movieReview.map((review) => {
        return (
          <ul key={review.id}>
            <li>닉네임: {review.author}</li>
            <li>{review.content}</li>
          </ul>
        );
      })}
      ;
</>
);
}

```
key에러로 분명 고유한 key값을 넣었는데 안된는 것을 확인함
고유한 key값이 맞나?
->어떻게 출력되는 지 확인
-> 리뷰 id인것으로 판단
-> 고유한 값 맞음
<></> 로 감싸져있어서 흐름상 여기에 key를 넣어야 인식을 하는 것인데 
<></> 안에 있는 ul태그에 넣어서 key 에러 발생

# 63. 










