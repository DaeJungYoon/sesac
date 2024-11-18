import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { addPost } from "../store/slices/postsSlice";
import { Navigate, useNavigate } from "react-router-dom";
import axios from "axios";
import postApi from "../api/postsApi";

export default function PostCreate() {
  const { isLoggedIn } = useSelector((state) => state.auth);
  const [formData, setFormData] = useState({ title: "", content: "" });
  const dispatch = useDispatch();
  const navigate = useNavigate();

  // 최초 한번, 또는 dependency가 바뀌었을 때
  useEffect(() => {
    if (!isLoggedIn) {
      navigate("/");
    }
  }, [isLoggedIn]);

  function handleFormInput(e) {
    // 우리의 state를 변경하고 싶어.
    // input의 value를 우리의 state에 넣고 싶어.
    const inputValue = e.target.value;
    const key = e.target.name;
    setFormData({
      ...formData,
      [key]: inputValue,
    });
  }

  function handleSubmit(e) {
    e.preventDefault();
    async function createPost() {
      // const url = "http://localhost:3000/posts/";
      // const response = await axios.post(url, formData);
      // const data = response.data;
      const data = await postApi.createPost(formData);
      setFormData(data)
      const id = data.id;
      // console.log(data);
      // console.log(id);
      navigate(`/posts/${id}`);
    }
    createPost();
    // const id = Date.now(); // 임시 id

    // // dispatch(addPost({ ...formData, id }));
    // navigate(`/posts/${id}`);
    // // navigate(`/posts`)
  }
  return (
    <>
      <h3>PostCreate</h3>
      <form onSubmit={handleSubmit}>
        <label htmlFor="title">제목 : </label>
        <input
          type="text"
          name="title"
          id="title"
          // 인풋에 입력이 되었을 때 우리의 state를 변경하고 싶어.
          onChange={handleFormInput}
        />

        <label>
          내용 :
          <textarea name="content" id="" onChange={handleFormInput}></textarea>
        </label>

        <button>제출</button>
      </form>
    </>
  );
}
