<?php 
    $con = mysqli_connect("localhost", "host", "4455", "client");
    mysqli_query($con,'SET NAMES utf8');

    $userID = $_POST["userID"];
    $userPassword = $_POST["userPassword"];
    $userName = $_POST["userName"];
    $userAge = $_POST["userAge"];
    

    $statement = mysqli_prepare($con, "UPDATE USER SET userPassword = ?, userName = ?, userAge = ? WHERE userID = ?" );

    mysqli_stmt_bind_param($statement, "ssis", $userPassword, $userName, $userAge, $userID);
    mysqli_stmt_execute($statement);
    
    $affected_rows = mysqli_affected_rows($con);

    $response = array();
    if ($affected_rows > 0) {
        $response["success"] = true;
    } else {
        $response["success"] = false;
    }
   
    echo json_encode($response);
    $con->close();
?>