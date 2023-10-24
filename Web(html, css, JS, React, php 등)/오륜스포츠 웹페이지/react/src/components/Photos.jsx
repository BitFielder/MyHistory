import React from "react";
import ObjectStyle from "../styles/objectstyle.module.css";

const Photos = (props) => (
    <div style={{textAlign: 'center'}}>
        
        <h1>PORTFOLIO</h1>
        <p>우리의 시공사례는 우리의 열정과 전문지식을 보여주는 증거입니다.
            최고 수준의 시설을 구축하기 위한 노력과 열정은
            고객과 사용자에게 안전하고 현대적인 스포츠 경기장을 제공합니다.
        </p>
        <p>
            우리의 시공사례는 경기력 향상, 안전성, 내구성,
            경제성, 환경 친화성에 대한 우리의 헌신을 대변하며,
            고객의 스포츠 시설 개선을 위해 더 나은 선택을 만들게끔 돕습니다.
        </p>
        <hr style={{maxWidth: "400px"}}/>
        <nav className={ObjectStyle.photonav}>
            <a href="#">ALL</a>
            <p>-</p>
            <a href="#">아크릴코트</a>
            <p>-</p>
            <a href="#">탄성포장재</a>
            <p>-</p>
            <a href="#">인조잔디</a>
        </nav>
        <div className={ObjectStyle.photodiv}>
            <img src="image1.jpg" alt="Image 1"/>
            <img src="image2.jpg" alt="Image 2"/>
            <img src="image3.jpg" alt="Image 3"/>
            <img src="image4.jpg" alt="Image 4"/>
            <img src="image4.jpg" alt="Image 5"/>
            <img src="image4.jpg" alt="Image 6"/>
        </div>
    </div>
);
export default Photos;
