<?php
    $con = mysqli_connect("localhost", "ashe152", "sniping45!", "ashe152");
    mysqli_query($con, 'SET NAMES utf8'); 
    
    $userName = $_POST["userName"]; //입력받음
    $userID = $_POST["userID"]; //입력받음

    $statement = mysqli_prepare($con, "INSERT INTO USER VALUES (?, ?)"); //DB에 값 저장
    mysqli_stmt_bind_param($statement, "ss", $userName, $userID); 
    mysqli_stmt_execute($statement);

    $response = array();
    $response["success"] = true;

    echo json_encode($response);
?>