// import { isNull } from "lodash";
import axios from "axios";
import React, { useEffect, useState } from "react";
import { useSelector } from "react-redux";
import { useLocation, useNavigate, useParams } from "react-router-dom";
import postApi from "../api/postsApi";

export default function PostDetail() {
  const { postId } = useParams();
  // const posts = useSelector((state) => state.posts);
  const [post, setPost] = useState([]);
  const [loading, setLoading] = useState(true);
  // const [erron,setErrror] = useState(null)
  const navigate = useNavigate();

  useEffect(() => {
    const url = "http://localhost:3000/posts/";
    async function renderPost() {
      try {
        // const response = await axios.get(url);
        // const data = response.data;
        // setPost(data.find((post) => post.id === parseInt(postId)));
        const data = await postApi.getPostById(postId);
        setPost(data);
      } catch (err) {
        // err처리 로직
        // navigate("/posts");
        navigate("/not-found", { replace: true });
      } finally {
        setLoading(false);
      }
      // setPosts(data); //화면에 posts 보여줌
    }
    renderPost();
  }, []);
  // 의존성 배열을 []로 두면 useEffect가 컴포넌트가 처음 마운트될 때만 한 번 실행
  // 레더링 후에 한 번만 실행 하기 위해 []
  // 현재 상황에선
  // get이기 때문에 dependencies가 바뀔 일이 없어 안 써도 됨
  // 그러나 개발을 할 때 무언가를 제한시키고
  // 내가 관리를 할 수 있는 것이 좋으므로 사용
  // lifeCycle 다루는 중
  if (loading) return <div>loading...</div>;

  return (
    <div>
      detail
      <h3>{post?.title}</h3>
      <p>{post?.content}</p>
    </div>
  );
}
