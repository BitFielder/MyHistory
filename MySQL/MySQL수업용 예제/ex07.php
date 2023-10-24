<?php

// for문을 사용하여 섭씨온도를 화씨온도로 변환하는 표 만들기
// 섭씨 -20도에서 40도까지 5씩 증가
// 화씨 = 섭씨 * 1.8 + 32
 // 초기값 저장
echo "<h2>섭씨 온도를 화씨 온도로 변환</h2>";
echo "<table border = 1>"; // 테두리 굵기가 1인 표를 만들기
echo "<tr>"; // 첫번째 줄 생성
echo "<th width = 150>섭씨</th><th width=150>화씨</th>";

//<th>는 제목칸을 만드는 태그임
echo "</tr>"; //첫번째 줄 종료
	for($c = -20;$c<=40;$c += 5){
		$f = $c * 1.8 + 32;
		echo "<tr align ='center'><td>$c</td><td>$f</td></tr>";
	}

echo "</table>";
?>