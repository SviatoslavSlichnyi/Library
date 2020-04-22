<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>

<head>
    <meta charset='utf-8'>
    <title>Library | Edit Account</title>

    <jsp:include page="libs.jsp"/>
</head>


<body class="body">

    <c:import url="/nav-bar"/>


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
                    Account
                    <a href="${pageContext.request.contextPath}/my-account">
                        <button type="button" class="btn btn-danger mt-2 float-right">Cancel</button>
                    </a>
                </h1>

                <hr>

                <div class="tab-content">
                    <div class="tab-pane active">
                        <form:form  modelAttribute="editUserForm" method="POST" action="${contextPath}/my-account/edit">

                            <spring:bind path="username">
                                <div class="form-group">
                                    <label for="username">Username</label>
                                    <form:input path="username"
                                                type="text"
                                                id="username"
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

                            <div class="form-group">
                                <label for="email">Email address</label>
                                <div id="error-email" class="invalid-text"></div>
                                <input type="email"
                                       id="email"
                                       class="form-control"
                                       value="${user.email}"
                                       disabled/>
                                <div class="text-danger text-center"></div>
                            </div>

                            <div class="form-group">
                                <div class="col-xs-12">
                                    <br>
                                    <button class="btn btn-lg btn-success" type="submit">Save</button>
                                    <button class="btn btn-lg" type="reset" onclick="location.reload()">
                                        Reset
                                    </button>
                                </div>
                            </div>

                            <hr>
                        </form:form>

                    </div>
                </div>

            </div>
        </div>
    </div>


    <jsp:include page="footer.jsp"/>

</body>

</html>