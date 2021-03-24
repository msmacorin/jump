<%-- 
    Document   : profile
    Created on : Jun 26, 2013, 8:18:52 PM
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
        <title> <spring:message code="usuario.page.title" /></title>
    </head>
    <body>
        <jump:formcrud mapping="usuario" icon="icon-user" span="6">
            <jump:hidden attribute="usuId" entity="usuario" />
            <jump:hidden attribute="situacao" entity="usuario" />
            <jump:hidden attribute="dataCriacao" entity="usuario" />
            <jump:hidden attribute="dataAlteracao" entity="usuario" />
            <jump:hidden attribute="grupoEmpresa.greId" entity="usuario" />
            <jump:hidden attribute="usuSenha" entity="usuario" />

            <jump:textfield attribute="usuNome" entity="usuario" bootstrapClass="input-xlarge" />
            <jump:textfield attribute="usuEmail" entity="usuario" bootstrapClass="input-xlarge" />
            <jump:textfield attribute="usuUsuario" entity="usuario" bootstrapClass="input-xlarge" />
        </jump:formcrud>
        <script src="${contexto}/js/jump/usuario/profile.js"></script>
    </body>
</html>
