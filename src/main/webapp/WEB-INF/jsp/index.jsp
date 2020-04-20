<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>Library</title>

    <jsp:include page="libs.jsp"/>
</head>
<body class="body text-center">
  
    <!-- Navigation bar -->
    <c:import url="/nav-bar"/>

    
    <!-- Welcome message -->
    <div id="cov-cont" class="cover-container d-flex h-100 p-3 mx-auto flex-column marg-b-5">
    
        <main role="main" class="inner cover">
          <h1 class="cover-heading">Welcome to Library</h1>
          <p class="lead">Read. Write. Share.</p>
          <p class="lead">
              <c:if test="${empty username}">
                  <a href="${contextPath}/registration"
                     class="btn btn-lg btn-secondary">Sign Up now</a>
              </c:if>
          </p>
        </main>
  
      </div>

    
    <!-- Footer -->
    <jsp:include page="footer.jsp"/>

</body>
</html>