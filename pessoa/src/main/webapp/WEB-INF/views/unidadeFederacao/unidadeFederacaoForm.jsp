<%--
  Created by IntelliJ IDEA.
  User: macorin
  Date: 07/07/14
  Time: 21:33
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

<jump:formcrud mapping="unidadeFederacao" span="6">

    <jump:hidden attribute="unfId" entity="unidadeFederacao"/>

    <jump:hidden attribute="situacao" entity="unidadeFederacao"/>
    <jump:hidden attribute="dataCriacao" entity="unidadeFederacao"/>
    <jump:hidden attribute="dataAlteracao" entity="unidadeFederacao"/>
    <jump:hidden attribute="grupoEmpresa.greId" entity="unidadeFederacao"/>

    <jump:textfield attribute="unfNome" entity="unidadeFederacao" bootstrapClass="input-xxlarge" />
    <jump:textfield attribute="unfCodigoIbge" entity="unidadeFederacao" bootstrapClass="input-small" />
    <jump:textfield attribute="unfSigla" entity="unidadeFederacao" bootstrapClass="input-small" />

    <jump:search searchId="searchPais"
                 entity="unidadeFederacao" entityRel="pais"
                 bootstrapClass="input-xxlarge"
                 attributeText="pais.paiNome" attributeValue="pais.paiId"
                 fieldColumns="${columnsPais}"
                 loadMethod="loadPaisAjax"
                 positionText="1" positionValue="0"/>
</jump:formcrud>
<script src="${contexto}/js/jump/unidadeFederacao/unidadeFederacaoForm.js"></script>
</body>
</html>
