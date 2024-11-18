import React, { useEffect, useState } from "react";
import { useSelector } from "react-redux";
import { Link, useNavigate } from "react-router-dom";
import axios from "axios";
import postApi from "../api/postsApi";

export default function PostList() {
  const navigate = useNavigate();
  const [posts, setPosts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  //useEffect로 감싸주는 이유? 비동기 동작은 useEffect로 감싸주자라고 알고 있자
  useEffect(() => {
    async function fetchPost() {
      const url = "http://localhost:3000/posts";
      try {
        // const response = await axios.get(url);
        // const data = response.data;
        // setPosts(data); //화면에 posts 보여줌
        const data = await postApi.getPosts();
        setPosts(data);
      } catch (err) {
        setError(err.message);
        console.error(err);
        console.log("에러남");
      } finally {
        setLoading(false);
      }

      // const posts = useSelector((state) => state.posts);
      // const url = "http://localhost:3000/posts";
      // const response = await axios.get(url);
      // const response = await axios({url:url})
      // axios({
      //   method:'get'
      // })
      // axios.get()
      // method와 url 이 있어야 하는데 축약을 해준것 아무것도 안 적어부면
      // 기본 method는 get 적용

      // const data = response.data;
    }
    fetchPost();
  }, []);

  if (error) {
    return <div> error</div>;
  }
  if (loading) {
    return <div>loading</div>;
  }
  // if (!posts) {
  //   return <div>데이터 없어!</div>;
  // }
  return (
    <div>
      <h2>posts</h2>
      <ul>
        {posts.map((post) => {
          const { id, title, content } = post;
          return (
            <li key={id}>
              <Link to={`/posts/${id}`} state={{ post }}>
                <h3>{title}</h3>
              </Link>
              <h3
                onClick={() => {
                  // 이동을 하고 싶다
                  navigate(`/posts/${id}`);
                }}
              >
                {title}
              </h3>
            </li>
          );
        })}
      </ul>
    </div>
  );
}
