<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset='utf-8'>
    <title><spring:message code="project.name"/> | Error</title>

    <jsp:include page="libs.jsp"/>
</head>

<body class="body text-center">

    <!-- Navigation bar -->
    <jsp:include page="nav-bar.jsp"/>

    <!-- Welcome message -->
    <div class="container">
        <div id="cov-cont" class="cover-container d-flex h-100 p-3 mx-auto flex-column marg-b-5">

            <main role="main" class="inner cover">
                <h1 class="cover-heading">
                    <spring:message code="error.title"/>
                </h1>
                <p class="lead"><spring:message code="error.msg"/></p>
            </main>

        </div>
    </div>

    <!-- Footer -->
    <jsp:include page="footer.jsp"/>

</body>

</html>