<%--
  Created by IntelliJ IDEA.
  User: macorin
  Date: 05/08/14
  Time: 13:28
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
    <title><spring:message code="cliente.page.title"/></title>
</head>
<body>

<jump:formcrud mapping="cliente">

    <div class="tabbable">
        <ul class="nav nav-tabs" role="tablist" id="tabClienteForm">
            <li class="active"><a href="#tabPessoa" data-toggle="tab"><spring:message
                    code="pessoa.tabDadosPessoa.legend"/> </a></li>
            <li><a href="#tabEndereco" data-toggle="tab"><spring:message code="pessoa.tabEndereco.legend"/> </a></li>
        </ul>

        <div class="tab-content" style="padding-bottom: 9px; border-bottom: 1px solid #ddd;">
            <div class="tab-pane active" id="tabPessoa">

                <jump:hidden attribute="cliId" entity="cliente"/>
                <jump:hidden attribute="pessoa.pesId" entity="cliente"/>

                <jump:hidden attribute="situacao" entity="cliente"/>
                <jump:hidden attribute="dataCriacao" entity="cliente"/>
                <jump:hidden attribute="dataAlteracao" entity="cliente"/>

                <jump:hidden attribute="pessoa.situacao" entity="cliente"/>
                <jump:hidden attribute="pessoa.dataCriacao" entity="cliente"/>
                <jump:hidden attribute="pessoa.dataAlteracao" entity="cliente"/>
                <jump:hidden attribute="pessoa.grupoEmpresa.greId" entity="cliente"/>

                <jump:textfield attribute="pessoa.pesTipoPessoa" entity="cliente" bootstrapClass="input-medium"
                                disabled="true"/>
                <jump:textfield attribute="pessoa.pesIdentificacao" entity="cliente" bootstrapClass="input-large"
                                disabled="true"/>
                <jump:textfield attribute="pessoa.pesNome" entity="cliente" bootstrapClass="input-xxlarge"/>
                <jump:textfield attribute="pessoa.pesNomeReduzido" entity="cliente" bootstrapClass="input-xlarge"/>
            </div>
            <div class="tab-pane" id="tabEndereco">
                <jsp:include page="../pessoaEndereco/enderecoTable.jsp" />
            </div>

        </div>
    </div>

</jump:formcrud>
</body>
</html>
