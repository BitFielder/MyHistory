// script.js

// 오늘 날짜를 가져오는 함수
function getToday() {
  var now = new Date();
  var year = now.getFullYear();
  var month = now.getMonth() + 1;
  var day = now.getDate();
  return year + "-" + month + "-" + day;
}

// 오늘과 총 접속자 수를 저장하는 변수
var todayCount = 0;
var totalCount = 0;

// 페이지가 로드될 때 실행되는 함수
window.onload = function () {
  // 오늘과 총 접속자 수를 가져오기
  var storedToday = localStorage.getItem("today");
  var storedTotal = localStorage.getItem("total");

  // 저장된 값이 있으면 변수에 할당
  if (storedToday) {
    todayCount = parseInt(storedToday);
  }
  if (storedTotal) {
    totalCount = parseInt(storedTotal);
  }

  // 오늘 접속자 수와 총 접속자 수를 표시
  document.getElementById("todayCount").textContent = todayCount;
  document.getElementById("totalCount").textContent = totalCount;
};

// 페이지를 닫을 때 실행되는 함수
window.onbeforeunload = function () {
  // 오늘과 총 접속자 수를 로컬 스토리지에 저장
  localStorage.setItem("today", todayCount);
  localStorage.setItem("total", totalCount);
};

// 페이지에 접속했을 때 실행되는 함수
function pageLoaded() {
  // 오늘 접속자 수 증가
  todayCount++;

  // 총 접속자 수 증가
  totalCount++;

  // 오늘 접속자 수와 총 접속자 수를 업데이트
  document.getElementById("todayCount").textContent = todayCount;
  document.getElementById("totalCount").textContent = totalCount;
}

var emailtext = "ashe152@kbu.ac.kr";

// 복사 버튼 클릭 이벤트 리스너 등록
function copybutton() {
  // 문자열 복사
  copyToClipboard(emailtext);

  // 말풍선 보이기
  showtextbox1();
};

// 문자열 복사 함수
function copyToClipboard(text) {
  var textarea = document.createElement("textarea");
  textarea.value = text;
  document.body.appendChild(textarea);
  textarea.select();
  document.execCommand("copy");
  document.body.removeChild(textarea);
}

// 말풍선 보이기 함수
function showtextbox1() {
  var textbox1 = document.getElementById("textbox1");
  textbox1.classList.add("show"); // show 클래스 추가

  // 일정 시간 후에 말풍선 숨기기
  setTimeout(function () {
    textbox1.classList.remove("show"); // show 클래스 제거
  }, 2000);
}










// 말풍선 보이기 함수
function showtextbox2() {
  var textbox1 = document.getElementById("textbox2");
  textbox1.classList.add("show"); // show 클래스 추가

  // 일정 시간 후에 말풍선 숨기기
  setTimeout(function () {
    textbox1.classList.remove("show"); // show 클래스 제거
  }, 2000);
}


function copytext() {
  var text = document.getElementById("ipshow").innerHTML;
  var input = document.createElement("input");
  input.value = text;
  document.body.appendChild(input);
  input.select();
  document.execCommand("copy");
  document.body.removeChild(input);
  showtextbox2();
}
function changeIdToIPv4() {
  const ipv6allow = document.getElementById("ipv6allow");
  const ipv6deny = document.getElementById("ipv6deny");
  $.getJSON("https://api.ip.pe.kr/json/", function (json) {
    console.log(json.ip);
    const ipv4 = document.getElementById("ipshow");
    ipv4.innerHTML = json.ip;
    ipv6allow.style.display = 'block';
    ipv6deny.style.display = 'none';
  });
}

function changeIdToIPv6() {
  const ipv6allow = document.getElementById("ipv6allow");
  const ipv6deny = document.getElementById("ipv6deny");
  var request = new XMLHttpRequest();
  request.open("GET", "https://api6.ipify.org?format=json");

  request.onload = function () {
    if (request.status === 200) {
      var data = JSON.parse(request.responseText);
      document.getElementById("ipshow").textContent = data.ip;
      ipv6allow.style.display = 'block';
      ipv6deny.style.display = 'none';
    } else {
      document.getElementById("ipdeny").textContent = "IPv6 주소를 찾을 수 없습니다.";
      ipv6deny.style.display = 'block';
      ipv6allow.style.display = 'none';
    }
  };

  request.onerror = function () {
    document.getElementById("ipv6deny").textContent = "IPv6 주소를 찾을 수 없습니다. API 서버에 문제가 있습니다.";
    ipv6allow.style.display = 'none';
    ipv6deny.style.display = 'block';
  };

  request.send();
}

$(function () {
  const ipv6allow = document.getElementById("ipv6allow");
  const ipv6deny = document.getElementById("ipv6deny");
  $.getJSON("https://api.ip.pe.kr/json/", function (json) {
    console.log(json.ip);
    const ipv4 = document.getElementById("ipshow");
    ipv4.innerHTML = json.ip;
    ipv6allow.style.display = 'block';
    ipv6deny.style.display = 'none';
  });
});







$('#color-picker').spectrum({
  type: "flat",
  preferredFormat: "hex",   // hex hex3 hsl rgb name
  togglePaletteOnly: false,   // 줄이기 버튼
  showInput: true,
  showInitial: true,
  showButtons: false
});

$("#color-picker").on('move.spectrum', function (e, tinycolor) {
  const hex = tinycolor.toHex();
  const rgba = tinycolor.toRgb();
  console.log(hex);
  console.log(rgba);
});





function convert() {
  const input = document.getElementById('input').value;
  let result = "";

  if (!isNaN(input)) {
    result = String.fromCharCode(input);
  } else {
    result = input.charCodeAt(0);
    //document.getElementById('result').textContent = `값을 입력해주세요!`;
  }
  document.getElementById('result').textContent = `입력한 "${input}"의 상호 변환값은 "${result}" 입니다!`;
}

function showascii() {
  var display = document.getElementById("asciidoct").style.display;
  if (display === "block") {
      document.getElementById("asciidoct").style.display = "none";
  } else {
      document.getElementById("asciidoct").style.display = "block";
  }
}