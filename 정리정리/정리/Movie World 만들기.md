
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
# 39. .




