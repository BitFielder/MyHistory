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

function SubPage2(props) {
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
                    <h1>인조잔디</h1>
                </div>

                <div className={SubStyles.accessline} style={{ backgroundColor: '#ffad5077' }}></div>

                <div className={SubStyles.container2}>
                    <div className={SubStyles.navs}>
                            <nav>
                                <h2>인조잔디</h2>
                                <hr style={{ border: '2px solid #ffba60' }} />
                                <a href="#">축구, 야구 등</a>
                                <hr style={{ border: '1px solid #ffba60' }} />
                                <a href="#">테니스코트</a>
                                <hr style={{ border: '1px solid #ffba60' }} />
                                <a href="#">축구장</a>
                            </nav>
                    </div>


                    <div className={SubStyles.sections}>
                        <h2>인사말</h2>
                        <hr style={{ border: '1px solid #999999' }} />
                        <img alt="이미지" style={{ width: '100%', maxHeight: '1000px' }} />
                        <h1>
                            친환경 인조잔디 (OR-55/OR-45/OR-35/OR-20)
                        </h1>
                        <hr style={{ border: '1px solid #ffba60' }} />
                        <h3>
                            중금속 오염이 없는 안전한 제품으로 천연잔디의 경기성을 가지고 있으며<br />
                            파일복원과 형상력이 최적화된 제품입니다.<br />
                            환경표지인증 및 KS인증을 획득하여 제품의 안전성을 입증합니다.
                        </h3>

                        <Routes>
                            <Route path="/*" element={<ContentBox />} />
                        </Routes>


                        <p>
                            우리는 이 친환경 인조잔디를 통해 안전하고 지속 가능한
                            스포츠 환경을 조성하고자 합니다. 이제, 환경을 보호하고,
                            최고의 스포츠 경험을 즐길 수 있는 친환경적인 인조잔디를 선택하여,
                            스포츠 시설의 품질과 성능을 한 단계 더 끌어올려보세요.
                            함께 스포츠를 즐기며 환경을 지키고
                            지속 가능한 미래를 향해 나아가는 데 기여하시길 바랍니다.
                        </p>

                        <hr style={{ border: '1px solid #ffba60' }} />
                        <table className={SubStyles.optiontable}>
                            <tr>
                                <th>종류</th>
                                <th>파일 길이 (mm)</th>
                                <th>충전재 (탑성칩)</th>
                                <th>충격흡수 패드</th>
                                <th>비고 (대표용도)</th>
                            </tr>
                            <tr>
                                <td>A-1</td>
                                <td>55, 65</td>
                                <td>포함</td>
                                <td>불포함</td>
                                <td>축구, 야구 등</td>
                            </tr>
                        </table>
                        <hr style={{ margin: '0px' }} />
                        <table className={SubStyles.optiontable}>
                            <tr>
                                <td>A-2</td>
                                <td>35, 45</td>
                                <td>불포함</td>
                                <td>포함</td>
                                <td>축구, 야구 등</td>
                            </tr>
                        </table>
                        <hr style={{ margin: '0px' }} />
                        <table className={SubStyles.optiontable}>
                            <tr>
                                <td>B-1</td>
                                <td>20, 25, 35, 45</td>
                                <td>불포함</td>
                                <td>불포함</td>
                                <td>테니스, 게이트볼, 론블링 등</td>
                            </tr>
                        </table>
                        <hr style={{ margin: '0px' }} />
                        <table className={SubStyles.optiontable}>
                            <tr>
                                <td>B-2</td>
                                <td>10, 15, 20, 25, 35</td>
                                <td>불포함</td>
                                <td>포함</td>
                                <td>하키, 테니스, 게이트볼, 론블링 등</td>
                            </tr>
                        </table>
                        <hr style={{ margin: '0px' }} />
                        <table className={SubStyles.optiontable}>
                            <tr>
                                <td>B-3</td>
                                <td>10, 15, 20, 25, 35</td>
                                <td>포함/불포함</td>
                                <td>불포함</td>
                                <td>다목적 등</td>
                            </tr>
                        </table>

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

export default SubPage2;
