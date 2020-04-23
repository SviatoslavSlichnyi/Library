<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<sec:authentication var="currentUsername" property="principal.username"/>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset='utf-8'>
    <title>Library | Book</title>

    <jsp:include page="libs.jsp"/>
</head>

<body class="body">

    <c:import url="/nav-bar"/>

    <div class="container bootstrap snippet marg-b-5">
        <div class="row mt-4">
            <%--Left--%>
            <div class="col-sm-3">
                <!--left col-->
                <div class="text-center">
                    <img src="${contextPath}/media/${book.hardcoverFile.id}"
                         class="avatar img-circle img-thumbnail wd-12r"
                         alt="hardcover">
                </div>
                <div>
                    
                </div>
                <hr><br>

                <div class="panel panel-default">
                    <div class="panel-body">
                        <sec:authorize access="hasRole('USER')">
                            <c:if test="${isSaved != true}">
                                <form:form method="post" action="${contextPath}/saved-books/save/${book.id}">
                                    <button type="submit" class="btn btn-warning w-100 mb-2">Save</button>
                                </form:form>
                            </c:if>
                            <c:if test="${isSaved}">
                                <a href="${contextPath}/saved-books">
                                    <button type="submit" class="btn btn-secondary w-100 mb-2">Go to Saved Books</button>
                                </a>
                            </c:if>
                        </sec:authorize>
                        <a class="mt-4" href="${contextPath}/media/${book.bookFile.id}" download>
                            <button type="button" class="btn btn-outline-success w-100">Download</button>
                        </a>
                    </div>
                </div>
            </div><!--/col-3-->

            <%--Center--%>
            <div class="col-sm-9">
                <!-- Title -->
                <div class="col-sm w-100">
                    <div class="w-50 fl-left">
                        <h1>Book</h1>
                    </div>
                    <div class="w-50 fl-left">
                        <c:if test="${book.user.username == currentUsername}">
                            <a href="${contextPath}/edit-book/${book.id}">
                                <button type="button" class="btn btn-secondary mt-2 float-right">Edit</button>
                            </a>
                        </c:if>
                    </div>
                </div>

            <br><br>

                <!-- Information -->
                <div class="tab-content">
                    <div class="tab-pane active" id="home">
                        <hr>
                        <div class="form">

                            <div class="form-group">
                                <div class="col-xs-6">
                                    <h6 class="m-0 sub-title">Title</h6>
                                    <h3 class="m-0">${book.name}</h3>
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <div class="form-row w-100">                                    
                                    <div class="col-xs-6 w-50">
                                        <h6 class="m-0 sub-title">Author first name</h6>
                                        <h3 class="m-0">${book.author.firstName}</h3>
                                    </div>
                                    <div class="col-xs-6 w-50">
                                        <h6 class="m-0 sub-title">Author last name</h6>
                                        <h3 class="m-0">${book.author.lastName}</h3>
                                    </div>
                                </div>
                            </div>

                            <c:if test="${not empty book.publisher}">
                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <h6 class="m-0 sub-title">Publisher</h6>
                                        <h3 class="m-0">${book.publisher}</h3>
                                    </div>
                                </div>
                            </c:if>

                            <c:if test="${not empty book.publicationYear}">
                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <h6 class="m-0 sub-title">Publication year</h6>
                                        <h3 class="m-0">${book.publicationYear}</h3>
                                    </div>
                                </div>
                            </c:if>

                            <c:if test="${not empty book.numberOfPages}">
                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <h6 class="m-0 sub-title">Number of pages</h6>
                                        <h3 class="m-0">${book.numberOfPages}</h3>
                                    </div>
                                </div>
                            </c:if>

                            <c:if test="${not empty book.language}">
                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <h6 class="m-0 sub-title">Language</h6>
                                        <h3 class="m-0">${book.language}</h3>
                                    </div>
                                </div>
                            </c:if>

                            <c:if test="${not empty book.description}">
                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <h6 class="m-0 sub-title">Description</h6>
                                        <h3 class="m-0">${book.description}</h3>
                                    </div>
                                </div>
                            </c:if>

                        </div>

                        <hr class="mb-2">

                        <div class="w-100 mt-0">
                            <h6 class="m-0 sub-title float-right">${currentUsername}</h6>
                        </div>

                    </div>
                </div>

            </div>
        </div>
    </div>

    <jsp:include page="footer.jsp"/>

</body>

</html>