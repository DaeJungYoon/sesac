# React를 이용한 웹사이트 제작

- react를 활용하여 웹사이트를 제작한다.

### TMDB API의 다음 API를 활용해 웹사이트를 제작한다.

[Getting Started](https://developer.themoviedb.org/docs/getting-started)


- MOVIE LISTS
    - Now Playing
	    - https://api.themoviedb.org/3/movie/now_playing?api_key=f15d094fa013544c9bab38fbd5d29543&language=ko-kr
    - Popular
	    - https://api.themoviedb.org/3/movie/popular?api_key=f15d094fa013544c9bab38fbd5d29543&language=ko-kr
    - Top Rated
	    -  https://api.themoviedb.org/3/movie/top_rated?api_key=f15d094fa013544c9bab38fbd5d29543&language=ko-kr
- MOVIES
    - Details
	    - https://api.themoviedb.org/3/movie/{movie_id}?api_key=f15d094fa013544c9bab38fbd5d29543&language=ko-kr
    - Reviews
	    - https://api.themoviedb.org/3/movie/{movie_id}/reviews?api_key=f15d094fa013544c9bab38fbd5d29543
	api를 받아서 api 데이터를 가져옴
	ul li 등을 이용해서 뼈대를 잡음
	
### 다음과 같은 기능을 구현한다
npm create vite@latest my-blog -- --template react
필요한 모듈은 axios, react-router-dom, @reduxjs/toolkit, react-redux
- API 불러오기 
	- 환경변수로 변수 VITE_API_KEY와 VITE_API_LANG  지정
		- 
		  `
			import axios from "axios";
			const instance = axios.create({

			  baseURL:" https://api.themoviedb.org/3/movie"+{} +
			import.meta.env.VITE_API_KEY_AND_LANG +import.meta.env.VITE_API_KEY_AND_LANG
			});
		- 중간에 어떻게 넣어야 되는 거지?
			- axios instance가 여러 개 일수도 있다라고 들음
			- 

  

export default instance;`

0. 메인 페이지는 하나의 movieList 컴포넌트를 만들고 재사용하고 메인페이지에서 movieList 컴포넌트를 사용하고 props 정보를 보내주면 될 것 같음
	1. 틀로 만들었는데 이미지를 불러오는 방법을 모르겠음 이미지 경로는 가져올 수 있는데
	2. 여러 방법을 시도함 "url"+{}, `url${}`, 
	->자바스크립트로 발견을 해야하는데 
		const realUrl = 
		console.log(realUrl) 
		통해 합치는 법을 발견하고
		`<img src={realUrl}> `
		로 해결
- router 설정 
	- 로그인과 메인페이지는 router로 관리할 필요가 없음
		- 
- 
1. 포스터 이미지, 제목 틀이 있는 영화 컴포넌트 만들어서 재사용 
	1. nowplaying api 기반으로 하려고 했는데 이 데이터들은 각각의 카테고리 별 첫번째 페이지의 정보를 보내줌
		1. 그래서 모든 영화에 대해 접근을 할 수 있는 api 찾아봄
			1. 근데 detail api에서 id만 바꿔주면 모든 영화에 대해 접근이 가능한 것 아닌가?
				1. 어차피 id는 똑같으니까
				2. 그러면 각각의 카테고리에서 영화 컴포넌트는 어떻게 사용? 
				3. 근데 id를 불러오는 방식이 달라서 안되나?
					1. detail api 에서 불러오는 것이 아니라 각각의 api 를  kategorie에 불러오고 그에 대한 데이터를 MoviePT 컴포넌트에 key:value 로 정보를 보내줌
	2. MovieList 컴포넌트 만들기
2. 메인 페이지에서 MOVIE LISTS의 카테고리 별 영화들을 일부 보여준다. 
	-> 카테고리는 genre_ids를 뽑아서 쓰면 됨 <- 이거 아닌 듯 
		- **878** - 공상 과학 (Sci-Fi)
		- **28** - 액션 (Action)
		- **12** - 모험 (Adventure)
		- **27** - 공포 (Horror)
		- **53** - 스릴러 (Thriller)
		- **9648** - 미스터리 (Mystery)
		- **16** - 애니메이션 (Animation)
		- **18** - 드라마 (Drama)
		- **14** - 판타지 (Fantasy)
		- **36** - 역사 (History)
		- **10751** - 가족 (Family)
		- **10749** - 로맨스 (Romance)
		- **80** - 범죄 (Crime)
	-> 각 카테고리(Now Playing, Popular, Top Rated api를 받아서)각각의 의 vote_average의 값이 8점 이상인 영화들을 보여주면 될 듯 <- 이거 아님ㅋㅋㅋ
	    - 더보기를 클릭하면 MOVIE LISTS의 카테고리 별 영화들을 모두 보여주는 페이지로 이동한다.
		    -> 각각의 카테고리 페이지를 만들고 각각의 api(Now Playing, Popular, Top Rated api) 받아서 렌더링
	    - 영화의 리스트에는 제목, 이미지는 반드시 포함한다.
		    -> title 가져와서 h1으로 렌더링하고 poster_path 가져와서 img로 보여줌
3. 각 카테고리 별 더보기를 누르면 각 카테고리 더보기 페이지에 이동한다
	1. 어차피 형태는 똑같으니 하나의 카테고리 컴포넌트 만들고 props전달해서 만들면 될 듯?
	2. 카테고리 컴포넌트를 만들고 여기에 MovieList의 데이터를 그대로 뿌려주면 되지 않을까/
		1. 이거보단 api 데이터를 뿌려주는 것이 ㄴㅁㅇ러ㅏㅣㅣㅏ런ㅇ미머ㅏㄹㅇㄹㅇ니ㅓㅏ
	3. **여기서 퇴근**
	4. 근데 컴포넌트를 재활용해서 하려면 데이터를 store에 저장을 해야되는데?
		1. 어떻게 해야될까?
			1. kategorie에서 api 데이터를 사용하는 코드를 가져와서 그대로 복붙 
		2. 일단 movie슬라이스 만들고 store로 저장하기 전에 data가 내 생각대로 잘 받아오는 지 확인을 하고 싶은데...
			1. slice는 js파일이라 kategorie 코드를 가져오면 읽을 수가 없음
			2. 어케함 그럼?
			3. 애초에 이렇게 하는 것이 아닌 듯?
4. 각 영화를 누르면 영화의 상세 페이지로 이동한다.
	- 진행 도중 api 구조가 이상하다는 것을 인지하고 다시 api 구조를 재구성
		- 10/28에 수업을 다시 복습(이때 예비군 가서 몰랐음ㅁㄴ어ㅏ리모넝라ㅓㅠㅘㅓㅁㄹ)
			- 이걸로 시간 너무 뺏기는 것 같은데
			- 일단 baseURL 괜찮게 되어 ㅣㅇㅆ는듯 
			- params(api키랑 언어설정?)를 new URLSearchParams로 이용하여 할당을 해서 써야 할 것 같음
```
const baseURL = 'https://api.themoviedb.org/3/movie';

const params = new URLSearchParams({

  api_key: 'eab8c9893e725b2e167187cef66bae3d',

  language: 'ko',

});
// 이렇게 짜고

async function getDetailMovie(movieID) {

  const path = `/${movieID}`;

  const URL = `${baseURL}${path}?${params}`;

  

  const response = await fetch(URL);

  const data = await response.json();

  console.log(data);

  return data;

}
이런식으로 만들고 movie id를 받아오면 그에 맞는 moviedetail 데이터를 뽑아옴

```
 
		
	- 상세 페이지에는 영화의 상세 정보 및 후기를 보여준다.
	- 상세 페이지 만들고 movies details api 사용해서 
		- 상세 정보는 title, overview, runtime, release_date, vote_average, vote_count 가져와서 보여주고 poster_path 가져와서 img로 보여줌(ul,li) 
		- 후기는 reviews api result 가져와서 보여줌

6. 로그인 / 로그아웃 기능을 구현한다.(store로 저장)
	1. 로그인 페이지 만듦
	    - 로그인 과정에서 Username / Password를 입력한다. 
	    - 단 Username / Password는 더미 데이터이며, 실습 때와 마찬가지로 클릭을 통해 로그인 / 로그아웃을 토글한다.
		    - 로그인을 하면 마이페이지로 이동
7. 마이페이지 / 저장한 영화 기능을 구현한다.
    - 로그인을 하면 영화의 상세페이지에서 영화를 저장할 수 있다.
	    - 로그인하면 상세페이지에서 북마크 버튼 생김
	    - 로그아웃 상태에서는 북마크 버튼을 보여주지 않음
	    - 북마크로 저장한 것의 제목과 이미지를 store로 저장관리
    - 저장한 영화를 마이페이지에서 확인할 수 있다.
	    - store에서 관리되는 북마크 정보들을 마이 페이지에서 가져와 보여줌

    
    이 때, 영화의 저장은 TMDB API를 활용하지 않으며, React app 내에 저장하여 사용한다.
    
5. 그 외 기능들은 자유롭게 추가한다.
    
    - 장르 관련 영화 리스트 추가
    - TMDB API를 활용하여 영화 상세페이지에 배우목록 추가
    - TMDB API를 활용하여 검색기능 추가
    
    등
    
- CSS는 tailwind 또는 css-module를 추천한다
    
    - 디테일보다는 전체적인 배치에 집중한다

### 기타

- `.env`를 활용하여 TMDB API KEY를 공개하지 않는다.
- 새로운 git repository를 생성하여 기능 별 commit을 남긴다.
    - git ignore 생성

### 참고

- figma와 같은 wireframe을 활용한 tool 활용 추천
    - wireframe : 웹 사이트의 기본 프레임워크를 나타내는 시각적 가이드

[Figma: The Collaborative Interface Design Tool](https://www.figma.com/)


https://api.themoviedb.org/3/movie/now_playing?api_key=f15d094fa013544c9bab38fbd5d29543&language=ko-kr