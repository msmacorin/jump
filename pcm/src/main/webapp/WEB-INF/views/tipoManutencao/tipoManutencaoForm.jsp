<%-- 
    Document   : tipoManutencaoForm
    Created on : Jun 27, 2013, 9:19:10 AM
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
        <title> <spring:message code="tipoManutencao.page.title" /></title>
    </head>
    <body>
        <jump:formcrud entity="tipoManutencao" >
            <jump:textfield attribute="tmId" entity="tipoManutencao" disabled="true" bootstrapClass="input-small"/>
            <jump:textfield attribute="tmDescricao" entity="tipoManutencao" bootstrapClass="input-xlarge" />
            <jump:select attribute="tmAtivo" entity="tipoManutencao" list="${listaSimNao}" object="${model.tmAtivo}" bootstrapClass="input-medium" nullValue="false"/>
        </jump:formcrud>
    </body>
</html>
