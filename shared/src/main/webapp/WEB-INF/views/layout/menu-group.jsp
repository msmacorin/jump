<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${listaMenu ne null}">
    <c:forEach items="${listaMenu}" var="menu">
        <li class="has_sub"><a href="${menu.action ne null ? menu.action : '#'}"><i class="${menu.icon ne null ? menu.icon : 'icon-file-alt'}"></i> <spring:message code="${menu.label}" />  <span class="pull-right"><i class="icon-chevron-right"></i></span></a>
                    <c:if test="${menu.itensMenu ne null}">
                <ul>
                    <c:forEach items="${menu.itensMenu}" var="item">
                        <li>
                            <a href="${contexto}${item.action}"><spring:message code="${item.label}" /></a>
                        </li>
                    </c:forEach>
                </ul>
            </c:if>
        </li>
    </c:forEach>
</c:if>