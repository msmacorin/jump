<%--
  Created by IntelliJ IDEA.
  User: macorin
  Date: 07/07/14
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix='form' uri='http://www.springframework.org/tags/form' %>
<%@ taglib prefix="jump" uri="http://www.macor.in/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title> <spring:message code="unidadeFederacao.page.title" /> </title>
</head>
<body>

<jump:tablecrud entity="unidadeFederacao" />

</body>
</html>
