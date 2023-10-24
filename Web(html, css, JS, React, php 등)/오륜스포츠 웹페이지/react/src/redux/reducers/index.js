import { combineReducers } from "redux";

import { persistReducer } from "redux-persist";
import storage from "redux-persist/lib/storage/session";
import toast from "./toast";


//리듀서 기능별로 쪼개는 용
const appReducers = combineReducers({
  toast,
});

const rootReducers = (state, action) => {
  // if (action.type === USER_LOGOUT) {
  //   return appReducers(undefined, action);
  // }
  return appReducers(state, action);
};

const persistConfig = {
  key: "root",
  storage,
  blacklist: [
    // "modal",
    // "expertOpinion",
    // "orgDailyStatus",
    // "centerStatus",
    // "calendar",
    // "measureHistory",
    // "address",
    // "signUp",
    // "findInfo",
  ],
};

export default persistReducer(persistConfig, rootReducers);
