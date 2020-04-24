<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>

<head>
    <meta charset='utf-8'>
    <title><spring:message code="project.name"/> | <spring:message code="my-books.title"/></title>
    
    <jsp:include page="libs.jsp"/>
</head>

<body class="body">
  
    <c:import url="/nav-bar"/>


    <div class="container mt-4 marg-b-cards">

        <h1 class="w-100">
            <spring:message code="my-books.title"/>
            <a href="${pageContext.request.contextPath}/add-book">
                <button type="button" class="btn btn-success mt-2 fl-right">
                    <spring:message code="my-books.btn.add-book"/>
                </button>
            </a>
        </h1>
    
    <hr>

        <c:forEach var="book" items="${books}">
            <div class="card m-4 d-inline-block bookcard-w">
                <img class="card-img-top h-18"
                     src="${contextPath}/media/${book.hardcoverFile.id}"
                     alt="Book hardcover">
                <div class="card-body ">
                    <h5 class="card-title m-0">${book.name}</h5>
                    <div class="meta">
                        <a>${book.author} </a>
                    </div>
                </div>

                <div class="card-footer p-2">
                    <form:form action="${contextPath}/my-books/delete/${book.id}" method="POST" cssClass="btn btn-sm p-0">
                        <button type="submit" class="btn btn-outline-danger btn-sm m-0">
                            <spring:message code="simple.btn.delete"/>
                        </button>
                    </form:form>
                    <a href="${contextPath}/book/${book.id}"
                       class="btn btn-primary btn-sm fl-right btn-open">
                        <spring:message code="simple.btn.open"/>
                    </a>
                </div>
            </div>
        </c:forEach>

    </br><hr>
    </div>
    

    <jsp:include page="footer.jsp"/>

</body>

</html>