<?php
// MySQL 데이터베이스 연결 설정
$servername = "localhost";
$username = "ashe152";
$password = "sniping45!";
$dbname = "ashe152";

// 데이터베이스 연결 생성
$conn = new mysqli($servername, $username, $password, $dbname);

// 연결 확인
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// GET 방식으로 전달된 데이터 확인
if ($_SERVER["REQUEST_METHOD"] == "GET") {
    $intemp = isset($_GET['intemp']) ? $_GET['intemp'] : null;
    $outtemp = isset($_GET['outtemp']) ? $_GET['outtemp'] : null;
    $inhumi = isset($_GET['inhumi']) ? $_GET['inhumi'] : null;
    $outhumi = isset($_GET['outhumi']) ? $_GET['outhumi'] : null;
    $matter = isset($_GET['matter']) ? $_GET['matter'] : null;
    $camic = isset($_GET['camic']) ? $_GET['camic'] : null;

    // 온습도 및 가스 데이터가 유효한지 확인
    if (
        $intemp !== null && $outtemp !== null &&
        $inhumi !== null && $outhumi !== null &&
        $matter !== null && $camic !== null
    ) {
        // 데이터베이스에 데이터 업데이트
        $sql = "UPDATE testtable1 SET
                intemp = '$intemp',
                outtemp = '$outtemp',
                inhumi = '$inhumi',
                outhumi = '$outhumi',
                matter = '$matter',
                camic = '$camic'
                WHERE code = 1";

        if ($conn->query($sql) === TRUE) {
            // 데이터베이스 업데이트가 성공한 경우 JSON 파일 생성
            $data = array(
                "intemp" => $intemp,
                "outtemp" => $outtemp,
                "inhumi" => $inhumi,
                "outhumi" => $outhumi,
                "matter" => $matter,
                "camic" => $camic
            );

            $jsonFile = 'android.json';
            file_put_contents($jsonFile, json_encode($data));

            echo "Data received and logged successfully.";
        } else {
            // 데이터베이스 업데이트에 실패한 경우 에러 메시지 출력
            echo "Error: " . $sql . "<br>" . $conn->error;
        }
    } else {
        // 유효한 데이터가 전달되지 않으면 에러 메시지 출력
        echo "Invalid data received.";
    }
} else {
    // 올바르지 않은 요청 메서드일 때 에러 메시지 출력
    echo "Invalid request method.";
}

// 데이터베이스 연결 종료
$conn->close();
?>