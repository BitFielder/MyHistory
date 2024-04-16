<?php

// while문을 사용하여 인치를 센티미터로 변환하는 표 만들기
// 10인치에서 100인치까지 10증가
// 센티미터 = 인치 * 2.54
$inch = 10; // 초기값 저장
echo "<table border = 1>"; // 테두리 굵기가 1인 표를 만들기
echo "<tr>"; // 첫번째 줄 생성
echo "<th width = 100>인치</th><th width=100>센티미터</th>";

//<th>는 제목칸을 만드는 태그임
echo "</tr>"; //첫번째 줄 종료
	while($inch<=100){
		$cm = $inch * 2.54;
		echo "<tr align ='center'><td>$inch</td><td>$cm</td></tr>";
		$inch += 10;
	}

echo "</table>";
?>