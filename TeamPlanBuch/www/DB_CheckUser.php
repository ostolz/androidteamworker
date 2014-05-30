<?php
$response = array();

if (!isset($_POST['username']))
{
$username = $_POST['username'];
require_once __DIR__.'/DB_Connect.php';
$db = new DB_Connect();
        $result = mysql_query("SELECT username FROM usertable WHERE username = '$username'");
        $no_of_rows = mysql_num_rows($result);
        if ($no_of_rows > 0) 
		{
			$response["success"] = 1;
			echo json_encode($response);
        }
		else 
		{
			$response["success"] = 0;
			$response["message"] = "Benutzer existiert nicht!";
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