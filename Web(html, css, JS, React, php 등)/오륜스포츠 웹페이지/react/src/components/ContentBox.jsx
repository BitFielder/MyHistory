import React from "react";
import ObjectStyle from "../styles/objectstyle.module.css";

const ContentBox = (props) => (
    <div className={ObjectStyle.contents}>
        <div className={ObjectStyle.contentbox}>
            <img />
            <h1>안전성</h1>
            <hr style={{ maxWidth: '100px', border: 'px solid #999999' }} />
            <p>중금속 오염이 없어서 안심하고 사용하실 수 있으며,
                환경표지인증 및 KS 인증을 획득하여 그 안정성을 입증하고 있습니다.
            </p>
        </div>
        <div className={ObjectStyle.contentbox}>
            <img />
            <h1>내구성</h1>
            <hr style={{ maxWidth: '100px', border: 'px solid #999999' }} />
            <p>
                잔디의 파일이 하나의 섬유로 제조되어 유지관리 시 잔디가 손상디지 않아
                초기상태를 오래 유지할 수 있어, 시설 소유자 및 운영자에게
                경제적인 이점을 제공합니다.
            </p>
        </div>
        <div className={ObjectStyle.contentbox}>
            <img />
            <h1>뛰어난 경기성</h1>
            <hr style={{ maxWidth: '100px', border: 'px solid #999999' }} />
            <p>
                잔디의 파일이 하나의 섬유로 제조되어 유지관리 시 잔디가 손상디지 않아
                초기상태를 오래 유지할 수 있어, 시설 소유자 및 운영자에게
                경제적인 이점을 제공합니다.
            </p>
        </div>
        <div className={ObjectStyle.contentbox}>
            <img />
            <h1>경제성</h1>
            <hr style={{ maxWidth: '100px', border: 'px solid #999999' }} />
            <p>
                잔디의 파일이 하나의 섬유로 제조되어 유지관리 시 잔디가 손상디지 않아
                초기상태를 오래 유지할 수 있어, 시설 소유자 및 운영자에게
                경제적인 이점을 제공합니다.
            </p>
        </div>

    </div>
);
export default ContentBox;
