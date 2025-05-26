<?php
include 'db.php';
$name = $_POST['name'];
$email = $_POST['email'];
$phone = $_POST['phone'];
$event_type = $_POST['event_type'];
$stmt = $conn->prepare("INSERT INTO Users (full_name, email, city, registration_date) VALUES (?, ?, ?, CURDATE())");
$stmt->bind_param("sss", $name, $email, $city);
$city = "Unknown"; // or collect from form
$stmt->execute();
$user_id = $conn->insert_id;
$stmt2 = $conn->prepare("INSERT INTO Registrations (user_id, event_id, registration_date) VALUES (?, ?, CURDATE())");
$event_id = ($event_type == "festival") ? 1 : (($event_type == "cleanup") ? 2 : 3);
$stmt2->bind_param("ii", $user_id, $event_id);
$stmt2->execute();
echo "Registered successfully!";
?>
