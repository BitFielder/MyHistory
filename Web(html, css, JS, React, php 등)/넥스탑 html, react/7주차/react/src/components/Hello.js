import React from 'react';

const Hello = ({name, color, isTrue}) => {
    return <div style={{color}}>
        {isTrue && <b>True입니다</b>}
        안녕하세요 {name}님
        </div>
}

Hello.defaultProps = {
    name: '이름없음'
}

export default Hello;