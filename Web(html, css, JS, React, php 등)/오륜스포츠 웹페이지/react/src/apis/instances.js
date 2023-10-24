import axios from "axios";
import { BASE_URL } from "../constants/constants";

// 공통 axios 인스턴스 ->공통 URL 헤더 토큰(옵션)으로 인스턴스 넘겨주고 호출하는 부분에서 나머지 옵션 추가할 예정
export const defaultAPI = (function () {
  const instance = axios.create({
    baseURL: BASE_URL,
    // timeout: 5000,
    headers: {
      "Content-Type": "application/json",
    },
  });

  // axios.defaults.withCredentials = true;

  function authenticate(getState) {
    if (getState().userInfo.userInfo.access_token !== "") {
      instance.defaults.headers.common["Authorization"] =
        getState().userInfo.userInfo.access_token;
    }
  }

  function authenticate2(getState) {
    if (getState().findInfo.findInfo.access_token !== "") {
      instance.defaults.headers.common["Authorization"] =
        getState().findInfo.findInfo.access_token;
    }
  }

  return {
    instance,
    authenticate,
    authenticate2,
  };
})();
