<?php
$db_name="anpr";
$mysql_username="root";
$mysql_password="";
$server_name="localhost";
$conn=mysqli_connect($server_name, $mysql_username, $mysql_password, $db_name);
if($conn)
	echo "Connected. ";
else
	echo"Not Connected. ";
?>