<?php>
require_once "conn.php";
$sql = "select * from com_info;";

$result = mysqli_query($conn, $sql);
$response = array();

while ($row = mysqli_fetch_array($result);
{
	array_push($response,array("InspectionID"=>row[0],"NumberPlate"=>row[1],"DriverLicense"=>row[2],"Location"=>row[3],"Bluebook"=>row[4],"Model"=>row[5],"Comment"=>row[6]));
	
}
echo json_encode{array("Server Response"=>$response)));
mysqli_close($conn);
?>