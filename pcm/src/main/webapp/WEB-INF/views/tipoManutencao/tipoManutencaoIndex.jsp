<%-- 
    Document   : tipoManutencaoIndex
    Created on : Jun 27, 2013, 12:08:26 PM
    Author     : macorin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix='form'    uri='http://www.springframework.org/tags/form'%>
<%@ taglib prefix="jump"    uri="http://www.macor.in/tags" %>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> <spring:message code="tipoManutencao.page.title" /></title>
    </head>
    <body>
        <jump:tablecrud entity="tipoManutencao" />
    </body>
</html>
