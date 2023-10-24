import React from "react";
import ObjectStyle from "../styles/objectstyle.module.css";

const FooterMenu = (props) => (
    <div>
        <footer>
            <nav>
                <a href="#">모션텝 로고</a>
                <span>
                    <div style={{ textalign: 'left'}}>
                        <p>(주) 오륜스포츠</p>
                        <p>충청남도 서산시 고수관로 17-27 (가구리 725-1)
                            TEL : 041-666-7002 / FAX : 041-666-7003
                            E-mail : ohrun@ohrun.co.kr
                            사업자번호 : 729-81-00570
                        </p>
                        <p>Copyrightⓒ (주)오륜스포츠.All rights reserved.</p>
                    </div>
                </span>
            </nav>
        </footer>
    </div>
);
export default FooterMenu;
