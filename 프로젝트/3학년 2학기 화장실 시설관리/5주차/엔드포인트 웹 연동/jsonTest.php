<?php

$testObj = new stdClass();
$testObj->inhumi = 12;
$testObj->outhumi = 12;
$testObj->intemp = 12;
$testObj->outtemp = 12;
$testObj->matter = 12;
$testObj->camic = 12;

$testJSON = json_encode($testObj);

$url = "http://ashe152.dothome.co.kr/api/users.php"; // Added semicolon at the end of this line

$ch = curl_init($url);

curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "POST");
curl_setopt($ch, CURLOPT_POSTFIELDS, $testJSON);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_HTTPHEADER, array(
    "Content-Type: application/json",
    "Content-Length: " . strlen($testJSON)
));

$response = curl_exec($ch);

if ($response === false) {
    echo "cURL Error: " . curl_error($ch);
} else {
    echo "cURL Successed <br>";
    echo $response;
}

curl_close($ch);

?>