import React, { useEffect } from "react";
// import styles from "../styles/Main.module.css";
import SubStyles from "../styles/subpage.module.css";
import { useState } from "react";
import arrays from "../constants/array.js";
import { Route, Routes } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import { Mobile, Desktop } from "../utils/mediaQuery";
import * as constants from "../constants/constants";
import { useSelector, useDispatch } from "react-redux";
import HeaderMenu from "../components/HeaderMenu";
import FooterMenu from "../components/FooterMenu";

function SubPage1(props) {
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


                <header>
                    <Routes>
                        <Route path="/*" element={<HeaderMenu />} />
                    </Routes>
                </header>
                <div className={SubStyles.container1}>
                    <p>그림 넣는 배경</p>
                    <h1>회사소개</h1>
                </div>

                <div className={SubStyles.accessline} style={{ backgroundColor: '#ffad5077' }}></div>

                <div className={SubStyles.container2}>
                    <div className={SubStyles.navs}>
                            <nav>
                                <h2>회사소개</h2>
                                <hr style={{ border: '2px solid #ffba60' }} />
                                <a href="#">인사말</a>
                                <hr style={{ border: '1px solid #ffba60' }} />
                                <a href="#">연혁</a>
                                <hr style={{ border: '1px solid #ffba60' }} />
                                <a href="#">인증서</a>
                                <hr style={{ border: '1px solid #ffba60' }} />
                                <a href="#">오시는길</a>
                            </nav>
                    </div>


                    <div className={SubStyles.sections}>
                        <h2>인사말</h2>
                        <hr style={{ border: '1px solid #999999' }} />
                        <div className={SubStyles.sub1contentbox}>
                            <div className={SubStyles.sub1textbox}>
                                <h1>
                                    안녕하세요?
                                </h1>
                                <h2>
                                    (주)오륜스포츠를<br />방문하여 주시어 감사를 드립니다.
                                </h2>
                                <p>
                                    (주)오륜스포츠는 국내 최고의 체육시설 기업으로서 자랑스럽게 소개합니다.
                                    우리는 친환경적이며 우수한 품질의 인조잔디로써 축구장, 하키장, 야구장,
                                    테니스장, 풋살장, 그리고 육성트랙 및 아크릴 하드코트 제품을 자랑스럽게 보유하고 있습니다.
                                </p>
                                <p>
                                    우리의 철저한 품질 관리와 전문 지식을 통해, 우리는 시설 시공 분야에서
                                    하자 없는 결과물을 제공하고 있습니다. 이를 통해 우리는 국내 최고의 체육시설 기업으로의
                                    자리매김을 하였습니다. 하지만, 우리는 "노력없는 천재는 없다."는 원칙을 믿고 있습니다.
                                    끊임없는 노력과 혁신을 통해 우리는 계속해서 더 나은 결과물을 추구하고 있습니다.
                                </p>
                                <p>
                                    우리는 자연과 인간을 항상 우선시하며, 지속 가능한 체육시설을 구축하기 위해
                                    노력하고 있습니다. 우리의 목표는 체육 활동을 통해 더 건강하고 행복한 사회를
                                    조성하는 데 일조할 것입니다.
                                </p>
                                <p>
                                    (주)오륜스포츠와 함께, 미래의 체육환경을 구축하는 데 동참하시어,
                                    함께 더 나은 세상을 만들어나가는데 기여해주시길 바랍니다. 고객 여러분께 감사의 마음을 전하며,
                                    앞으로도 끊임없는 협력과 성장을 기대하고 있습니다.
                                </p>
                            </div>
                            <div className={SubStyles.sub1imgbox}>
                                <img src="image1.jpg" alt="Image 1"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div className={SubStyles.accessline} style={{ backgroundColor: '#272727' }}></div>

                <Routes>
                    <Route path="/*" element={<FooterMenu />} />
                </Routes>
            </Desktop>
        </>
    );
}

export default SubPage1;
