<?php

require_once "conn.php";

	$NumberPlate = $_POST["NumberPlate"];
	$DriverLicense = $_POST["DriverLicense"];
	$Location = $_POST["Location"];
	$Bluebook = $_POST["Bluebook"];
	$Comm = $_POST["Comm"];
	$Model = $_POST["Model"];
	$MaPaSe = $_POST["MaPaSe"];
	
	$sql_register = "insert into cominfo (NumberPlate,  DriverLicense, Location, BluebookConcordance, Model, Comment, MaPaSe) values ( '$NumberPlate' , '$DriverLicense' , '$Location' , '$Bluebook' , '$Model', '$Comm', '$MaPaSe');";
	$q="SELECT LAST_INSERT_ID();";
	if($query_register = mysqli_query($conn,$sql_register))
		echo "Registration Success!!";
	else
		echo "Error";
?>



																				