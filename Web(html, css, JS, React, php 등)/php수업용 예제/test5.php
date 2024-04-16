<?php

echo "<h2>제곱미터 평수 변환</h2>";
echo "<table border = 1>"; // 테두리 굵기가 1인 표를 만들기
echo "<tr>"; // 첫번째 줄 생성
echo "<th width = 250>제곱미터</th><th width=250>평</th>";

//<tr>는 제목칸을 만드는 태그임
echo "</tr>"; //첫번째 줄 종료

	for($m2 = 5;$m2<=101;$m2+=5){
		$p = $m2 * 0.3025;
		echo "<tr align ='center'><td>$m2</td><td>$p</td></tr>";
	}

echo "</table>";
?>