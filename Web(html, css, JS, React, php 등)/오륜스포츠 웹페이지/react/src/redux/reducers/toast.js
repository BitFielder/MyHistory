import * as constants from "../../constants/constants";

//컴바인 리듀서 예시 나중에 기능별로 쪼개서 쓸꺼임
export default function toast(
  state = {
    toastMsg: "",
    toastType: "0", //0: 에러, 1: 성공, 2: 경고
  },
  action
) {
  switch (action.type) {
    case constants.SET_TOAST:
      return Object.assign({}, state, {
        toastMsg: action.payload.toastMsg,
        toastType: action.payload.toastType,
      });

    case constants.CLEAR_TOAST:
      return Object.assign({}, state, {
        toastMsg: "",
      });
    default:
      return state;
  }
}
