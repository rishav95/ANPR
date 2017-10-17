<?php
require_once "conn.php";

$NumberPlate = ["NumberPlate"];
$sql = "select * from cominfo;";

$result = mysqli_query($conn, $sql);
$response = array();

while ($row = mysqli_fetch_array($result))
{
	array_push($response,array("InspectionID"=>$row[0],"NumberPlate"=>$row[1],"DriverLicense"=>$row[2],"Location"=>$row[3],"Bluebook"=>$row[4],"Model"=>$row[5],"Comment"=>$row[6], "MaPaSe"=>$row[7], "Date"=>$row[8]));
}
echo json_encode(array("server_response"=>$response));
mysqli_close($conn);
?>