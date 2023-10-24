import React, { useEffect } from "react";
// import styles from "../styles/Main.module.css";
import subPageStyles from "../styles/subpage.module.css";
import MainStyles from "../styles/Main.module.css";
import { useState } from "react";
import arrays from "../constants/array.js";
import { Route, Routes } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import { Mobile, Desktop } from "../utils/mediaQuery";
import * as constants from "../constants/constants";
import { useSelector, useDispatch } from "react-redux";
import HeaderMenu from "../components/HeaderMenu";
import FooterMenu from "../components/FooterMenu";
import Photos from "../components/Photos";

function Main(props) {
    const dispatch = useDispatch();
    const navigate = useNavigate();

    function preventBubbling(e) {
        e.stopPropagation();
    }

    return (
        <>
            <Mobile>
                <div>메인화면 모바일</div>
            </Mobile>
            <Desktop>
                <div className={MainStyles.container1}>
                    <Routes>
                        <Route path="/*" element={<HeaderMenu />} />
                    </Routes>

                    <p>그림 넣는 하늘색배경</p>
                    <div className={MainStyles.maincontent1}>
                        <h2>오륜스포츠</h2>
                        <div className={MainStyles.subcontent}>
                            <h3>당신의 스포츠를 위한 모든것</h3>
                            <hr style={{ border: `1px solid #ffffff` }} />
                        </div>
                        <p>우리는 철저한 품질 관리와 전문 지식을 통해, 우리는 시설 시공 분야에서 하자 없는 결과물을 제공하고 있습니다.</p>
                        <p>이를 통해 우리는 국내 최고의 체육시설 기업으로의 자리매김을 하였습니다.</p>
                    </div>
                </div>


                <div className={MainStyles.container2}>
                    <div className={MainStyles.contentblock}>
                        <h2>SPORTS</h2>
                        <h3>당신의 스포츠를 위한 모든것</h3>
                        <p>오륜스포츠는 오랜 경험을 토대로
                            뛰어난 설비를 통해 제품과 서비스를 개발하여,
                            이러한 제품과 서비스는 경기력 향상, 안전성, 내구성,
                            경제성, 환경 친화성 등 다양한 측면을 고려하여 설계돼
                            국내 최고의 서비스를 제공해드립니다.</p>
                    </div>

                    <div className={MainStyles.contentblock}>
                        <img alt="문서" />
                        <h2>수십개의 인증서</h2>

                        <p>우리의 제품은 안전성, 내구성, 경제성,
                            그리고 환경 친화성을 결합한 최상의 표준을 충족하며,
                            스포츠 선수와 사용자들에게 뛰어난 경험을 제공합니다.</p>
                    </div>

                    <div className={MainStyles.contentblock}>
                        <img alt="공구" />
                        <h2>시공사례</h2>

                        <p>우리의 제품은 안전성, 내구성, 경제성,
                            그리고 환경 친화성을 결합한 최상의 표준을 충족하며,
                            스포츠 선수와 사용자들에게 뛰어난 경험을 제공합니다.</p>
                    </div>

                    <div className={MainStyles.contentblock}>
                        <img alt="잔디" />
                        <h2>인조잔디</h2>

                        <p>우리의 제품은 안전성, 내구성, 경제성,
                            그리고 환경 친화성을 결합한 최상의 표준을 충족하며,
                            스포츠 선수와 사용자들에게 뛰어난 경험을 제공합니다.</p>
                    </div>

                    <div className={MainStyles.contentblock}>
                        <img alt="코트" />
                        <h2>아크릴 코트</h2>

                        <p>우리의 제품은 안전성, 내구성, 경제성,
                            그리고 환경 친화성을 결합한 최상의 표준을 충족하며,
                            스포츠 선수와 사용자들에게 뛰어난 경험을 제공합니다.</p>
                    </div>

                    <div className={MainStyles.contentblock}>
                        <img alt="사람" />
                        <h2>탄성포장재</h2>

                        <p>우리의 제품은 안전성, 내구성, 경제성,
                            그리고 환경 친화성을 결합한 최상의 표준을 충족하며,
                            스포츠 선수와 사용자들에게 뛰어난 경험을 제공합니다.</p>
                    </div>

                </div>



                <div className={MainStyles.container3}>
                    <p>그림 넣는 분홍색배경</p>
                    <div className={MainStyles.maincontent2}>
                        <h1>
                            "끊임없는 노력과 혁신을 통해 우리는 계속해서 더 나은 결과물을 추구한다"
                        </h1>
                        <p>"Through constant effort and innovation, we continue to pursue better results"</p>
                        <br />
                        <br />
                        <a href="#" className={MainStyles.buttona}>회사소개 바로가기</a>
                    </div>
                </div>

                <div className={MainStyles.container4}>

                <Routes>
                    <Route path="/*" element={<Photos />} />
                </Routes>

                </div>



                <div className={MainStyles.container5}>
                    <span className={MainStyles.channel}>
                        <nav>
                            <p>←</p>
                            <a href="#">아이콘</a>
                            <a href="#">아이콘</a>
                            <a href="#">아이콘</a>
                            <a href="#">아이콘</a>
                            <p>→</p>
                        </nav>
                    </span>
                </div>


                <div className={MainStyles.container6}>
                    <h1>자주하시는 질문</h1>
                    <p>오륜스포츠에 대해서 궁금하신 모든 점에 대해 자세히 알아보세요!
                        우리는 스포츠 시설과 제품, 시공사례, 협력 방법 및
                        기타 관련 정보에 대한 궁금증을 해결하기 위해 여기에 있습니다.
                    </p>
                    <p>
                        스포츠 시설을 개선하거나 새로운 시설을 구축하는데 필요한
                        모든 정보와 지원을 제공하며, 사용자 중심의 디자인,
                        안정성, 내구성, 경제성, 환경 친화성 등
                        다양한 측면을 다루는 오륜스포츠의 전문지식을 탐구하세요.</p>
                    <hr />
                    <div className={MainStyles.qnabox}>
                        <div className={MainStyles.qnablock}>
                            <h2>Q&A</h2>
                            <p>(주)오륜스포츠가 어떤 스포츠 시설과 제품을 제공하였나요?</p>
                            <h3>▽</h3>
                        </div>
                        <div className={MainStyles.qnablock}>
                            <h2>Q&A</h2>
                            <p>오륜스포츠의 제품은 어떻게 경기력 향상, 안정성, 내구성,
                                경제성, 환경 친화성을 고려하여 설계되었나요?
                            </p>
                            <h3>▽</h3>
                        </div>
                        <div className={MainStyles.qnablock}>
                            <h2>Q&A</h2>
                            <p>오륜스포츠의 시공사례는 어떤 특징을 가지고 있으며,
                                고객과 사용자에게 어떤 이점을 제공하고 있나요?
                            </p>
                            <h3>▽</h3>
                        </div>
                    </div>
                </div>

                <Routes>
                    <Route path="/*" element={<FooterMenu />} />
                </Routes>
            </Desktop>
        </>
    );
}

export default Main;
