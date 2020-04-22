<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>Library | Registration</title>

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
                        <h4 class="card-title mt-2">Sign up</h4>
                    </header>

                    <article class="card-body">
                        <form:form  modelAttribute="userForm" method="POST"  enctype="multipart/form-data"
                                    action="${contextPath}/registration">

                            <spring:bind path="username">
                                <div class="form-group">
                                    <label>*Username</label>
                                    <small class="form-text text-muted">This name will be used for public posts.</small>
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
                                        <label>First name </label>
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
                                        <label>Last name</label>
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
                                    <label>*Email address</label>
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
                                    <label>*Create password</label>
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
                                    <label>*Confirm password</label>
                                    <div id="error-conf-pwd" class="invalid-text"></div>
                                    <form:input path="passwordConfirm"
                                                type="password"
                                                class="form-control"/>
                                    <div class="text-danger text-center">
                                        <form:errors path="passwordConfirm"/>
                                    </div>
                                </div>
                            </spring:bind>

                            <small class="form-text text-muted mb-2">* - required fields</small>

                            <div class="form-group">
                                <button type="submit"
                                        class="btn btn-lg btn-primary btn-block btn-signin">Register</button>
                            </div>
                            <small class="text-muted">
                                By clicking the 'Sign Up' button, you confirm that you accept our <br>
                                Terms of use and Privacy Policy.
                            </small>
                        </form:form>
                    </article>

                    <div class="border-top card-body text-center">
                        Have an account?
                        <a href="${contextPath}/login">Log In</a>
                    </div>

                </div>
            </div>

        </div>
    </div>

    <jsp:include page="footer.jsp"/>

</body>
</html>