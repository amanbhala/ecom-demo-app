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
<form method="post" action="details_supplier">
<%-- Enter Supplier Id: <input type = "number" name = "supp_id" required><br> --%>
Supplier ID : ${suppli_id} <br>
Enter Supplier Name: <input type = "text" name = "name" required><br>
Enter Supplier Email: <input type = "email" name = "email" required><br>
Enter Supplier Mobile: <input type = "tel" minlength = "10" maxlength = "10" name = "mobile" required><br>
<input type = "submit"><br>

</form>
</body>
</head>
</html>