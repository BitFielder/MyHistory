<?php

$servername = "localhost";
$username = "ashe152";
$password = "sniping45!";
$dbname = "ashe152";

/*
DB 연결 확인
if ($conn) {
    echo "Connection established" . "<br>";
} else {
    die('Could not connect: ' . mysqli_error($conn));
}
*/

$conn = new mysqli($servername, $username, $password, $dbname);

// 연결 확인
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// JSON 데이터에서 온습도 값 추출
$humidity = $data['humi'];
$temperature = $data['temp'];

// 데이터베이스에 데이터 삽입 (예: 테이블 이름은 'sensor_data')
$sql = "UPDATE testtable1 SET humi = '12', temp = '34' WHERE code = 1;";

if ($conn->query($sql) === TRUE) {
    echo "Data inserted successfully";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}


/*
// 결과 출력
echo "<table>";
echo "<tr><th>Code</th><th>Nick</th><th>Temp</th></tr>";
while ($row = mysqli_fetch_assoc($result)) {
    echo "<tr>";
    echo "<td>" . $row['code'] . "</td>";
    echo "<td>" . $row['nick'] . "</td>";
    echo "<td>" . $row['temp'] . "</td>";
    echo "</tr>";
}
echo "</table>";
*/


echo
'
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>시설 관리 페이지</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <header>
        <h1>시설 관리 페이지</h1>
        <div class="category">카테고리: 시설 관리</div>
    </header>

    <div class="container">
        <div class="monitor">
            <!-- 모니터 내용을 여기에 추가하세요 -->
            <div class="objects">
                <h3>'. $row['nick'] .'</h3>
                <p>온도' . $row['temp'] . '</p>
                <p>습도' . $row['humi'] . '</p>
                <p>이외 옵션</p>
            </div>
        </div>

        <div class="menu">
            <p>이쪽은 화면 레이아웃</p>
            <div class="controls">
                <button id="addObject">객체 추가</button>
                <button id="editObject">객체 수정</button>
                <button id="deleteObject">객체 삭제</button>
                <button id="resizeMonitor">모니터 크기 조정</button>
                <button id="changeLayout">레이아웃 변경</button>
            </div>
        </div>
    </div>

    <script src="script.js"></script>
</body>
</html>
';



mysqli_close($conn);

?>
