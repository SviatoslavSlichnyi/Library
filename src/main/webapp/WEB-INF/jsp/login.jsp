<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset='utf-8'>
    <title>Library | Login</title>

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
                        <h4 class="card-title mt-2">Login</h4>
                    </header>
                    <article class="card-body">

                        <c:if test="${param.error != null}">
                            <div id="error-bad-cread" class="alert alert-danger" role="alert">
                                    Email or Password is wrong
                            </div>
                        </c:if>

                        <form method="post" action="${contextPath}/login">

                                <div class="form-group">
                                    <label>Email</label>
                                    <input id="email"
                                           name="email"
                                           type="email"
                                           class="form-control">
                                    <div id="email-error" class="text-danger text-center"></div>
                                </div>

                                <div class="form-group">
                                    <label>Password</label>
                                    <input id="pwd"
                                           name="password"
                                           type="password"
                                           class="form-control">
                                    <div id="pwd-error"  class="text-danger text-center"> </div>
                                </div>

                            <div class="form-group">
                                <button type="submit" class="btn btn-lg btn-primary btn-block btn-signin">Login</button>
                            </div>
                        </form>
                    </article> <!-- card-body end .// -->
                    <div class="border-top card-body text-center">
                        Don't have an account?
                        <a href="${contextPath}/registration">Sign up</a></div>
                </div> <!-- card.// -->
            </div> <!-- col.//-->

        </div> <!-- row.//-->
    </div>
    <!--container end.//-->

    <jsp:include page="footer.jsp"/>

</body>
</html>