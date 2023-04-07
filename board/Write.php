<?php
$con = mysqli_connect("localhost", "host", "4455", "client");
mysqli_query($con, 'SET NAMES utf8');

$userID = $_POST["userID"];
$title = $_POST["title"];
$content = $_POST["content"];
$date = date('Y-m-d H:i:s');

// 백틱(`)을 이용하여 "update" 컬럼명을 명시함
$statement = mysqli_prepare($con, "INSERT INTO board (userID, title, content, regdate, updatetime, Cnt) VALUES (?, ?, ?, NOW(), NOW(), 0)");
mysqli_stmt_bind_param($statement, "sss", $userID, $title, $content);
mysqli_stmt_execute($statement);

$response = array();
$response["success"] = true;

echo json_encode($response);

?>
