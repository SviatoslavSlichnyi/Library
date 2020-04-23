<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>Library</title>

    <jsp:include page="libs.jsp"/>
</head>
<body class="body text-center">
  
    <!-- Navigation bar -->
    <c:import url="/nav-bar"/>

    <!-- Welcome message -->
    <div class="container">
        <div id="cov-cont" class="cover-container d-flex h-100 p-3 mx-auto flex-column marg-b-5">

            <main role="main" class="inner cover">
                <h1 class="cover-heading">Welcome to Library</h1>
                <p class="lead">Read. Write. Share.</p>
                <p class="lead">
                    <sec:authorize access="!isAuthenticated()">
                        <a href="${contextPath}/registration" class="btn btn-lg btn-secondary">Sign Up now</a>
                    </sec:authorize>
                </p>
            </main>

        </div>
    </div>

    <!-- Footer -->
    <jsp:include page="footer.jsp"/>

</body>
</html>