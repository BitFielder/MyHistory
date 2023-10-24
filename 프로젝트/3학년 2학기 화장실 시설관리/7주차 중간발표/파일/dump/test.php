<?php
// 데이터베이스 접속 문자열. (db위치, 유저 이름, 비밀번호)
$connect = mysql_connect("ashe152.dothome.co.kr", "ashe152", "sniping45!") or  
    die("SQL server에 연결할 수 없습니다.");

mysql_query("SET NAMES UTF8");
// 데이터베이스 선택
mysql_select_db("ashe152", $connect);

// 세션 시작
session_start();

// 쿼리문 생성
$sql = "select * from testtable1"; // 여기에 테이블 이름을 넣어주세요.

// 쿼리 실행 결과를 $result에 저장
$result = mysql_query($sql, $connect);
// 반환된 전체 레코드 수 저장.
$total_record = mysql_num_rows($result);

// JSON 배열 초기화
$data = array();
while ($row = mysql_fetch_assoc($result)) {
    // 각 레코드에서 필요한 필드 추출
    $code = $row['code'];
    $nick = $row['nick'];
    $intemp = $row['intemp'];
    $outtemp = $row['outtemp'];
    $inhumi = $row['inhumi'];
    $outhumi = $row['outhumi'];
    $matter = $row['matter'];
    $camic = $row['camic'];

    // 추출한 필드를 연관 배열로 저장
    $entry = array(
        'code' => $code,
        'nick' => $nick,
        'intemp' => $intemp,
        'outtemp' => $outtemp,
        'inhumi' => $inhumi,
        'outhumi' => $outhumi,
        'matter' => $matter,
        'camic' => $camic
    );

    // 데이터 배열에 추가
    $data[] = $entry;
}

// JSON 형식으로 출력
$response = array(
    'status' => 'OK',
    'num_results' => $total_record,
    'results' => $data
);

// JSON으로 출력
header('Content-Type: application/json');
echo json_encode($response);

// MySQL 연결 종료
mysql_close($connect);
?>
