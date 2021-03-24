<%@page contentType='text/html' pageEncoding='iso-8859-1'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!doctype html>
<html>
    <head>
        <title><spring:message code="login.title" /></title>
    </head>
    <body>
        <div class="admin-form">
            <div class="container-fluid">
                <div class="row-fluid">
                    <div class="span12">
                        <div class="widget">
                            <div class="widget-head">
                                <i class="icon-lock"></i> <spring:message code="login.header" />
                            </div>
                            <div class="widget-content">
                                <div class="padd">
                                    <form:form action="${contexto}/login.do" method="POST" class="form-horizontal" modelAttribute="usuario">
                                        <input type="hidden" name="redirect_url" value="${redirectUrl}" />

                                        <c:if test="${erroLogin ne null}">
                                            <div class="alert alert-error fade-in">
                                                <button type="button" class="close" data-dismiss="alert">×</button>
                                                <spring:message code="${erroLogin}" />
                                            </div>
                                        </c:if>

                                        <div class="control-group">
                                            <label class="control-label"><spring:message code="login.usuario" /></label>
                                            <div class="controls">
                                                <form:input type="text" id="usuUsuario" path="usuUsuario" placeholder="Usuário" />
                                            </div>
                                        </div>
                                        <div class="control-group">
                                            <label class="control-label"><spring:message code="login.senha" /></label>
                                            <div class="controls">
                                                <form:input type="password" id="usuSenha" path="usuSenha" placeholder="Senha" />
                                            </div>
                                        </div>

                                        <div class="control-group">
                                            <div class="controls">
                                                <button type="submit" class="btn btn-info"><spring:message code="global.action.login" /></button>
                                            </div>
                                        </div>
                                    </form:form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>