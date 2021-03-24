<%-- 
    Document   : generoProdutoIndex
    Created on : Aug 31, 2013, 2:58:44 PM
    Author     : macorin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="jump"     uri="http://www.macor.in/tags" %>
<%@taglib prefix="spring"   uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="generoProduto.page.title" /></title>
    </head>
    <body>
        <jump:tablecrud entity="generoProduto" />
    </body>
</html>
