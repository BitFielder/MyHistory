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

function SubPage3(props) {
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
                    <h1>아크릴코트</h1>
                </div>

                <div className={SubStyles.accessline} style={{ backgroundColor: '#ffad5077' }}></div>

                <div className={SubStyles.container2}>
                    <div className={SubStyles.navs}>
                            <nav>
                                <h2>아크릴코트</h2>
                                <hr style={{ border: '2px solid #ffba60' }} />
                                <a href="#">테니스코트</a>
                                <hr style={{ border: '1px solid #ffba60' }} />
                                <a href="#">인라인스케이트</a>
                            </nav>
                    </div>


                    <div className={SubStyles.sections}>
                        <h2>아크릴코트</h2>
                        <hr style={{ border: '1px solid #999999' }} />
                        <img alt="이미지" style={{ width: '100%', maxHeight: '1000px' }} />
                        <h1>
                            아크릴 테니스코트 (T=4~7mm)
                        </h1>
                        <hr style={{ border: '1px solid #ffba60' }} />
                        <h3>
                            호주 오픈에서 이미 검증 완료된 공인된 제품으로<br />
                            국제 테니스연맹(ITF) 인증을 받은 제품이며 특수 논슬립처리 기술로 우천시에도<br />
                            쾌적하고 안전한 경기가 가능한 하드코트 포장재입니다.
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

export default SubPage3;
