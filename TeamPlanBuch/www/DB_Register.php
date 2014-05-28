<?php
$response = array();

if (isset($_POST['username']) && isset($_POST['password']) && isset($_POST['email']))
{
//mandatory
$username = $_POST['username'];
$password = $_POST['password'];
$email = $_POST['email'];

//not mandatory
if($_POST['surname'] != null)
{$surname = $_POST['surname'];}else{$surname = "";}
if($_POST['lastname'] != null)
{$lastname = $_POST['lastname'];}else{$lastname = "";}
if($_POST['teampreferred'] != null)
{$teampreferred = $_POST['teampreferred'];}else{$teampreferred = "";}
if($_POST['address'] != null)
{$address = $_POST['address'];}else{$address = "";}
if($_POST['plz'] != null)
{$plz = $_POST['plz'];}else{$plz = "";}
if($_POST['wohnort'] != null)
{$wohnort = $_POST['wohnort'];}else{$wohnort = "";}

require_once __DIR__.'/DB_Connect.php';

$db = new DB_Connect();

$result = mysql_query("
INSERT INTO usertable(username, password, surname, lastname, dateregistered, teampreferred, teamid, roleid, email, address, plz, wohnort)
VALUES ('$username', '$password', '$surname', '$lastname', now(), '$teampreferred, '$teamid', '$roleid', '$email', '$address', '$plz', '$wohnort')");

if ($result) {
	$response["success"] = 1;
	$response["message"] = "Product successfully created.";
	echo json_encode($response);
} else {
	$response["success"] = 0;
	$response["message"] = "Oops! An error occurred.";
	echo json_encode($response);
}
} else {
    $response["success"] = 0;
    $response["message"] = "On or more required field is missing";
    echo json_encode($response);
}
?>