<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<sec:authorize var="isAuthenticated" access="isAuthenticated()"/>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="${pageContext.request.contextPath}">
        <img src="https://cdn0.iconfinder.com/data/icons/education-and-learning-10/64/Books-512.png"
             width="30" height="30" class="d-inline-block align-top" alt="">
        Library
    </a>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">

        <c:if test="${isAuthenticated}">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="${contextPath}/books">
                        <spring:message code="nav-bar.tab.books"/>
                    </a>
                </li>
            </ul>
        </c:if>

        <ul class="nav navbar-nav ml-auto">

            <li class="nav-item dropdown mr-4">
                <a class="nav-link dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
                   aria-expanded="false"><spring:message code="nav-bar.language"/></a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="?language=en">en</a>
                </div>
            </li>

            <c:if test="${isAuthenticated}">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown">
                        <sec:authentication property="principal.username"/>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right">

                        <a href="${contextPath}/my-account" class="dropdown-item">
                            <spring:message code="my-account.title"/>
                        </a>

                        <sec:authorize access="hasRole('ADMIN')">
                            <div class="dropdown-divider"></div>
                            <a href="${contextPath}/admin/manage-accounts" class="dropdown-item">
                                <spring:message code="manage-accounts.title"/>
                            </a>
                            <a href="${contextPath}/admin/manage-books" class="dropdown-item">
                                <spring:message code="manage-books.title"/>
                            </a>
                        </sec:authorize>

                        <sec:authorize access="hasRole('USER')">
                            <div class="dropdown-divider"></div>
                            <a href="${contextPath}/my-books" class="dropdown-item">
                                <spring:message code="my-books.title"/>
                            </a>
                            <a href="${contextPath}/saved-books" class="dropdown-item">
                                <spring:message code="saved-books.title"/>
                            </a>
                        </sec:authorize>

                        <div class="dropdown-divider"></div>
                        <a href="${contextPath}/logout" class="dropdown-item">
                            <spring:message code="logout"/>
                        </a>
                    </div>
                </li>
            </c:if>

        </ul>


    </div>

    <c:if test="${!isAuthenticated}">
        <a id="login-btn" class="nav-link float-left m-0 p-0" href="${contextPath}/login">
            <spring:message code="login"/>
        </a>
    </c:if>

</nav>
