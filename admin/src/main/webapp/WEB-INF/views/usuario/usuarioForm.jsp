<%-- 
    Document   : form
    Created on : May 27, 2013, 10:01:00 PM
    Author     : macorin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix='form' uri='http://www.springframework.org/tags/form' %>
<%@ taglib prefix="jump" uri="http://www.macor.in/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><spring:message code="usuario.page.title"/></title>
</head>
<body>
<jump:formcrud mapping="usuario" span="6">

    <jump:hidden attribute="usuId" entity="usuario"/>

    <jump:hidden attribute="situacao" entity="usuario"/>
    <jump:hidden attribute="dataCriacao" entity="usuario"/>
    <jump:hidden attribute="dataAlteracao" entity="usuario"/>

    <jump:textfield attribute="usuNome" entity="usuario" bootstrapClass="input-xlarge"/>
    <jump:textfield attribute="usuEmail" entity="usuario" bootstrapClass="input-xlarge"/>
    <jump:textfield attribute="usuUsuario" entity="usuario" bootstrapClass="input-xlarge"/>
    <div class="control-group">
        <label class="control-label"><spring:message code="usuario.usuSenha.label"/></label>

        <div class="controls">
            <form:input type="password"
                        class="input-large"
                        id="usuSenha"
                        name="usuSenha"
                        path="usuSenha"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label"><spring:message code="usuario.confirmaSenha.label"/></label>

        <div class="controls">
            <input type="password"
                   class="input-large"
                   id="confirmaSenha"
                   name="confirmaSenha"/>
        </div>
    </div>

    <jump:select attribute="usuAlterarSenha" entity="usuario" list="${listaSimNao}" object="${model.usuAlterarSenha}"
                 bootstrapClass="input-medium" nullValue="false"/>

    <jump:search searchId="searchGrupoEmpresa"
                 entity="usuario" entityRel="grupoEmpresa"
                 bootstrapClass="input-xlarge"
                 attributeText="grupoEmpresa.greNome" attributeValue="grupoEmpresa.greId"
                 fieldColumns="${columnsGrupoEmpresa}"
                 loadMethod="loadGrupoEmpresaAjax"
                 positionText="1" positionValue="0"/>

</jump:formcrud>
<script src="${contexto}/js/jump/usuario/usuarioForm.js"></script>
</body>
</html>
