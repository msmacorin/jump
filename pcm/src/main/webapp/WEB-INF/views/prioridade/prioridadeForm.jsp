<%-- 
    Document   : prioridadeForm
    Created on : Jun 27, 2013, 2:07:05 PM
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
        <title> <spring:message code="prioridade.page.title" /></title>
    </head>
    <body>
        <jump:formcrud entity="prioridade">
            <jump:textfield entity="prioridade" attribute="prId" bootstrapClass="input-small" disabled="true" />
            <jump:textfield entity="prioridade" attribute="prDescricao" bootstrapClass="input-xlarge" />
            <jump:textfield entity="prioridade" attribute="prTempoResolucao" bootstrapClass="input-small" />
            <jump:select entity="prioridade" attribute="prAtivo" list="${listaSimNao}" 
                         object="${model.prAtivo}" bootstrapClass="input-medium" nullValue="false" />
        </jump:formcrud>
    </body>
</html>
