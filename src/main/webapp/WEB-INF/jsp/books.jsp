<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>Library | Books</title>

    <jsp:include page="libs.jsp"/>
</head>
<body class="body">
  
    <jsp:include page="navbar.jsp"/>

    <div class="container mt-4 marg-b-cards">

        <h1 class="w-100">
            Books
            <a href="${pageContext.request.contextPath}/add-book">
                <button type="button" class="btn btn-success mt-2 fl-right">Add Book</button>
            </a>
        </h1>
        <hr class="mt-0">

        <c:forEach var="book" items="${books}">
            <div class="card m-4 d-inline-block bookcard-w">
                <img class="card-img-top h-18"
                     src="${pageContext.request.contextPath}/media/${book.hardcoverFile.id}"
                     alt="Book hardcover">
                <div class="card-body ">
                    <h5 class="card-title m-0">${book.name}</h5>
                    <div class="meta">
                        <a>${book.author}</a>
                    </div>
                </div>
                <div class="card-footer p-2">
                    <a href="${pageContext.request.contextPath}/book/${book.id}"
                       class="btn btn-primary btn-sm w-100">Open</a>
                </div>
            </div>
        </c:forEach>

    <br><hr>
    </div>

    <jsp:include page="footer.jsp"/>

</body>
</html>