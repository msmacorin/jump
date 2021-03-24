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


<div id="modalPessoaEndereco" class="modal hide fade" tabindex="-1" aria-hidden="true" role="dialog"
     style="width: 90%; left: 5%; margin-left: auto; margin-right: auto">
    <div class="modal-header">
        <h3><spring:message code="pessoaEndereco.modal.legend"/></h3>
    </div>
    <div class="modal-body">
    </div>
    <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true"
                onclick="$('#modalPessoaEndereco').modal('hide');">
            <spring:message code="global.action.cancelar"/>
        </button>
        <button class="btn btn-primary" id="gravarPessoaEndereco" data-dismiss="modal"
                onclick="javascript:selectedDataTableItem();">
            <spring:message code="global.action.selecionar"/>
        </button>
    </div>
</div>