import React, { useEffect } from "react";
// import styles from "../styles/Main.module.css";
import subPageStyles from "../styles/subpage.module.css";
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
import Photos from "../components/Photos";
import ContentBox from "../components/ContentBox";

function SubPage4(props) {
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
                    <h1>탄성포장재</h1>
                </div>

                <div className={SubStyles.accessline} style={{ backgroundColor: '#ffad5077' }}></div>

                <div className={SubStyles.container2}>
                    <div className={SubStyles.navs}>
                            <nav>
                                <h2>탄성포장재</h2>
                                <hr style={{ border: '2px solid #ffba60' }} />
                                <a href="#">육상트랙</a>
                                <hr style={{ border: '1px solid #ffba60' }} />
                                <a href="#">다목적구장</a>
                            </nav>
                    </div>

                    <div className={SubStyles.sections}>
                        <h2>육상트랙</h2>
                        <hr style={{ border: '1px solid #999999' }} />
                        <img alt="이미지" style={{ width: '100%', maxHeight: '1000px' }} />
                        <h1>
                            육상트랙 바닥재 (T=13, 15mm)
                        </h1>
                        <hr style={{ border: '1px solid #ffba60' }} />
                        <h3>
                            경제적인 가격으로 학교 운동장 및 종합운동장의 육상트랙으로<br />
                            많이 사용중인 제품입니다. 개정된 KS규격에 적합한 제품으로 중금속 검출이 없으며,<br />
                            반발탄성이 우수한 탄성포장재 입니다.
                        </h3>

                        <Routes>
                            <Route path="/*" element={<ContentBox />} />
                        </Routes>


                        <p>
                            (주)오륜스포츠의 아크릴 테니스코트는 세계적으로 검증된
                            경기성과 안전성을 제공하며, 환경에도 친화적입니다.
                            이 제품을 선택하면 탁월한 경기 경험과 오랜 내구성을
                            누릴 수 있을 뿐 아니라 경제적인 측면에서도 이점을 얻을 수 있습니다.
                            함께 테니스를 즐기며 경기장의 품질과 성능을 한 단계 더 향상시키는 데 기여하시길 바랍니다.
                        </p>
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

export default SubPage4;
