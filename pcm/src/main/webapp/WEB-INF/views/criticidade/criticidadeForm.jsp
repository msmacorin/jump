<%-- 
    Document   : criticidadeForm
    Created on : Jun 27, 2013, 2:21:05 PM
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
        <title> <spring:message code="criticidade.crud.page.title" /></title>
    </head>
    <body>
        <jump:formcrud entity="criticidade" >
            <jump:textfield entity="criticidade" attribute="crId" bootstrapClass="input-small" disabled="true" />
            <jump:textfield entity="criticidade" attribute="crDescricao" bootstrapClass="input-xlarge" />
            <jump:textfield entity="criticidade" attribute="crFaixaInicio" bootstrapClass="input-small" />
            <jump:textfield entity="criticidade" attribute="crFaixaFim" bootstrapClass="input-small" />
            <jump:select entity="criticidade" attribute="crAtivo" list="${listaSimNao}" 
                         object="${model.crAtivo}" bootstrapClass="input-medium" nullValue="false" />
        </jump:formcrud>
    </body>
</html>
