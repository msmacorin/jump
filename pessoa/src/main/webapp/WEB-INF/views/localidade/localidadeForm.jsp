<%--
  Created by IntelliJ IDEA.
  User: macorin
  Date: 07/07/14
  Time: 21:30
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
    <title><spring:message code="localidade.page.title"/></title>
</head>
<body>

<jump:formcrud mapping="localidade" span="6">

    <jump:hidden attribute="locId" entity="localidade"/>

    <jump:hidden attribute="situacao" entity="localidade"/>
    <jump:hidden attribute="dataCriacao" entity="localidade"/>
    <jump:hidden attribute="dataAlteracao" entity="localidade"/>
    <jump:hidden attribute="grupoEmpresa.greId" entity="localidade"/>

    <jump:textfield attribute="locNome" entity="localidade" bootstrapClass="input-xxlarge"/>
    <jump:textfield attribute="locCodigoIbge" entity="localidade" bootstrapClass="input-small"/>

    <jump:search searchId="searchUnidadeFederacao"
                 entity="localidade" entityRel="unidadeFederacao"
                 bootstrapClass="input-xxlarge"
                 attributeText="unidadeFederacao.unfNome" attributeValue="unidadeFederacao.unfId"
                 fieldColumns="${columnsUnidadeFederacao}"
                 loadMethod="loadUnidadeFederacaoAjax"
                 positionText="1" positionValue="0"/>
</jump:formcrud>
<script src="${contexto}/js/jump/localidade/localidadeForm.js"></script>
</body>
</html>
