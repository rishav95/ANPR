<?php

require_once "conn.php";

	$Number = $_POST["Number"];
	
	$sql_check = "select * from vehicleinfo where NumberPlate = '".$Number."'";
	$sql = "select Model from vehicleinfo where NumberPlate = '".$Number."'";
	$q=mysqli_query($conn, $sql);
	if($query = mysqli_query($conn, $sql_check)){
		if($row = mysqli_fetch_array($query))
		{
			$Vehicle = mysqli_fetch_array($q);
			echo $Vehicle['Model'];
		}
		else
			echo "Vehicle hasn't been registered yet!!";
	}
	else
		echo "Error"
?>