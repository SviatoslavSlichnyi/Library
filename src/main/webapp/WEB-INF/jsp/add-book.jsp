<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset='utf-8'>
    <title>Library | Add Book</title>

    <jsp:include page="libs.jsp"/>
</head>
<body class="body">
    
    <jsp:include page="navbar.jsp"/>

    <div class="container mt-2 marg-b-5">
        <div class="row justify-content-center">
        <div class="col-md-6">
        <div class="card">
        <header class="card-header">
            <h4 class="card-title mt-2">New Book</h4>
        </header>
        <article class="card-body">
        <form:form id="add-book" modelAttribute="bookForm" method="POST" enctype="multipart/form-data" action="add-book">

            <spring:bind path="hardcoverFile">
                <div class="form-group">
                    <div class="input-group">
                        <div class="custom-file">
                            <form:input path="hardcoverFile"
                                        type="file"
                                        id="hardcover-file"
                                        class="custom-file-input ${status.error ? 'is-invalid' : ''}" />
                            <label class="custom-file-label" for="hardcover-file">Upload book hardcover</label>

                        </div>
                    </div>
                    <div class="meta">
                        <a>Use only .png or .jpeg types of file.</a>
                    </div>
                    <div class="text-danger text-center">
                        <form:errors path="hardcoverFile"/>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="name">
                <div class="form-group">
                    <label>Name</label>
                    <form:input path="name"
                                type="text"
                                class="form-control ${status.error ? 'is-invalid' : ''}"
                                value="Inferno"/>
                    <div class="text-danger text-center">
                        <form:errors path="name"/>
                    </div>
                </div> <!-- form-group end.// -->
            </spring:bind>

                <div class="form-row">
                    <spring:bind path="authorFirstName">
                        <div class="col form-group">
                            <label>Author first name </label>
                            <form:input path="authorFirstName"
                                        type="text"
                                        class="form-control ${status.error ? 'is-invalid' : ''}"
                                        value="Dan"/>
                            <div class="text-danger text-center">
                                <form:errors path="authorFirstName"/>
                            </div>
                        </div> <!-- form-group end.// -->
                    </spring:bind>

                    <spring:bind path="authorLastName">
                        <div class="col form-group">
                            <label>Author last name</label>
                            <form:input path="authorLastName"
                                        type="text"
                                        class="form-control ${status.error ? 'is-invalid' : ''}"
                                        value="Brawn"/>
                            <div class="text-danger text-center">
                                <form:errors path="authorLastName"/>
                            </div>
                        </div> <!-- form-group end.// -->
                    </spring:bind>
                </div> <!-- form-row end.// -->

            <spring:bind path="publisher">
                <div class="form-group">
                    <label>Publisher</label>
                    <form:input path="publisher"
                                type="text"
                                class="form-control ${status.error ? 'is-invalid' : ''}"
                                value="Book-Ye"/>
                    <div class="text-danger text-center">
                        <form:errors path="publisher"/>
                    </div>
                </div> <!-- form-group end.// -->
            </spring:bind>

            <spring:bind path="publicationYear">
                <div class="form-group">
                    <label>Publication year</label>
                    <form:input path="publicationYear"
                                class="form-control ${status.error ? 'is-invalid' : ''}"
                                type="number"
                                value="2018"/>
                    <div class="text-danger text-center">
                        <form:errors path="publicationYear"/>
                    </div>
                </div> <!-- form-group end.// -->
            </spring:bind>

            <spring:bind path="numberOfPages">
                <div class="form-group">
                    <label>Number of pages</label>
                    <form:input path="numberOfPages"
                                class="form-control ${status.error ? 'is-invalid' : ''}"
                                type="number"
                                value="606"/>
                    <div class="text-danger text-center">
                        <form:errors path="numberOfPages"/>
                    </div>
                </div> <!-- form-group end.// -->
            </spring:bind>

            <spring:bind path="language">
                <div class="form-group">
                    <label>Language</label>
                    <form:input path="language"
                                class="form-control ${status.error ? 'is-invalid' : ''}"
                                type="text"
                                value="English"/>
                    <div class="text-danger text-center">
                        <form:errors path="language"/>
                    </div>
                </div> <!-- form-group end.// -->
            </spring:bind>

            <spring:bind path="description">
                <div class="form-group">
                    <label>Description</label>
                    <form:input path="description"
                                class="form-control ${status.error ? 'is-invalid' : ''}"
                                type="text"
                                rows="5" cols="60"
                                value="Cool Book."/>
                    <div class="text-danger text-center">
                        <form:errors path="description"/>
                    </div>
                </div> <!-- form-group end.// -->
            </spring:bind>

            <spring:bind path="bookFile">
                <div class="form-group">
                    <label>Book file</label>
                    <div class="input-group">
                        <div class="custom-file">
                            <form:input path="bookFile"
                                        type="file"
                                        class="custom-file-input ${status.error ? 'is-invalid' : ''}"
                                        id="inputGroupFile01"
                                        aria-describedby="inputGroupFileAddon01"/>
                            <label class="custom-file-label overflow-hidden" for="inputGroupFile01">Upload Book</label>
                        </div>
                    </div>
                    <div class="meta">
                        <a>Use only .pdf, .epub or .txt types of file.</a>
                    </div>
                    <div class="text-danger text-center">
                        <form:errors path="bookFile"/>
                    </div>
                </div>
            </spring:bind>

            <div class="form-group">
                <button type="submit" class="btn btn-lg btn-success btn-block btn-signin">Add Book</button>
            </div> <!-- form-group// -->  
        </form:form>
        </article> <!-- card-body end .// -->
        </div> <!-- card.// -->
        </div> <!-- col.//-->
        
        </div> <!-- row.//-->
    </div> 
    <!--container end.//-->

    <jsp:include page="footer.jsp"/>

</body>
</html>