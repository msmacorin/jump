<%--
  Created by IntelliJ IDEA.
  User: macorin
  Date: 07/07/14
  Time: 21:24
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
    <title><spring:message code="pais.page.title"/></title>
</head>
<body>

<jump:formcrud mapping="pais" span="6">

    <jump:hidden attribute="paiId" entity="pais"/>

    <jump:hidden attribute="situacao" entity="pais"/>
    <jump:hidden attribute="dataCriacao" entity="pais"/>
    <jump:hidden attribute="dataAlteracao" entity="pais"/>
    <jump:hidden attribute="grupoEmpresa.greId" entity="pais"/>

    <jump:textfield attribute="paiNome" entity="pais" bootstrapClass="input-xlarge"/>
    <jump:textfield attribute="paiCodigoBancoCentral" entity="pais" bootstrapClass="input-small"/>
</jump:formcrud>
<script src="${contexto}/js/jump/pais/paisForm.js"></script>
</body>
</html>
