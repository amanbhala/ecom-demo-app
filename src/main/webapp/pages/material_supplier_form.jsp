<%@ page language="java" contentType = "text/html; charset= ISO-8859-1"
pageEncoding="ISO-8859-1" %>
<%@ page import="com.demoapplication.demoapplication.supplier" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> 
Submission Form
</title>
<body>
<form method="post" action="details_material_supplier">
Enter Material Id: <input type = "number" name = "mat_id" required><br>
Supplier ID : ${suppl_id} <br>
<%-- Enter Supplier Id: <input type = "number" name = "supp_id" required><br> --%>
Enter Units: <input type = "number" name = "units" required><br>

<input type = "submit"><br>

</form>
</body>
</head>
</html>
