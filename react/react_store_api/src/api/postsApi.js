import api from "./axios";
// export default 를 했기 때문에 이름은 중요하지 않음

// const endpoint = [
//   post:{
//     get:'',
//     getbtid : (postid)=> `/${postid}`
//   }
// ]

const postApi = {
  // 1. 리스트 GET
  getPosts: async () => {
    const response = await api.get("");
    return response.data;
  },
  // 2. 개별 GET
  getPostById: async (postId) => {
    const response = await api.get(`/${postId}`);
    return response.data;
  },
  // 3. POST
  createPost: async (formData) => {
    const response = await api.post("", formData);
    return response.data;
  },
};

export default postApi;
