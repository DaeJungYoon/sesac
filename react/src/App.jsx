import Login from "./Login";
import LoginNeces from "./LoginNeces";
import OtherPage from "./OtherPage";
import Page from "./Page";

function App() {
  return (
    <div>
      {/* <Login isLogin={true}></Login>
      <Login isLogin={false}></Login> */}
      {/* <LoginNeces isLogin={true}></LoginNeces>
      <LoginNeces isLogin={false}></LoginNeces> */}
      {/* <Page userType="admin"></Page>
      <Page userType="user"></Page> */}
      <OtherPage userType="admin"></OtherPage>
      <OtherPage userType="manager"></OtherPage>
      <OtherPage userType="user"></OtherPage>
    </div>
  );
}
export default App;
