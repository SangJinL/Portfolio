<?php
    $con = mysqli_connect("localhost", "host", "4455", "client");
    mysqli_query($con,'SET NAMES utf8');

    $bno = $_POST["bno"];

    $statement = mysqli_prepare($con, "SELECT * FROM board where bno=?");
    mysqli_stmt_bind_param($statement, 's', $bno);
    mysqli_stmt_execute($statement);
    $res = mysqli_stmt_get_result($statement);

    $response = array();
    while($row = mysqli_fetch_array($res)){
        $board = array(
        'bno' => $row["bno"],
        'userID' => $row["userID"],
        'title' => $row["title"],
        'content' => $row["content"],
        'date' => $row["date"],
        'update' => $row["update"],
        'Cnt' => $row["Cnt"]
    );

        array_push($response, $board);
    }
    echo json_encode($response);
?>