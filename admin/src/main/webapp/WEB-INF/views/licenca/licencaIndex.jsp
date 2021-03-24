<%--
  Created by IntelliJ IDEA.
  User: macorin
  Date: 22/06/14
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="jump" uri="http://www.macor.in/tags" %>

<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="licenca.page.title"/></title>
</head>
<body>
    <jump:tablecrud entity="licenca"/>
</body>
</html>
