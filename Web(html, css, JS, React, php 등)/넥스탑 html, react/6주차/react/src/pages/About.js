import React from "react";

function About() {
    return (
        <div>
            <ul>
                <li>리스트1</li>
                <li>리스트2</li>
                <li>리스트3</li>
            </ul>
            <select name="email">
                <option value="">선택</option>
                <option value="naver">naver.com</option>
                <option value="gmail">gmail.com</option>
                <option value="daum">daum.com</option>
            </select>
            <h2>About 스크립트입니다.</h2>
        </div>
    )
}

export default About;