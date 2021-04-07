<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!doctype html>
<html>
<head>
    <title>Logout</title>
</head>
<body>

<div >
    <div class="container main-content">
        <%-- <ul class="list-group">
            <li class="list-group-item list-group-item-info"><h3>You have been successfully logged out.</h3></li>
        </ul> --%>
        <a href="${contextPath}/login">Return home</a>
    </div>
</div>

</body>
</html>