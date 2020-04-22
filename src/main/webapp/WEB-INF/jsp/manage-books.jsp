<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>Library | Manage Books</title>

    <jsp:include page="libs.jsp"/>
</head>
<body class="body">

    <c:import url="/nav-bar"/>


    <div class="container mt-4 marg-b-cards">

        <h1 class="w-100">Manage Books</h1>
        <hr>

        <table class="table">
            <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Title</th>
                <th scope="col">Author</th>
                <th scope="col">Posted by</th>
                <th scope="col" class="wd-5r"></th>
                <th scope="col" class="wd-5r"></th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="book" items="${books}">
                <tr>
                    <th scope="row">${book.id}</th>
                    <td>${book.name}</td>
                    <td>${book.author}</td>
                    <td>${book.user.username}</td>
                    <td>
                        <a href="${contextPath}/book/${book.id}" class="btn btn-primary btn-sm">Open</a>
                    </td>
                    <td>
                        <form:form method="POST" action="${contextPath}/admin/manage-books/delete/${book.id}">
                            <button type="submit" class="btn btn-outline-danger btn-sm">Delete</button>
                        </form:form>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>

    </div>


    <jsp:include page="footer.jsp"/>

</body>
</html>