<?php
    $con = mysqli_connect("localhost", "host", "4455", "client");

    $userID = $_POST["userID"] ? $_POST["userID"] : "";

    $statement = mysqli_prepare($con, "DELETE FROM user WHERE userID = ?");
    mysqli_stmt_bind_param($statement, "s", $userID);
    mysqli_stmt_execute($statement);

    $response = array();
    $response["success"] = true;

    echo json_encode($response);

?>