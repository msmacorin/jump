<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <meta name="description" content="Jump">
    <meta name="keywords" content="jump pcm frota">
    <meta name="author" content="Marcelo S. Macorin">

    <title>jump - <spring:message code="modulo.nome"/> - <decorator:title/></title>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/style/bootstrap.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/style/bootstrap-responsive.css">

    <link rel="stylesheet" href="<%=request.getContextPath()%>/style/jquery.dataTables.css">
    <%--<link rel="stylesheet"      href="<%=request.getContextPath()%>/style/jquery.dataTables_themeroller.css">--%>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/style/datepicker.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/style/font-awesome.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/style/style.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/style/jquery-ui.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/style/fullcalendar.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/style/prettyPhoto.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/style/rateit.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/style/bootstrap-datetimepicker.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/style/jquery.cleditor.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/style/uniform.default.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/style/bootstrap-toggle-buttons.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/style/widgets.css">

    <!-- HTML5 Support for IE -->
    <!--[if lt IE 9]>
    <script src="js/html5shim.js"></script>
    <![endif]-->


    <link rel="shortcut icon" href="<%=request.getContextPath()%>/img/favicon/favicon.png">
</head>
<body>

<spring:message code="global.confirmacao.deletar.registro" var="global_confirmacao_deletar_registro_msg"/>
<spring:message code="global.sim" var="global_sim_msg"/>
<spring:message code="global.nao" var="global_nao_msg"/>

<script type="text/javascript">
    var contexto = "${contexto}";
    var locale = "pt_BR";
    var global_confirmacao_deletar_registro_msg = "${global_confirmacao_deletar_registro_msg}";
    var global_sim_msg = "${global_sim_msg}";
    var global_nao_msg = "${global_nao_msg}";
</script>

<!--jquery-->
<script src="<%=request.getContextPath()%>/js/jquery.js"></script>

<!--bootstrap-->

<%--incluido--%>

<%--
se tira, não funciona tabs.... se não tira não funciona dialog.
=/=/
--%>


<%--<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>--%>
<%--incluido--%>

<script src="<%=request.getContextPath()%>/js/DT_bootstrap.js"></script>

<!--datatables-->
<script src="<%=request.getContextPath()%>/js/jquery.dataTables.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap-modal.js"></script>

<!--mascara-->
<script src="<%=request.getContextPath()%>/js/jqueryMaskedInput.js"></script>

<%--TODO: implemetar o noty();--%>
<div id="msgArea">
    <c:if test="${mensagemAlerta ne null}">
        <div class="alert fade-in">
            <button type="button" class="close" data-dismiss="alert">×</button>
            <spring:message code="${mensagemAlerta}"/>
        </div>
    </c:if>
    <c:if test="${mensagemSucesso ne null}">
        <div class="alert alert-success fade-in">
            <button type="button" class="close" data-dismiss="alert">×</button>
            <spring:message code="${mensagemSucesso}"/>
        </div>
    </c:if>
    <c:if test="${mensagemErro ne null}">
        <div class="alert alert-error fade-in">
            <button type="button" class="close" data-dismiss="alert">×</button>
            <spring:message code="${mensagemErro}" arguments="${mensagemArgumentos}"/>
        </div>
    </c:if>
    <c:if test="${mensagemInformacao ne null}">
        <div class="alert alert-info fade-in">
            <button type="button" class="close" data-dismiss="alert">×</button>
            <spring:message code="${mensagemInformacao}"/>
        </div>
    </c:if>
    <c:if test="${mensagemRuntime ne null}">
        <div class="alert alert-error fade-in">
            <button type="button" class="close" data-dismiss="alert">×</button>
            <label>${mensagemRuntime}</label>
        </div>
    </c:if>
</div>

<c:if test="${usuarioLogado ne null}">
    <jsp:include page="menu-header.jsp"/>
</c:if>

<div class="content">
    <c:if test="${usuarioLogado ne null}">
        <jsp:include page="menu.jsp"/>
    </c:if>

    <decorator:body/>
</div>

<!-- Footer starts -->
<div class="navbar navbar-fixed-bottom">
    <footer>
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span12">
                    <!-- Copyright info -->
                    <p class="copy">Copyright &copy; 2012 | <a href="#">macor.in</a></p>
                </div>
            </div>
        </div>
    </footer>
</div>
<!-- Footer ends -->

<!-- Scroll to top -->
<span class="totop"><a href="#"><i class="icon-chevron-up"></i></a></span>

<!--jump-->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jump.js"></script>

<!--jquery ui-->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-ui-1.9.2.custom.min.js"></script>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/fullcalendar.min.js"></script>
<!-- Full Google Calendar - Calendar -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.rateit.min.js"></script>
<!-- RateIt - Star rating -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.prettyPhoto.js"></script>
<!-- prettyPhoto -->

<!-- jQuery Flot -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/excanvas.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.flot.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.flot.resize.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.flot.pie.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.flot.stack.js"></script>

<!-- jQuery Notification - Noty -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.noty.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/themes/default.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/layouts/bottom.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/layouts/topRight.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/layouts/top.js"></script>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap-dropdown.js"></script>
<%--<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap-datepicker.js"></script>--%>

<!--validate-->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.validate.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.validate.custom.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.validate.br.js"></script>


<!--diversos-->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.tinysort.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/shortcut.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootbox.js"></script>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/sparklines.js"></script>
<!-- Sparklines -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.cleditor.min.js"></script>
<!-- CLEditor -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap-datetimepicker.min.js"></script>
<!-- Date picker -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.uniform.min.js"></script>
<!-- jQuery Uniform -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.toggle.buttons.js"></script>
<!-- Bootstrap Toggle -->

<!--design-->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/custom.js"></script>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/charts.js"></script>
<!-- Charts & Graphs -->

</body>
</html>
