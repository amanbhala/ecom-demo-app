<%@ page language="java" contentType = "text/html; charset= ISO-8859-1"
pageEncoding="ISO-8859-1" %>
<%-- <%@ page import="com.demoapplication.demoapplication.customers" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> 
Submission Form
</title>
<body>
<form method="post" action="details_customer">
<%-- Enter Customer Id: <input type = "number" name = "cust_id" required><br> --%>
Customer ID : ${id} <br>
Enter Customer Name: <input type = "text" name = "name" required><br>
Enter Customer Email: <input type = "email" name = "email" required><br>
Enter Customer Mobile: <input type = "tel" minlength = "10" maxlength = "10" name = "mobile" required><br>

<input type = "submit"><br>
</form>
</body>
</head>
</html>