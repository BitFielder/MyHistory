<?php
$gb = 3;
echo "<table border = 1>"; // 테두리 굵기가 1인 표를 만들기
echo "<tr>"; // 첫번째 줄 생성
echo "<th width=130>GB</th>
	<th width=130>MB</th>
	<th width=130>KB</th>
	<th width=130>B</th>";
echo "</tr>"; //첫번째 줄 종료
	while($gb<=22){
		$mb = $gb * 1024;
		$kb = $mb * 1024;
		$b = $kb * 1024;
		echo "<tr align ='center'><td>$gb</td>
		<td>$mb</td><td>$kb</td><td>$b</td></tr>";
		$gb += 3;
	}

echo "</table>";
?>