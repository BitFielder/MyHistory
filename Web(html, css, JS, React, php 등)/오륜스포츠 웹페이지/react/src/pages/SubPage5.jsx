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

function SubPage5(props) {
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
                <Routes>
                    <Route path="/*" element={<Photos />} />
                </Routes>

                </div>

                <div className={SubStyles.accessline} style={{ backgroundColor: '#272727' }}></div>

                <Routes>
                    <Route path="/*" element={<FooterMenu />} />
                </Routes>
            </Desktop>
        </>
    );
}

export default SubPage5;
