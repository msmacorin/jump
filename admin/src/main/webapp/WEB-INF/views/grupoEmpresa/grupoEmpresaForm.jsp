<%-- 
    Document   : form
    Created on : May 31, 2013, 6:35:53 PM
    Author     : macorin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="jump"    uri="http://www.macor.in/tags" %>
<%@ taglib prefix='form'    uri='http://www.springframework.org/tags/form'%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="grupoEmpresa.page.title" /></title>
    </head>
    <body>
        <jump:formcrud mapping="grupoEmpresa" span="6">
            <jump:hidden attribute="greId" entity="grupoEmpresa"/>
            <jump:textfield attribute="greNome" entity="grupoEmpresa" bootstrapClass="input-xlarge" />
            <jump:hidden attribute="situacao" entity="grupoEmpresa" />
            <jump:hidden attribute="dataCriacao" entity="grupoEmpresa" />
            <jump:hidden attribute="dataAlteracao" entity="grupoEmpresa" />
        </jump:formcrud>
    </body>
</html>
