<%--
  Created by IntelliJ IDEA.
  User: macorin
  Date: 06/10/14
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix='form' uri='http://www.springframework.org/tags/form' %>
<%@ taglib prefix="jump" uri="http://www.macor.in/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="widget-content">
    <table class="table table-striped table-bordered table-condensed" id="pessoaEnderecoTable">
        <thead>
        <tr>
            <th><spring:message code="pessoa.pessoaEndereco.peeLogradouro"/></th>
            <th><spring:message code="pessoa.pessoaEndereco.peeNumero"/></th>
            <th><spring:message code="pessoa.pessoaEndereco.cepLocalidade.localidade.locNome"/></th>
            <th><spring:message code="pessoa.pessoaEndereco.cepLocalidade.localidade.unidadeFederacao.unfSigla"/></th>
            <th>
                <a href="#modalPessoaEndereco" class="btn btn-primary" data-toggle="modal"><spring:message code="global.action.inserir"/></a>
            </th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <c:choose>
                <c:when test="${empty pessoa.pessoaEndereco}">
                    <td><spring:message code="global.table.empty" /></td>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${pessoa.listPessoaEndereco}" var="pessoaEndereco">
                        <td hidden>${pessoaEndereco.peeId}</td>
                        <td hidden>${pessoaEndereco.peeBairro}</td>
                        <td hidden>${pessoaEndereco.peeComplemento}</td>
                        <td hidden>${pessoaEndereco.peePrincipal}</td>
                        <td hidden>${pessoaEndereco.situacao}</td>
                        <td hidden>${pessoaEndereco.dataCriacao}</td>
                        <td hidden>${pessoaEndereco.dataAlteracao}</td>
                        <td>${pessoaEndereco.peeLogradouro}</td>
                        <td>${pessoaEndereco.peeNumero}</td>
                        <td>${pessoaEndereco.cepLocalidade.localidade.locNome}</td>
                        <td>${pessoaEndereco.cepLocalidade.localidade.unidadeFederacao.unfSigla}</td>
                        <td>
                            <button class="btn btn-mini btn-warning"><i class="icon-pencil"></i></button>
                            <button class="btn btn-mini btn-danger"><i class="icon-remove"></i></button>
                        </td>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </tr>
        </tbody>
    </table>
</div>

<jsp:include page="enderecoDialog.jsp" />