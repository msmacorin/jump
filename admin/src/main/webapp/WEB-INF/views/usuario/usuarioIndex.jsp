<%-- 
    Document   : index
    Created on : May 30, 2013, 10:40:12 AM
    Author     : macorin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="jump" uri="http://www.macor.in/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><spring:message code="usuario.page.title"/></title>
</head>

<body>
<jump:tablecrud entity="usuario"></jump:tablecrud>
</body>
</html>
