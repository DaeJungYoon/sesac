import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';

import postApi from '../api/postsApi';

export default function PostList() {
  const [posts, setPosts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');

  useEffect(() => {
    async function fetchPosts() {
      // // 게시글 조회 로직
      // const response = await postApi.getPosts();
      // const date = response.data;
      // // data.data <- posts
      // setPosts(date.data);
      try {
        const response = await postApi.getPosts();
        const data = response.data;

        setPosts(data.data);
      } catch (err) {
        setError(err.message);
        console.error(err.responase);
      } finally {
        setLoading(false);
      }
    }

    fetchPosts();
  }, []);

  // if (loading) {
  //   return <div>로딩중</div>;
  // }

  // if (error) {
  //   return <div>{error}</div>;
  // }

  return (
    <div>
      <h2>Post List</h2>
      <ul>
      {posts.map((post) => {
          const { id, title } = post;
          return (
            <li key={id}>
              <Link to={`/posts/${id}`}>
                <h3>
                  {id} : {title}
                </h3>
              </Link>
            </li>
          );
        })}
      </ul>
    </div>
  );
}
