<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset='utf-8'>
    <title><spring:message code="project.name"/> | <spring:message code="books.title"/></title>

    <jsp:include page="libs.jsp"/>
</head>

<body class="body">

    <c:import url="/nav-bar"/>

    <div class="container mt-2 marg-b-5">
        <div class="row justify-content-center">
        <div class="col-md-6">
        <div class="card">
        <header class="card-header">
            <h4 class="card-title mt-2">
                <spring:message code="add-book.new-book"/>
            </h4>
        </header>
        <article class="card-body">
        <form:form id="add-book" modelAttribute="bookForm" method="POST" enctype="multipart/form-data" action="add-book">

            <spring:bind path="hardcoverFile">
                <div class="form-group">
                    <label>
                        *<spring:message code="book.form.hardcover"/>
                    </label>
                    <div class="input-group">
                        <div class="custom-file">
                            <form:input path="hardcoverFile"
                                        type="file"
                                        id="hardcover-file"
                                        class="custom-file-input ${status.error ? 'is-invalid' : ''}" />
                            <label class="custom-file-label" for="hardcover-file">
                                <spring:message code="book.form.input.hardcover"/>
                            </label>

                        </div>
                    </div>
                    <div class="meta">
                        <a><spring:message code="add-book.form.hardcover.warning"/></a>
                    </div>
                    <div class="text-danger text-center">
                        <form:errors path="hardcoverFile"/>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="name">
                <div class="form-group">
                    <label>
                        *<spring:message code="book.form.title"/>
                    </label>
                    <form:input path="name"
                                type="text"
                                class="form-control ${status.error ? 'is-invalid' : ''}"/>
                    <div class="text-danger text-center">
                        <form:errors path="name"/>
                    </div>
                </div> <!-- form-group end.// -->
            </spring:bind>

                <div class="form-row">
                    <spring:bind path="authorFirstName">
                        <div class="col form-group">
                            <label>
                                *<spring:message code="book.form.author.first-name"/>
                            </label>
                            <form:input path="authorFirstName"
                                        type="text"
                                        class="form-control ${status.error ? 'is-invalid' : ''}"
                                        value="${authorFirstNamePrediction}"/>
                            <div class="text-danger text-center">
                                <form:errors path="authorFirstName"/>
                            </div>
                        </div> <!-- form-group end.// -->
                    </spring:bind>

                    <spring:bind path="authorLastName">
                        <div class="col form-group">
                            <label>
                                *<spring:message code="book.form.author.last-name"/>
                            </label>
                            <form:input path="authorLastName"
                                        type="text"
                                        class="form-control ${status.error ? 'is-invalid' : ''}"
                                        value="${authorLastNamePrediction}"/>
                            <div class="text-danger text-center">
                                <form:errors path="authorLastName"/>
                            </div>
                        </div> <!-- form-group end.// -->
                    </spring:bind>
                </div> <!-- form-row end.// -->

            <spring:bind path="publisher">
                <div class="form-group">
                    <label>
                        <spring:message code="book.form.publisher"/>
                    </label>
                    <form:input path="publisher"
                                type="text"
                                class="form-control ${status.error ? 'is-invalid' : ''}"/>
                    <div class="text-danger text-center">
                        <form:errors path="publisher"/>
                    </div>
                </div> <!-- form-group end.// -->
            </spring:bind>

            <spring:bind path="publicationYear">
                <div class="form-group">
                    <label>
                        <spring:message code="book.form.publication-year"/>
                    </label>
                    <form:input path="publicationYear"
                                class="form-control ${status.error ? 'is-invalid' : ''}"
                                type="number"/>
                    <div class="text-danger text-center">
                        <form:errors path="publicationYear"/>
                    </div>
                </div> <!-- form-group end.// -->
            </spring:bind>

            <spring:bind path="numberOfPages">
                <div class="form-group">
                    <label>
                        <spring:message code="book.form.num-pages"/>
                    </label>
                    <form:input path="numberOfPages"
                                class="form-control ${status.error ? 'is-invalid' : ''}"
                                type="number"/>
                    <div class="text-danger text-center">
                        <form:errors path="numberOfPages"/>
                    </div>
                </div> <!-- form-group end.// -->
            </spring:bind>

            <spring:bind path="language">
                <div class="form-group">
                    <label>
                        <spring:message code="book.form.language"/>
                    </label>
                    <form:input path="language"
                                class="form-control ${status.error ? 'is-invalid' : ''}"
                                type="text"/>
                    <div class="text-danger text-center">
                        <form:errors path="language"/>
                    </div>
                </div> <!-- form-group end.// -->
            </spring:bind>

            <spring:bind path="description">
                <div class="form-group">
                    <label>
                        <spring:message code="book.form.description"/>
                    </label>
                    <form:input path="description"
                                class="form-control ${status.error ? 'is-invalid' : ''}"
                                type="text"/>
                    <div class="text-danger text-center">
                        <form:errors path="description"/>
                    </div>
                </div> <!-- form-group end.// -->
            </spring:bind>

            <spring:bind path="bookFile">
                <div class="form-group">
                    <label>
                        *<spring:message code="book.form.book-file"/>
                    </label>
                    <div class="input-group">
                        <div class="custom-file">
                            <form:input path="bookFile"
                                        type="file"
                                        class="custom-file-input ${status.error ? 'is-invalid' : ''}"
                                        id="inputGroupFile01"/>
                            <label class="custom-file-label overflow-hidden" for="inputGroupFile01">
                                <spring:message code="book.form.input.book-file"/>
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
            </spring:bind>

            <small class="form-text text-muted mb-2">
                * - <spring:message code="book.form.required-fields"/>
            </small>

            <div class="form-group">
                <button type="submit" class="btn btn-lg btn-success btn-block btn-signin">
                    <spring:message code="book.form.btn.add-book"/>
                </button>
            </div>
        </form:form>
        </article>
        </div>
        </div>
        
        </div>
    </div> 
    <!--container end.//-->

    <jsp:include page="footer.jsp"/>

</body>

</html>