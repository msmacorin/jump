<%--
  Created by IntelliJ IDEA.
  User: macorin
  Date: 07/08/14
  Time: 08:56
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
    <title></title>

    <!-- Stylesheets -->
    <link href="<%=request.getContextPath()%>/style/bootstrap.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/style/font-awesome.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/style/style.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/style/bootstrap-responsive.css" rel="stylesheet">

    <link rel="shortcut icon" href="<%=request.getContextPath()%>/img/favicon/favicon.png">
</head>
<body>

<div class="error-page">
    <div class="container-fluid">

        <div class="row-fluid">
            <div class="span12">
                <!-- Widget starts -->
                <div class="widget">
                    <!-- Widget head -->
                    <div class="widget-head">
                        <i class="icon-question-sign"></i> Error
                    </div>

                    <div class="widget-content">
                        <div class="padd error">

                            <h1><spring:message code="modulo.erro404" /></h1>
                            <p><spring:message code="modulo.erro404.descricao" /> </p>
                            <br />

                            <br />
                            <div class="horizontal-links">
                                <a href="index.do">Home</a>
                            </div>

                        </div>
                        <div class="widget-foot">
                            <!-- Footer goes here -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
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

<script src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>

</body>
</html>
