<?php
    $con = mysqli_connect("localhost", "host", "4455", "client");
    mysqli_query($con,'SET NAMES utf8');

    $statement = mysqli_prepare($con, "SELECT * FROM board");

    mysqli_stmt_execute($statement);
    $res = mysqli_stmt_get_result($statement);

    $response = array();
    while($row = mysqli_fetch_array($res)){
        $board = array(
            'bno' => $row["bno"],
            'userID' => $row["userID"],
            'title' => $row["title"],
            'regdate' => $row["regdate"],
            'updatetime' => $row["updatetime"],
            'Cnt' => $row["Cnt"]
    );

        array_push($response, $board);
    }
    echo json_encode($response);
?>