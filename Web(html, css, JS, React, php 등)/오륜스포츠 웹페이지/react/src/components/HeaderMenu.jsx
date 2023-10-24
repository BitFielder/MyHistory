import React from "react";
import ObjectStyle from "../styles/objectstyle.module.css";

const HeaderMenu = (props) => (
  <div>
    <span className={ObjectStyle.headerspan}>
      <a href="/*">(주) 오륜스포츠</a>
      <nav>
        <a href="/sub1">회사소개</a>
        <a href="/sub2">인조잔디</a>
        <a href="/sub3">아크릴코트</a>
        <a href="/sub4">탄성포장재</a>
        <a href="/*">품질보증</a>
        <a href="/sub5">시공사례</a>
      </nav>
    </span>
  </div>
);
export default HeaderMenu;
