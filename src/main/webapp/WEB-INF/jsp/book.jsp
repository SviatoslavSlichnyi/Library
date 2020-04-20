<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

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
<%--                        <button type="button" class="btn btn-warning w-100 mb-2">Save</button>--%>
                        <a class="mt-4" href="${contextPath}/media/${book.bookFile.id}" download>
                            <button type="button" class="btn btn-outline-success w-100">Download</button>
                        </a>
                    </div>
                </div>
            </div><!--/col-3-->

            <div class="col-sm-9">
                <!-- Title -->
                <div class="col-sm w-100">
                    <div class="w-50 fl-left">
                        <h1>Book</h1>
                    </div>
                    <div class="w-50 fl-left">
                        <a href="${contextPath}/edit-book/${book.id}">
                            <button type="button" class="btn btn-secondary mt-2 float-right">Edit</button>
                        </a>
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

                            <div class="form-group">
                                <div class="col-xs-6">
                                    <h6 class="m-0 sub-title">Publisher</h6>
                                    <h3 class="m-0">${book.publisher}</h3>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-xs-6">
                                    <h6 class="m-0 sub-title">Publication year</h6>
                                    <h3 class="m-0">${book.publicationYear}</h3>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-xs-6">
                                    <h6 class="m-0 sub-title">Number of pages</h6>
                                    <h3 class="m-0">${book.numberOfPages}</h3>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-xs-6">
                                    <h6 class="m-0 sub-title">Language</h6>
                                    <h3 class="m-0">${book.language}</h3>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-xs-6">
                                    <h6 class="m-0 sub-title">Description</h6>
                                    <h3 class="m-0">${book.description}</h3>
                                </div>
                            </div>

                        </div>

                        <hr>

                    </div>
                </div>
                <!--/tab-pane-->
            </div><!--/tab-content-->
        </div><!--/col-9-->
    </div> <!--/row-->

    <jsp:include page="footer.jsp"/>

</body>

</html>