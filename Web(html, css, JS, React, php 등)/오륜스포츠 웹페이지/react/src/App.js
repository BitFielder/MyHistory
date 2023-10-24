import { Route, Routes } from "react-router";
import Error from "./pages/Error";
import Main from "./pages/Main";
import Subpage1 from "./pages/SubPage1";
import Subpage2 from "./pages/SubPage2";
import Subpage3 from "./pages/SubPage3";
import Subpage4 from "./pages/SubPage4";
import Subpage5 from "./pages/SubPage5";
import { ToastContainer } from "react-toastify";
import { useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";

function App() {
  const dispatch = useDispatch();



  return (
    <>
      <ToastContainer />
      <Routes>
        <Route path="/*" element={<Main />} />
        <Route path="/error" element={<Error />} />
        <Route path="*" element={<Error />} />
        <Route path="/sub1" element={<Subpage1 />} />
        <Route path="/sub2" element={<Subpage2 />} />
        <Route path="/sub3" element={<Subpage3 />} />
        <Route path="/sub4" element={<Subpage4 />} />
        <Route path="/sub5" element={<Subpage5 />} />
      </Routes>
    </>
  );
}

export default App;
