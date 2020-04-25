<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>

<head>
    <meta charset='utf-8'>
    <title><spring:message code="project.name"/> | <spring:message code="manage-accounts.title"/></title>

    <jsp:include page="libs.jsp"/>
</head>

<body class="body">

    <jsp:include page="nav-bar.jsp"/>

    <div class="container mt-4 marg-b-cards">

        <h1 class="w-100">
            <spring:message code="manage-accounts.title"/>
        </h1>
        <hr>

        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">
                        <spring:message code="user.form.username"/>
                    </th>
                    <th scope="col">
                        <spring:message code="user.form.email"/>
                    </th>
                    <th scope="col"></th>
                    <th scope="col" class="wd-5r"></th>
                </tr>
            </thead>
            <tbody>
                
                <c:forEach var="user" items="${users}">
                    <tr>
                        <th scope="row">${user.id}</th>
                        <td>${user.username}</td>
                        <td>${user.email}</td>
                        <td>
                            <a href="${contextPath}/admin/account/${user.id}" class="btn btn-primary btn-sm">
                                <spring:message code="simple.btn.open"/>
                            </a>
                        </td>
                        <td>
                            <form:form method="POST" action="${contextPath}/admin/account/delete/${user.id}">
                                <button type="submit" class="btn btn-outline-danger btn-sm">
                                    <spring:message code="simple.btn.delete"/>
                                </button>
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