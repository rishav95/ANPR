<?php 
require_once "conn.php";
$user_name = $_POST["PoliceID"];
$user_pass = $_POST["password"];
$sql = "select * from policeinfo where PoliceID= '".$user_name."' and Password = '".$user_pass."'";
if($query_run = mysqli_query($conn,$sql))
{
	if($row = mysqli_fetch_array($query_run))
		echo "Login success !! Welcome user";
	else
		echo "Invalid Username or Password!!";
}
else {
echo "Error";
}
?>