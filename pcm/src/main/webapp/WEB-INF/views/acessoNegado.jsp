<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="jump" uri="http://www.macor.in/tags" %>

<html>
<body>

<jump:widget mainicon="icon-remove" maintitle="acesso.negado.header"
             widgettitle="acesso.negado.header" span="6">

    <c:if test="${usuarioLogado eq null}">
        <div class="navbar navbar-fixed-top"></div>
    </c:if>
    <p><spring:message code="acesso.negado.message"/></p>
</jump:widget>
</body>
</html>