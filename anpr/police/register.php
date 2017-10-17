<?php

require_once "conn.php";

	$PoliceID = $_POST["PoliceID"];
	$email = $_POST["email"];
	$password = $_POST["password"];
	$phone = $_POST["phone"];
	$age = $_POST["age"];
	$name = $_POST["name"];
	
	$sql_check = "select * from policeinfo where PoliceID = $PoliceID";
	$sql_register = "insert into policeinfo values ('$PoliceID' , '$name' , '$phone' , '$age' , '$email' , '$password');";
	
	if(mysqli_num_rows(mysqli_query($conn,$sql_check)))
		echo "PoliceID already exists.";
	else
	{
		if($query_register = mysqli_query($conn,$sql_register))
			echo "Registration Successful!!";
		else
			echo "Error";
	}
?>