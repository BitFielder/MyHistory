<?php

echo "<h2>시간표</h2>";
echo "<table border = 1>"; // 테두리 굵기가 1인 표를 만들기
echo "<tr>"; // 첫번째 줄 생성
for ($a=7;$a<=13;$a++){
	echo "<th width=100>{$a}단</th>";
// <th>는 제목카을 만드는 태그임
}

echo "</tr>"; //첫번째 줄 종료
	for($b = 5;$b<=56;$b+=5){
		echo "<tr align ='center'>";
		for ($a=7;$a<=13;$a++){
			$c = $a*$b; // 두 수의 곱을 변수 c에 저장
			echo "<td>{$a}시{$b}분</td>";
		}
		echo "</tr>";
	}

echo "</table>";
?>