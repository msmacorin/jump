<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--menu navegacao-->
<div class="sidebar">
    <div class="sidebar-dropdown"><a href="#"> <spring:message code="menu.navegacao" /></a></div>

    <ul id="nav">
        <li><a href="${contexto}/index.jsp" class="open"><i class="icon-home"></i> <spring:message code="menu.home" /></a></li>
            <jsp:include page="menu-group.jsp" />
    </ul>
</div>
