<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> 
Submission Form
</title>
<body>
<form method="post" action="details_invoice">
Enter Customer Id: < input type = "text" name = "cust_id" path="cust_id"><br>
Enter Invoice Id: < input type = "text" name = "invoice_id" path="invoice_id"><br>
<label >Choose mat_id from the drop down list:</label>
<select id="mat_id" name="mat_id" path = "mat_id">
    <option value="${materi}"></option>
</select>
<br>  
<label >Choose supp_id from the drop down list:</label>
<form: select id="supp_id" name="supp_id" path="supp_id">
    <form: option value="${suppli}"></option>
</form: select> 
<br>
Enter Units Purchased: <input type = "text" name = "unit_purchased" path="unit_purchased"><br>
<input type = "submit">
</form>
</body>
</head>
</html> --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> 
Invoice Form
</title>
<body>
<form:form method="post" action="details_invoice" >
<%-- Enter Customer Id:<input type = "number" name = "cust_id" path = "cust_id" required><br> --%>
Customer ID : ${invoi_id} <br>
<%-- Enter Invoice Id:<input type = "number" name = "invoice_id" path = "invoice_id" required><br> --%>
Enter Units to purchase:<input type = "number" name="unit_purchased" path="unit_purchased" name = "unit_purchased" required><br>
<form:label path="supp_id">Supplier Id</form:label>
<form:select name = "supp_id" path="supp_id" >
   <form:option  value = "${suppli}" label = "Select"/>
   <form:options items = "${suppli}" />
</form:select> 
<form:label path="mat_id">Material Id</form:label>
<form:select name = "mat_id" path="mat_id">
   <form:option  value = "${materi}" label = "Select"/>
   <form:options items = "${materi}" />
</form:select> 
<input type = "submit">
 </form:form>
</body>
</head>
</html>