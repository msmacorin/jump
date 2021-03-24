<%--
  Created by IntelliJ IDEA.
  User: macorin
  Date: 22/06/14
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="jump"    uri="http://www.macor.in/tags" %>
<%@ taglib prefix='form'    uri='http://www.springframework.org/tags/form'%>

<html>
<head>
    <title><spring:message code="licenca.page.title" /> </title>
</head>
<body>
    <jump:formcrud mapping="licenca" span="6">
        <jump:hidden attribute="licId" entity="licenca" />

        <jump:hidden attribute="situacao" entity="licenca" />
        <jump:hidden attribute="dataCriacao" entity="licenca" />
        <jump:hidden attribute="dataAlteracao" entity="licenca" />

        <jump:search searchId="searchGrupoEmpresa"
                     entity="licenca" entityRel="grupoEmpresa"
                     bootstrapClass="input-xlarge"
                     attributeText="grupoEmpresa.greNome" attributeValue="grupoEmpresa.greId"
                     fieldColumns="${columnsGrupoEmpresa}"
                     loadMethod="loadGrupoEmpresaAjax"
                     positionText="1" positionValue="0" />

        <jump:datefield attribute="licInicio" entity="licenca" />
        <jump:textfield attribute="licPrazo" entity="licenca" bootstrapClass="input-large" />
    </jump:formcrud>
</body>
</html>
