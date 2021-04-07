<%@ page language="java" contentType = "text/html; charset= ISO-8859-1"
pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> 
Submission Form
</title>
<body>
<form method="post" action="details_material">
Enter Material Id: <input type = "number" name = "mat_id" ><br>
Enter Material Name: <input type = "text" name = "name" required><br>
Enter Details: <input type = "text" name = "details" required><br>

<input type = "submit"><br>

</form>
</body>
</head>
</html>