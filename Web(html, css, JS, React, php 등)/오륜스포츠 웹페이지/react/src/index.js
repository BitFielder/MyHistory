import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import App from "./App";
import reportWebVitals from "./reportWebVitals";
import { composeWithDevTools } from "@redux-devtools/extension";

// -- Redux
import { createStore, applyMiddleware, compose } from "redux";
import ReduxThunk from "redux-thunk";
import { Provider } from "react-redux";
import rootReducers from "./redux/reducers/index";
import { persistStore } from "redux-persist";
import { PersistGate } from "redux-persist/integration/react";
import { createBrowserHistory } from "history";
import { unstable_HistoryRouter as HistoryRouter } from "react-router-dom";

const customHistory = createBrowserHistory();

var devCompose = composeWithDevTools(
  applyMiddleware(ReduxThunk.withExtraArgument({ history: customHistory }))
)

var prodCompose = compose(applyMiddleware(ReduxThunk.withExtraArgument({ history: customHistory })))

// 개발 redux dev툴 사용
// const store = createStore(
//   rootReducers,
//   devCompose
// );

// 운영 redux dev툴 미사용
const store = createStore(
  rootReducers,
  prodCompose
);

const persistor = persistStore(store);

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  // <React.StrictMode>
  <Provider store={store}>
    <HistoryRouter history={customHistory}>
      <PersistGate loading={null} persistor={persistor}>
        {/* <ScrollTop /> */}
        <App />
      </PersistGate>
    </HistoryRouter>
  </Provider>
  // </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
