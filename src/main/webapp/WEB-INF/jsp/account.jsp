<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authentication var="currentUsername" property="principal.username"/>
<c:set var="isMyAcocunt" value="${currentUsername eq user.username}"/>
<spring:message var="accountTitle" code="account.title"/>
<spring:message var="myAccountTitle" code="my-account.title"/>
<c:set var="title" value="${isMyAcocunt ? myAccountTitle : accountTitle}"/>

<!DOCTYPE html>
<html>

<head>
    <meta charset='utf-8'>
    <title><spring:message code="project.name"/> | ${title}</title>

    <jsp:include page="libs.jsp"/>
</head>

<body class="body">

    <jsp:include page="nav-bar.jsp"/>

    <div class="container bootstrap snippet marg-b-5">
        <div class="row mt-4">
            <%--Left Bar--%>
            <div class="col-sm-3">
                <!--left col-->
                <div class="text-center">
                    <img class="avatar img-circle img-thumbnail wd-12r"
                         src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png"
                        alt="avatar">
                </div>

                <hr>
            </div>


            <%--Main container--%>
            <div class="col-sm-9">

                <h1 class="w-100">
                    ${title}
                    <c:if test="${isMyAcocunt}">
                        <a href="${pageContext.request.contextPath}/my-account/edit">
                            <button type="button" class="btn btn-secondary mt-2 fl-right">
                                <spring:message code="simple.btn.edit"/>
                            </button>
                        </a>
                    </c:if>
                </h1>

                <hr>

                <div class="tab-content">
                    <div class="tab-pane active">

                        <div class="form-group">
                            <div class="col-xs-6">
                                <h6 class="m-0 sub-title">
                                    <spring:message code="user.form.username"/>
                                </h6>
                                <h3 class="m-0">${user.username}</h3>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="form-row w-100">

                                <c:if test="${not empty user.firstName}">
                                    <div class="col-xs-6 w-50">
                                        <h6 class="m-0 sub-title">
                                            <spring:message code="user.form.first-name"/>
                                        </h6>
                                        <h3 class="m-0">${user.firstName}</h3>
                                    </div>
                                </c:if>

                                <c:if test="${not empty user.lastName}">
                                    <div class="col-xs-6 w-50">
                                        <h6 class="m-0 sub-title">
                                            <spring:message code="user.form.last-name"/>
                                        </h6>
                                        <h3 class="m-0">${user.lastName}</h3>
                                    </div>
                                </c:if>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-xs-6">
                                <h6 class="m-0 sub-title">
                                    <spring:message code="user.form.email"/>
                                </h6>
                                <h3 class="m-0">${user.email}</h3>
                            </div>
                        </div>

                        <hr>

                    </div>
                </div>

            </div>
        </div>
    </div>


    <jsp:include page="footer.jsp"/>

</body>

</html>