<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>

<head>
    <meta charset='utf-8'>
    <title><spring:message code="project.name"/> | <spring:message code="edit-book.title"/></title>

    <jsp:include page="libs.jsp"/>
</head>

<body class="body">

    <c:import url="/nav-bar"/>

    <div class="container bootstrap snippet marg-b-5">
        <form:form modelAttribute="bookForm" action="${contextPath}/edit-book/${bookForm.id}"
                   class="form"  method="post" enctype="multipart/form-data">

            <div class="row mt-4">

<%--                Left Column--%>
                <div class="col-sm-3">
                    <div>
                        <div class="text-center">
                            <img class="avatar img-circle img-thumbnail wd-12r"
                                 src="https://icons.iconarchive.com/icons/paomedia/small-n-flat/1024/book-icon.png"
                                 alt="avatar">
                            <h6 class="mt-3">
                                <spring:message code="edit-book.hardcover.change"/>
                            </h6>
                        </div>

                        <spring:bind path="hardcoverFile">
                            <div class="form-group">
                                <div class="input-group">
                                    <div class="custom-file">
                                        <form:input path="hardcoverFile"
                                                    type="file"
                                                    class="custom-file-input ${status.error ? 'is-invalid' : ''}"
                                                    id="book-hardcover"/>
                                        <label class="custom-file-label overflow-hidden"
                                               for='book-hardcover'>${bookForm.hardcoverFile.originalFilename}</label>
                                    </div>
                                </div>
                                <div class="text-danger text-center">
                                    <form:errors path="hardcoverFile"/>
                                </div>
                            </div>
                        </spring:bind>
                    </div>

                    <hr>
                    <br>

                </div>

<%--                Right Column--%>
                <div class="col-sm-9">
                    <!-- Title -->
                    <div class="col-sm w-100">
                        <div class="w-50 fl-left">
                            <h1><spring:message code="book-info.title"/></h1>
                        </div>
                        <div class="w-50 fl-left">
                            <a href="${contextPath}/book/${bookForm.id}">
                                <button type="button" class="btn btn-danger mt-2 float-right">
                                    <spring:message code="simple.btn.cancel"/>
                                </button>
                            </a>
                        </div>
                    </div>

                    <br><br>

                    <div class="tab-content">
                        <div class="tab-pane active" id="home">
                            <hr>

                           <spring:bind path="name">
                               <div class="form-group">
                                   <div class="col-xs-6">
                                       <label for="name"><h4>
                                           <spring:message code="book.form.title"/>
                                       </h4></label>
                                       <form:input path="name"
                                                   type="text"
                                                   class="form-control ${status.error ? 'is-invalid' : ''}"
                                                   id="name"/>
                                       <div class="text-danger text-center">
                                           <form:errors path="name"/>
                                       </div>
                                   </div>
                               </div>
                           </spring:bind>

                            <div class="form-group">
                                <label><h4>
                                    <spring:message code="book.form.author"/>
                                </h4></label>
                                <div class="form-row w-100">
                                    <spring:bind path="authorFirstName">
                                        <div class="col-xs-6 w-50">
                                            <form:input path="authorFirstName"
                                                        type="text"
                                                        class="form-control ${status.error ? 'is-invalid' : ''}"
                                                        id="author_first_name"/>
                                            <div class="text-danger text-center">
                                                <form:errors path="authorFirstName"/>
                                            </div>
                                        </div>
                                    </spring:bind>

                                    <spring:bind path="authorLastName">
                                        <div class="col-xs-6 w-50">
                                            <form:input path="authorLastName"
                                                        type="text"
                                                        class="form-control ${status.error ? 'is-invalid' : ''}"
                                                        id="author_last_name"/>
                                            <div class="text-danger text-center">
                                                <form:errors path="authorLastName"/>
                                            </div>
                                        </div>
                                    </spring:bind>
                                </div>
                            </div>

                            <spring:bind path="publisher">
                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label for="publisher"><h4>
                                            <spring:message code="book.form.publisher"/>
                                        </h4></label>
                                        <form:input path="publisher"
                                                    type="text"
                                                    class="form-control ${status.error ? 'is-invalid' : ''}"
                                                    id="publisher"/>
                                        <div class="text-danger text-center">
                                            <form:errors path="publisher"/>
                                        </div>
                                    </div>
                                </div>
                            </spring:bind>

                            <spring:bind path="publicationYear">
                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label for="publication-year"><h4>
                                            <spring:message code="book.form.publication-year"/>
                                        </h4></label>
                                        <form:input path="publicationYear"
                                                    type="number"
                                                    class="form-control ${status.error ? 'is-invalid' : ''}"
                                                    id="publication-year"/>
                                        <div class="text-danger text-center">
                                            <form:errors path="publicationYear"/>
                                        </div>
                                    </div>
                                </div>
                            </spring:bind>

                            <spring:bind path="numberOfPages">
                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label for="pages"><h4>
                                            <spring:message code="book.form.num-pages"/>
                                        </h4></label>
                                        <form:input path="numberOfPages"
                                                    type="number"
                                                    class="form-control ${status.error ? 'is-invalid' : ''}"
                                                    id="pages"/>
                                        <div class="text-danger text-center">
                                            <form:errors path="numberOfPages"/>
                                        </div>
                                    </div>
                                </div>
                            </spring:bind>

                            <spring:bind path="language">
                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label for="language"><h4>
                                            <spring:message code="book.form.language"/>
                                        </h4></label>
                                        <form:input path="language"
                                                    type="text"
                                                    class="form-control ${status.error ? 'is-invalid' : ''}"
                                                    id="language"/>
                                        <div class="text-danger text-center">
                                            <form:errors path="language"/>
                                        </div>
                                    </div>
                                </div>
                            </spring:bind>

                            <spring:bind path="description">
                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label for="description"><h4>
                                            <spring:message code="book.form.description"/>
                                        </h4></label>
                                        <form:input path="description"
                                                    type="text"
                                                    class="form-control ${status.error ? 'is-invalid' : ''}"
                                                    id="description"/>
                                        <div class="text-danger text-center">
                                            <form:errors path="description"/>
                                        </div>
                                    </div>
                                </div>
                            </spring:bind>

                            <spring:bind path="bookFile">
                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label><h4>
                                            <spring:message code="book.form.book-file"/>
                                        </h4></label>
                                        <div class="input-group">
                                            <div class="custom-file">
                                                <form:input path="bookFile"
                                                            type="file"
                                                            class="custom-file-input ${status.error ? 'is-invalid' : ''}"
                                                            id="inputGroupFile01"/>
                                                <label class="custom-file-label overflow-hidden" for="inputGroupFile01">
                                                    ${bookForm.bookFile.originalFilename}
                                                </label>
                                            </div>
                                        </div>
                                        <div class="meta">
                                            <a><spring:message code="add-book.form.book-file.warning"/></a>
                                        </div>
                                        <div class="text-danger text-center">
                                            <form:errors path="bookFile"/>
                                        </div>
                                    </div>
                                </div>
                            </spring:bind>


                            <div class="form-group">
                                <div class="col-xs-12">
                                    <br>
                                    <button class="btn btn-lg btn-success" type="submit">
                                        <spring:message code="simple.btn.save"/>
                                    </button>
                                    <button class="btn btn-lg" type="reset" onclick="location.reload()">
                                        <spring:message code="simple.btn.reset"/>
                                    </button>
                                </div>
                            </div>

                            <hr>
                        </div>

                    </div>
                    <!--/tab-pane-->
                </div>
                <!--/tab-content-->

            </div>
            <!--/col-9-->

        </form:form>
    </div>
    <!--/row-->


    <jsp:include page="footer.jsp"/>

</body>

</html>