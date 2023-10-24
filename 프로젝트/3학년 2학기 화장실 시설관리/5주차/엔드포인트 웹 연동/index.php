<?php


$servername = "localhost";
$username = "ashe152";
$password = "sniping45!";
$dbname = "ashe152";

$conn = new mysqli($servername, $username, $password, $dbname);

// 연결 확인
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$query = "SELECT * FROM testtable1";
$result = mysqli_query($conn, $query);

if (!$result) {
    die("쿼리 실행 실패: " . mysqli_error($conn));
}

$row = mysqli_fetch_assoc($result);


echo
'
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>모니터</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>
    <header>
        <div id="contTitle">
            <p>환경 실시간 DATA</p>
        </div>
    </header>

    <section>
        <div id="contMonitor">
            <div class="row">
                <div class="cell">-</div>
                <div id="selects" class="cell">온도</div>
                <div id="selects" class="cell">습도</div>
                <div id="selects" class="cell">미세먼지</div>
                <div id="selects" class="cell">냄새</div>
              </div>
              <div class="row">
                  <div id="selects" class="cell">실내</div>
                  <div class="cell"><span id="intemp">'. $row['intemp'] .'</span>℃</div>
                  <div class="cell"><span id="inhumi"></span>%</div>
                  <div class="cell"><span id="matter"></span>%</div>
                  <div class="cell"><span id="camic"></span>%</div>
                </div>
                <div class="row">
                    <div id="selects" class="cell">실외</div>
                    <div class="cell"><span id="outtemp"></span>℃</div>
                    <div class="cell"><span id="outhumi"></span>%</div>
                    <div class="cell">-</div>
                    <div class="cell">-</div>
                  </div>
                  <div class="row">
                      <div id="selects" class="cell">온도차</div>
                      <div class="cell"><span id="subtemp"></span>℃</div>
                      <div class="cell"><span id="subhumi"></span>%</div>
                      <div class="cell">-</div>
                      <div class="cell">-</div>
                    </div>
        </div>

        <div id="contInfo">
            <p>세부사항</p>
            <p>온도 :</p>
            <p>습도 :</p>
        </div>

    </section>

    <footer>
        <div id="contMemo">
            <p>메모</p>
            <div class="memo-form">
                <input type="text" id="memo-input" placeholder="메모를 입력하세요">
                <button id="add-button">추가</button>
            </div>
            <ul id="memo-list"></ul>
        </div>
    </footer>

    <script src="script.js"></script>
</body>

</html>
';

/*

                <h3>'. $row['nick'] .'</h3>
                <p>온도' . $row['temp'] . '</p>
                <p>습도' . $row['humi'] . '</p>
*/

//mysqli_close($conn);

?>
