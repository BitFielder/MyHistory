import { refreshToken } from "../redux/actions/refreshToken";
import { defaultAPI } from "./instances";
// import { SHOW_LOADER, CLOSE_LOADER } from "../constants/constants";

export const tokenLessRequest = (options) => {
  return defaultAPI.instance(options).then((res) => res);
};

export const tokenRequest = (options, getState, dispatch, action, data) => {
  defaultAPI.authenticate(getState);
  //   dispatch({ type: SHOW_LOADER });

  return defaultAPI
    .instance(options)
    .then((res) => {
      //   dispatch({ type: CLOSE_LOADER });
      return res;
    })
    .catch((event) => {
      switch (event.response.status) {
        case 498:
          //리프레시 토큰 처리
          dispatch(
            refreshToken(
              {
                refresh_token: getState().userInfo.refreshToken,
              },
              action,
              data
            )
          );
          //받아온거

          break;
      }
    });
};

export const onlyResetPwRequest = (
  options,
  getState,
  dispatch,
  action,
  data
) => {
  defaultAPI.authenticate2(getState);
  //   dispatch({ type: SHOW_LOADER });

  return defaultAPI
    .instance(options)
    .then((res) => {
      //   dispatch({ type: CLOSE_LOADER });
      return res;
    })
    .catch((event) => {
      switch (event.response.status) {
        case 498:
          //리프레시 토큰 처리
          dispatch(
            refreshToken(
              {
                refresh_token: getState().userInfo.refreshToken,
              },
              action,
              data
            )
          );
          //받아온거

          break;
      }
    });
};

export const tokenLessRequest2 = (options, getState, dispatch, history) => {
  return defaultAPI
    .instance(options)
    .then((res) => res)
    .catch((event) => {
      switch (event.response.status) {
        default:
          // case 498:
          //리프레시 토큰 처리
          // 로그인 페이지로 보내버려야되는데 어캐하냐
          // console.log("로그인 페이지로 이동");
          history.push("/");
          //받아온거

          break;
      }
    });
};
