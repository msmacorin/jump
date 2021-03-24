<%-- 
    Document   : alterarSenhaForm
    Created on : Oct 23, 2013, 7:51:56 PM
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
        <jump:hidden attribute="usuNome" entity="usuario" />
        <jump:hidden attribute="usuEmail" entity="usuario" />
        <jump:hidden attribute="usuUsuario" entity="usuario" />

        <div class="control-group">
            <label class="control-label"><spring:message code="usuario.usuSenha.label" /></label>
            <div class="controls">
                <form:input type="password"
                            class="input-large"
                            id="usuSenha"
                            name="usuSenha"
                            path="usuSenha" />
            </div>
        </div>
        <div class="control-group">
            <label class="control-label"><spring:message code="usuario.confirmaSenha.label" /></label>
            <div class="controls">
                <input type="password"
                       class="input-large"
                       id="confirmaSenha"
                       name="confirmaSenha" />
            </div>
        </div>
    </jump:formcrud>
    <script src="${contexto}/js/jump/usuario/alterarSenha.js"></script>
</body>
</html>
