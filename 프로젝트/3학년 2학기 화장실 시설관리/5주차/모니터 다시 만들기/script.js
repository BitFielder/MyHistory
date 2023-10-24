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