// 메모를 저장할 배열 생성
let memos = [];

// HTML 요소 가져오기
const memoInput = document.getElementById('memo-input');
const addButton = document.getElementById('add-button');
const memoList = document.getElementById('memo-list');

// 메모 추가 함수
function addMemo() {
    const memoText = memoInput.value;
    if (memoText.trim() !== '') {
        memos.push(memoText);
        memoInput.value = '';
        displayMemos();
    }
}

// 메모 목록 표시 함수
function displayMemos() {
    memoList.innerHTML = '';
    memos.forEach((memo, index) => {
        const li = document.createElement('li');
        li.textContent = memo;
        memoList.appendChild(li);
    });
}

// 추가 버튼 클릭 시 이벤트 리스너 등록
addButton.addEventListener('click', addMemo);

// 엔터 키 입력 시 메모 추가
memoInput.addEventListener('keypress', function (e) {
    if (e.key === 'Enter') {
        addMemo();
    }
});

// 초기 메모 목록 표시
displayMemos();

function deleteMemo(index) {
    memos.splice(index, 1);
    displayMemos();
}

// 메모 목록 표시 함수 (수정)
function displayMemos() {
    memoList.innerHTML = '';
    memos.forEach((memo, index) => {
        const li = document.createElement('li');
        li.textContent = memo;
        
        // 삭제 버튼 추가
        const deleteButton = document.createElement('button');
        deleteButton.textContent = '삭제';
        deleteButton.addEventListener('click', () => {
            deleteMemo(index);
        });
        
        li.appendChild(deleteButton);
        memoList.appendChild(li);
    });
}


function setColorBasedOnValue(elementId,elementId2) {
    var element = document.getElementById(elementId);
    var element2 = document.getElementById(elementId2);

    if (element) {
        var value = parseInt(element.innerHTML);

        if (value <= 100) {
            element2.style.color = "blue"; // 100 이하일 때 파랑
        } else if (value <= 200) {
            element2.style.color = "green"; // 101~200일 때 초록
        } else if (value <= 300) {
            element2.style.color = "yellow"; // 201~300일 때 노랑
        } else if (value <= 400) {
            element2.style.color = "orange"; // 201~300일 때 노랑
        } else {
            element2.style.color = "red"; // 201~300일 때 노랑
        }
    }
}

// 함수 호출 예제
setColorBasedOnValue("value11","warning11");
setColorBasedOnValue("value12","warning12");