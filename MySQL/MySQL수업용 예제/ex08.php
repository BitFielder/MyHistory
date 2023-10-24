<?php

// 2중 for문을 사용하여 구구단 표 만들기
echo "<h2>구구단표</h2>";
echo "<table border = 1>"; // 테두리 굵기가 1인 표를 만들기
echo "<tr>"; // 첫번째 줄 생성
for ($a=2;$a<=9;$a++){
	echo "<th width=100>{$a}단</th>";
// <th>는 제목카을 만드는 태그임
}

echo "</tr>"; //첫번째 줄 종료
	for($b = 2;$b<=9;$b++){
		echo "<tr align ='center'>";
		for($a=2;$a<=9;$a++){
			$c = $a*$b; // 두 수의 곱을 변수 c에 저장
			echo "<td>{$a}*{$b}={$c}</td>";
		}
		echo "</tr>";
	}

echo "</table>";
?>