<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>

<head>
    <meta charset='utf-8'>
    <title><spring:message code="project.name"/> | <spring:message code="books.title"/></title>

    <jsp:include page="libs.jsp"/>
</head>

<body class="body">

    <jsp:include page="nav-bar.jsp"/>

    <div class="container mt-4 marg-b-cards">

        <h1 class="w-100">
            <spring:message code="books.title"/>
        </h1>
        <hr class="mt-0">

        <c:forEach var="book" items="${books}">
            <div class="card m-4 d-inline-block bookcard-w">
                <img class="card-img-top h-18"
                     src="${contextPath}/media/${book.hardcoverFile.id}"
                     alt="Book hardcover">
                <div class="card-body ">
                    <h5 class="card-title m-0">${book.name}</h5>
                    <div class="meta">
                        <a>${book.author}</a>
                    </div>
                </div>
                <div class="card-footer p-2">
                    <a href="${contextPath}/book/${book.id}"
                       class="btn btn-primary btn-sm w-100">
                        <spring:message code="simple.btn.open"/>
                    </a>
                </div>
            </div>
        </c:forEach>

    <br><hr>
    </div>

    <jsp:include page="footer.jsp"/>

</body>

</html>