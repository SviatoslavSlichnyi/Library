<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">
        <img src="https://cdn0.iconfinder.com/data/icons/education-and-learning-10/64/Books-512.png" width="30" height="30" class="d-inline-block align-top" alt="">
        Library
    </a>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="${contextPath}/books">Books</a>
            </li>

        </ul>

        <!-- Search -->
<%--        <form class="form-inline my-2 my-lg-0">--%>
<%--            <input class="form-control mr-sm-2" name="search" type="search" placeholder="Search" aria-label="Search">--%>
<%--            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>--%>
<%--        </form>--%>

<%--        <ul class="nav navbar-nav ml-auto">--%>
<%--            <li class="nav-item dropdown">--%>
<%--                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">User</a>--%>
<%--                <div class="dropdown-menu dropdown-menu-right">--%>
<%--                    <a href="#" class="dropdown-item">My Account</a>--%>
<%--                    <div class="dropdown-divider"></div>--%>
<%--                    <a href="#" class="dropdown-item">My Books</a>--%>
<%--                    <a href="#" class="dropdown-item">Saved Books</a>--%>
<%--                    <div class="dropdown-divider"></div>--%>
<%--                    <a href="${contextPath}/logout" class="dropdown-item">Logout</a>--%>
<%--                </div>--%>
<%--            </li>--%>
<%--        </ul>--%>

<%--        <a id="login-btn" href="${contextPath}/login">Login</a>--%>

    </div>
</nav>
