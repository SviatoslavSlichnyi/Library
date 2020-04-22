<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="uname" value="${username}"/>
<c:set var="isAdmin" value="${isAdmin}"/>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="${pageContext.request.contextPath}">
        <img src="https://cdn0.iconfinder.com/data/icons/education-and-learning-10/64/Books-512.png"
             width="30" height="30" class="d-inline-block align-top" alt="">
        Library
    </a>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">

        <c:if test="${not empty uname}">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="${contextPath}/books">Books</a>
                </li>

            </ul>

            <ul class="nav navbar-nav ml-auto">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown">${uname}</a>
                    <div class="dropdown-menu dropdown-menu-right">
                        <a href="${contextPath}/my-account" class="dropdown-item">My Account</a>
                        <c:if test="${isAdmin == true}">
                            <div class="dropdown-divider"></div>
                            <a href="${contextPath}/admin/manage-accounts" class="dropdown-item">Manage Accounts</a>
                            <a href="${contextPath}/admin/manage-books" class="dropdown-item">Manage Books</a>
                        </c:if>
                        <c:if test="${isUser == true}">
                            <div class="dropdown-divider"></div>
                            <a href="${contextPath}/my-books" class="dropdown-item">My Books</a>
                            <a href="${contextPath}/saved-books" class="dropdown-item">Saved Books</a>
                        </c:if>
                        <div class="dropdown-divider"></div>
                        <a href="${contextPath}/logout" class="dropdown-item">Logout</a>
                    </div>
                </li>
            </ul>
        </c:if>

    </div>

    <c:if test="${empty uname}">
        <a id="login-btn" class="float-left" href="${contextPath}/login">Login</a>
    </c:if>

</nav>
