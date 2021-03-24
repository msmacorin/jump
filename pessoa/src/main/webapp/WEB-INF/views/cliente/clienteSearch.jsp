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

<jump:widget mainicon="icon-search" maintitle="cliente.page.title"
             widgettitle="cliente.crud.page.title" span="6">
    <form class="form" action="${contexto}/cliente/search.do" method="post" id="formSearch">
        <div class="control-group">
            <label class="control-label" for="tipoPessoa"><spring:message
                    code="cliente.pessoa.pesTipoPessoa.label"/></label>

            <div class="controls">
                <select class="input-large" id="tipoPessoa" name="tipoPessoa">
                    <c:forEach items="${listTipoPessoa}" var="item">
                        <option ${object eq item ? 'selected' : ''} value="${item}">
                            <spring:message code="${item.descricao}"/>
                        </option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="identificacao"><spring:message
                    code="cliente.pessoa.pesIdentificacao.label"/></label>
            <input type="text" id="identificacao" name="identificacao" class="input-large"/>
        </div>

        <div class="widget-content">
            <div class="padd">
                <hr/>
                <div class="btn-group pull-right">
                    <button type="submit" class="btn btn-primary"><spring:message
                            code="global.action.continuar"/></button>
                    <a href="${contexto}/cliente/index.do" class="btn"><spring:message
                            code="global.action.cancelar"/></a>
                </div>
            </div>
        </div>
    </form>
</jump:widget>

</body>
</html>
