<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>Library</title>

    <jsp:include page="libs.jsp"/>
</head>
<body class="body text-center">
  
    <!-- Navigation bar -->
    <jsp:include page="navbar.jsp"/>

    
    <!-- Welcome message -->
    <div id="cov-cont" class="cover-container d-flex h-100 p-3 mx-auto flex-column marg-b-5">
    
        <main role="main" class="inner cover">
          <h1 class="cover-heading">Welcome to Library</h1>
          <p class="lead">Read. Write. Share.</p>
          <p class="lead">
<%--            <a href="registration" class="btn btn-lg btn-secondary">Register now</a>--%>
          </p>
        </main>
  
      </div>

    
    <!-- Footer -->
    <jsp:include page="footer.jsp"/>

</body>
</html>