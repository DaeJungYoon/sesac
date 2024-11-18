import { configureStore } from "@reduxjs/toolkit";
import postsReducer from "./slices/postsSlice";
import authReduce from "./slices/authSlice";
const store = configureStore({
  reducer: {
    posts: postsReducer,
    auth: authReduce,
  },
});

export default store;
