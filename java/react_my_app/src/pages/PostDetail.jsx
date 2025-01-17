import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import postApi from '../api/postsApi';

export default function PostDetail() {
  const [post, setPost] = useState({});
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');

  const { postId } = useParams();

  useEffect(() => {
    async function fetchPost() {
      // 게시글 조회 로직
      //   const response = await postApi.getPostById(postId);
      //   const data = response.data;
      //   console.log(data);
      //   setPost(data)
      // }
      try {
        const response = await postApi.getPostById(postId);
        setPost(response.data.data);
      } catch (err) {
        setError(err.message);
        console.error(err.response);
      } finally {
        setLoading(false);
      }
    }
    fetchPost();
  }, []);

  // if (loading) return <div>로딩중...</div>;

  return (
    <div>
      Post Detail
      <div>{post.title}</div>
      <div>{post.content}</div>
      <div>{post.author}</div>
      <div>{post.tags}</div>
    </div>
  );
}
