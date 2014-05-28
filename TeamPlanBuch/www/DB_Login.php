<?php
$response = array();

if (isset($_POST['username']) && $_POST['password'])
{
$username = $_POST['username'];
$password = $_POST['password'];
require_once __DIR__.'/DB_Connect.php';
$db = new DB_Connect();
        $result = mysql_query("SELECT password FROM usertable WHERE username = '$username'");
        if($result == $password)
        {
			$response["success"] = 1;
			echo json_encode($response);
        }
		else 
		{
			$response["success"] = 0;
			$response["message"] = "Falsches Passwort!";
			echo json_encode($response);
		}
}
else
{
    $response["success"] = 0;
    $response["message"] = "On or more required field is missing";
    echo json_encode($response);
}
?>