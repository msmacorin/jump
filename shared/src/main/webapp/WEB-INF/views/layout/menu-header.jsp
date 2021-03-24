<%-- 
    Document   : menu-header
    Created on : May 27, 2013, 10:13:42 PM
    Author     : macorin
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--menu superior-->
<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <!-- Links -->
            <ul class="nav pull-right">
                <li class="dropdown pull-right">            
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <i class="icon-share"></i><spring:message code="menu.navegacao" /><b class="caret"></b>              
                    </a>

                    <ul class="dropdown-menu">
                        <li><a href="/admin/index.do"><i class="icon-plus"></i> <spring:message code="menu.modulo.admin" /></a></li>
                        <li><a href="/pcm/index.do"><i class="icon-plus"></i> <spring:message code="menu.modulo.pcm" /></a></li>
                        <li><a href="/pessoa/index.do"><i class="icon-plus"></i> <spring:message code="menu.modulo.pessoa" /></a></li>
                    </ul>
                </li>

                <li class="dropdown pull-right">            
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <i class="icon-user"></i>${usuarioLogado.usuNome}<b class="caret"></b>
                    </a>

                    <ul class="dropdown-menu">
                        <li><a href="/admin/profile/editar.do?id=${usuarioLogado.usuId}"><i class="icon-cogs"></i> <spring:message code="menu.perfil" /></a></li>
                        <li><a href="/admin/alterarSenha/editar.do?id=${usuarioLogado.usuId}"><i class="icon-lock"></i> <spring:message code="menu.alterarSenha" /></a></li>
                        <li><a href="/admin/logout.do"><i class="icon-off"></i> <spring:message code="menu.logout" /></a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>

<!--header-->
<header>
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span4">
                <div class="logo">
                    <h1><a href="#">Jump<span class="bold"><spring:message code="modulo.nome" /></span></a></h1>
                    <p class="meta"><spring:message code="modulo.descricao" /></p>
                </div>
            </div>
        </div>
    </div>
</header>