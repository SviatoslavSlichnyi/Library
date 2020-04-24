<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>

<head>
    <meta charset='utf-8'>
    <title><spring:message code="project.name"/> | <spring:message code="registration.title"/></title>

    <jsp:include page="libs.jsp"/>
    <script src="${contextPath}/resources/js/validation.js"></script>
</head>

<body class="body">

    <c:import url="/nav-bar"/>

    <div class="container mt-4 marg-b-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">

                    <header class="card-header">
                        <h4 class="card-title mt-2">
                            <spring:message code="sign-up"/>
                        </h4>
                    </header>

                    <article class="card-body">
                        <form:form  modelAttribute="userForm" method="POST"  enctype="multipart/form-data"
                                    action="${contextPath}/registration">

                            <spring:bind path="username">
                                <div class="form-group">
                                    <label>
                                        *<spring:message code="user.form.username"/>
                                    </label>
                                    <small class="form-text text-muted">
                                        <spring:message code="registration.form.username.warning"/>
                                    </small>
                                    <form:input path="username"
                                                type="text"
                                                class="form-control"/>
                                    <div class="text-danger text-center">
                                        <form:errors path="username"/>
                                    </div>
                                </div>
                            </spring:bind>

                            <div class="form-row">
                                <spring:bind path="firstName">
                                    <div class="col form-group">
                                        <label>
                                            <spring:message code="user.form.first-name"/>
                                        </label>
                                        <div id="first-name-error" class="invalid-text"></div>
                                        <form:input path="firstName"
                                                    type="text"
                                                    class="form-control"/>
                                        <div class="text-danger text-center">
                                            <form:errors path="firstName"/>
                                        </div>
                                    </div>
                                </spring:bind>

                                <spring:bind path="lastName">
                                    <div class="col form-group">
                                        <label>
                                            <spring:message code="user.form.last-name"/>
                                        </label>
                                        <div id="last-name-error" class="invalid-text"></div>
                                        <form:input path="lastName"
                                                    type="text"
                                                    class="form-control"/>
                                        <div class="text-danger text-center">
                                            <form:errors path="lastName"/>
                                        </div>
                                    </div>
                                </spring:bind>
                            </div>

                            <spring:bind path="email">
                                <div class="form-group">
                                    <label>
                                        *<spring:message code="user.form.email"/>
                                    </label>
                                    <div id="error-email" class="invalid-text"></div>
                                    <form:input path="email"
                                                type="email"
                                                class="form-control"/>
                                    <div class="text-danger text-center">
                                        <form:errors path="email"/>
                                    </div>
                                </div>
                            </spring:bind>

                            <spring:bind path="password">
                                <div class="form-group">
                                    <label>
                                        *<spring:message code="registration.form.create-password"/>
                                    </label>
                                    <div id="error-pwd" class="invalid-text"></div>
                                    <form:input path="password"
                                                type="password"
                                                class="form-control"/>
                                    <div class="text-danger text-center">
                                        <form:errors path="password"/>
                                    </div>
                                </div>
                            </spring:bind>

                            <spring:bind path="passwordConfirm">
                                <div class="form-group">
                                    <label>
                                        *<spring:message code="registration.form.confirm-password"/>
                                    </label>
                                    <div id="error-conf-pwd" class="invalid-text"></div>
                                    <form:input path="passwordConfirm"
                                                type="password"
                                                class="form-control"/>
                                    <div class="text-danger text-center">
                                        <form:errors path="passwordConfirm"/>
                                    </div>
                                </div>
                            </spring:bind>

                            <small class="form-text text-muted mb-2">
                                * - <spring:message code="registration.form.required-fields"/>
                            </small>

                            <div class="form-group">
                                <button type="submit"
                                        class="btn btn-lg btn-primary btn-block btn-signin">
                                    <spring:message code="registration.form.btn.register"/>
                                </button>
                            </div>
                            <small class="text-muted">
                                <spring:message code="registration.form.terms"/>
                            </small>
                        </form:form>
                    </article>

                    <div class="border-top card-body text-center">
                        <spring:message code="registration.account.exists"/>
                        <a href="${contextPath}/login">
                            <spring:message code="login"/>
                        </a>
                    </div>

                </div>
            </div>

        </div>
    </div>

    <jsp:include page="footer.jsp"/>

</body>

</html>