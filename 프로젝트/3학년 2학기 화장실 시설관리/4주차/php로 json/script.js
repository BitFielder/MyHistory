// script.js

/*


자유롭게 추가하고 삭제하는 기능은 추후에 구현할 예정입니다.


// 모니터 내의 객체 컨테이너와 제어 버튼들을 가져옵니다.
const objectsContainer = document.querySelector('.monitor');
const addObjectButton = document.getElementById('addObject');
const editObjectButton = document.getElementById('editObject');
const deleteObjectButton = document.getElementById('deleteObject');
const resizeMonitorButton = document.getElementById('resizeMonitor');
const changeLayoutButton = document.getElementById('changeLayout');

// 객체 추가 버튼을 클릭하면 새로운 객체를 추가합니다.
addObjectButton.addEventListener('click', () => {
    const newObject = document.createElement('div');
    newObject.classList.add('objects');
    newObject.innerHTML = '<h3>n번 기기</h3><p>온습도</p><p>조도</p><p>이외 옵션</p>';
    objectsContainer.appendChild(newObject);
});
*/

// 객체 수정 버튼을 클릭하면 첫 번째 객체의 내용을 수정합니다.
/*
editObjectButton.addEventListener('click', () => {
    const firstObject = objectsContainer.querySelector('.objects');
    if (firstObject) {
        firstObject.innerHTML = '<h3>수정된 객체</h3><p>새로운 내용</p>';
    }
});
*/

/*

// 객체 삭제 버튼을 클릭하면 첫 번째 객체를 삭제합니다.
deleteObjectButton.addEventListener('click', () => {
    const firstObject = objectsContainer.querySelector('.objects');
    if (firstObject) {
        objectsContainer.removeChild(firstObject);
    }
});

*/

// 모니터 크기 조정 버튼을 클릭하면 모니터의 크기를 변경합니다.
/*
resizeMonitorButton.addEventListener('click', () => {
    const monitor = document.querySelector('.monitor');
    if (monitor) {
        monitor.style.width = '500px'; // 크기를 조정할 수 있습니다.
    }
});*/

// 레이아웃 변경 버튼을 클릭하면 모니터와 메뉴의 위치를 변경합니다.
/*
changeLayoutButton.addEventListener('click', () => {
    const container = document.querySelector('.container');
    if (container) {
        container.classList.toggle('layout-horizontal');
    }
});
*/
