<?php

// Get the HTTP method
$httpMethod = $_SERVER['REQUEST_METHOD'];

// Get the API path (request URI)
$apiPath = $_SERVER['REQUEST_URI'];
if ($httpMethod === "POST") {
    $raw_post_data = file_get_contents("php://input");
    $data = json_decode($raw_post_data, true);

    if ($data !== null) {
        $servername = "localhost";
        $username = "ashe152";
        $password = "sniping45!";
        $dbname = "ashe152";

        $conn = new mysqli($servername, $username, $password, $dbname);

        // 연결 확인
        if ($conn->connect_error) {
            die("Connection failed: " . $conn->connect_error);
        }
        
        // 데이터베이스에 데이터 삽입 (예: 테이블 이름은 'sensor_data')
        $sql = "UPDATE testtable1 SET intemp = '{$data['intemp']}', outtemp = '{$data['outtemp']}', inhumi = '{$data['inhumi']}', outhumi = '{$data['outhumi']}', matter = '{$data['matter']}', camic = '{$data['camic']}' WHERE code = 1;";

        if ($conn->query($sql) === TRUE) {
            echo "Data inserted successfully";
        } else {
            echo "Error: " . $sql . "<br>" . $conn->error;
        }
    }
}

?>