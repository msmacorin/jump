<%--
  Created by IntelliJ IDEA.
  User: macorin
  Date: 05/07/14
  Time: 15:15
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
    <title> <spring:message code="tipoEndereco.page.title"/> </title>
</head>
<body>
<jump:formcrud mapping="tipoEndereco" span="6">

    <jump:hidden attribute="tieId" entity="tipoEndereco"/>

    <jump:hidden attribute="situacao" entity="tipoEndereco"/>
    <jump:hidden attribute="dataCriacao" entity="tipoEndereco"/>
    <jump:hidden attribute="dataAlteracao" entity="tipoEndereco"/>
    <jump:hidden attribute="grupoEmpresa.greId" entity="tipoEndereco" />

    <jump:textfield attribute="tieNome" entity="tipoEndereco" bootstrapClass="input-xxlarge" />
</jump:formcrud>
<script src="${contexto}/js/jump/tipoEndereco/tipoEnderecoForm.js"></script>
</body>
</html>
