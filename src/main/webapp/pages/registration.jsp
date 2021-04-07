<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Create an account</title>

      <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
  </head>

  <body>

    <div class="container">

        <form:form method="POST" modelAttribute="userForm" class="form-signin">
            <h2 class="form-signin-heading">Create your account</h2>
            <spring:bind path="username">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="username" class="form-control" placeholder="Username"
                                autofocus="true"></form:input>
                    <form:errors path="username"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="password">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
                    <form:errors path="password"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="passwordConfirm">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="password" path="passwordConfirm" class="form-control"
                                placeholder="Confirm your password"></form:input>
                    <form:errors path="passwordConfirm"></form:errors>
                </div>
            </spring:bind>

            <%-- <spring:bind path="customer">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="radio" name="register" placeholder = "I am a customer" path="customer"></form:input>
                    
                </div>
            </spring:bind> --%>

            <spring:bind path="user_type">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <%-- <form path="user_type"> --%>
                                <select path="user_type" id="user_type" name="user_type">
                                 <option value="customer">CUSTOMER</option>
                                 <option value="supplier">SUPPLIER</option>
                                </select>
                    <%-- </form>       --%>
                </div>
            </spring:bind>  
        
            <%-- <spring:bind path="supplier">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="radio" path="I am a supplier"
                                placeholder="I am a supplier"></form:input>
                    <form:errors path="supplier"></form:errors> 
                </div>
            </spring:bind> --%>
            <%-- <input id = "customer" name = "register" type = "radio" value = "customer" checked = "checked"/><label for = "cusomer">I am a Customer</label>
            <input id = "supplier" name = "register" type = "radio" value = "supplier"/><label for = "supplier">I am a supplier</label> --%>

            
            <%-- <label class="container">I am a customer
                <input type="radio" checked="checked" name="radio" id="customer">
                <span class="checkmark"></span>
            </label>

            <label class="container">I am a supplier
                <input type="radio" checked="checked" name="radio" id="supplier">
                <span class="checkmark"></span>
            </label> --%>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        </form:form>

    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  </body>
</html>
