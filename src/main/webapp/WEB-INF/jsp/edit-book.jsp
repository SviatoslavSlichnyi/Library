<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset='utf-8'>
    <title>Library | Edit Book</title>

    <jsp:include page="libs.jsp"/>
</head>

<body class="body">

    <jsp:include page="navbar.jsp"/>

    <div class="container bootstrap snippet marg-b-5">
        <form:form modelAttribute="bookForm" action="${pageContext.request.contextPath}/edit-book/${bookForm.id}"
                   class="form"  method="post" enctype="multipart/form-data">

            <div class="row mt-4">

<%--                Left Column--%>
                <div class="col-sm-3">
                    <div>
                        <div class="text-center">
                            <img class="avatar img-circle img-thumbnail wd-12r"
                                 src="https://icons.iconarchive.com/icons/paomedia/small-n-flat/1024/book-icon.png"
                                 alt="avatar">
                            <h6 class="mt-3">Change the hardcover...</h6>
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
                    <div class="col-sm-10">
                        <h1>Book</h1>
                    </div>

                    <div class="tab-content">
                        <div class="tab-pane active" id="home">
                            <hr>

                           <spring:bind path="name">
                               <div class="form-group">
                                   <div class="col-xs-6">
                                       <label for="name"><h4>Name</h4></label>
                                       <form:input path="name"
                                                   type="text"
                                                   class="form-control ${status.error ? 'is-invalid' : ''}"
                                                   id="name"
                                                   value="${book.name}"/>
                                       <div class="text-danger text-center">
                                           <form:errors path="name"/>
                                       </div>
                                   </div>
                               </div>
                           </spring:bind>

                            <div class="form-group">
                                <label><h4>Author</h4></label>
                                <div class="form-row w-100">
                                    <spring:bind path="authorFirstName">
                                        <div class="col-xs-6 w-50">
                                            <form:input path="authorFirstName"
                                                        type="text"
                                                        class="form-control ${status.error ? 'is-invalid' : ''}"
                                                        id="author_first_name"
                                                        value="${book.author.firstName}"/>
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
                                                        id="author_last_name"
                                                        value="${book.author.lastName}"/>
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
                                        <label for="publisher"><h4>Publisher</h4></label>
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
                                        <label for="publication-year"><h4>Publication year</h4></label>
                                        <form:input path="publicationYear"
                                                    type="number"
                                                    class="form-control ${status.error ? 'is-invalid' : ''}"
                                                    id="publication-year"
                                                    value="${book.publicationYear}"/>
                                        <div class="text-danger text-center">
                                            <form:errors path="publicationYear"/>
                                        </div>
                                    </div>
                                </div>
                            </spring:bind>

                            <spring:bind path="numberOfPages">
                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label for="pages"><h4>Number of pages</h4></label>
                                        <form:input path="numberOfPages"
                                                    type="number"
                                                    class="form-control ${status.error ? 'is-invalid' : ''}"
                                                    id="pages"
                                                    value="${book.numberOfPages}"/>
                                        <div class="text-danger text-center">
                                            <form:errors path="numberOfPages"/>
                                        </div>
                                    </div>
                                </div>
                            </spring:bind>

                            <spring:bind path="language">
                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label for="language"><h4>Language</h4></label>
                                        <form:input path="language"
                                                    type="text"
                                                    class="form-control ${status.error ? 'is-invalid' : ''}"
                                                    id="language"
                                                    value="${book.language}"/>
                                        <div class="text-danger text-center">
                                            <form:errors path="language"/>
                                        </div>
                                    </div>
                                </div>
                            </spring:bind>

                            <spring:bind path="description">
                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label for="description"><h4>Description</h4></label>
                                        <form:input path="description"
                                                    type="text"
                                                    class="form-control ${status.error ? 'is-invalid' : ''}"
                                                    id="description"
                                                    value="${book.description}"/>
                                        <div class="text-danger text-center">
                                            <form:errors path="description"/>
                                        </div>
                                    </div>
                                </div>
                            </spring:bind>

                            <spring:bind path="bookFile">
                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label><h4>Book file</h4></label>
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
                                            <a>Use only .pdf, .epub or .txt types of file.</a>
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
                                    <button class="btn btn-lg btn-success" type="submit">Save</button>
                                    <button class="btn btn-lg" type="reset" onclick="location.reload()">
                                        Reset
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