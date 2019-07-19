<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="css/login.css" rel="stylesheet" type="text/css">
<title>Login!</title>

</head>
<body>
 <%@include file="header.jsp" %>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-8">
            <img src="https://unsplash.imgix.net/photo-1421986527537-888d998adb74?w=1024&amp;q=50&amp;fm=jpg&amp;s=e633562a1da53293c4dc391fd41ce41d" class="img-responsive">
          </div>
          <div class="col-md-4">
            <br>
            <br>
            <h4 class="text-center">HappyStory</h4>
            <br>
            <br>
            <br>
            <form class="form-horizontal" role="form" method="post" action="<c:url value="/login"/>">
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputEmail3" class="control-label">ID</label>
                </div>
                <div class="col-sm-10">
                <c:if test="${id ==null}">
                  <input type="text" class="form-control" id="inputEmail3" placeholder="ID" name="id">
                 </c:if>
                 <c:if test="${id !=null}">
                  <input type="text" class="form-control" id="inputEmail3" placeholder="ID" name="id" value="${id }">
                 </c:if>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputPassword3" class="control-label">Password</label>
                </div>
                <div class="col-sm-10">
                  <input type="password" class="form-control" id="inputPassword3" placeholder="Password" name="password">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                  <div class="checkbox">
                    <label>
                      <input type="checkbox" name = "checkbox" value="true">Remember me</label>
                  </div>
                </div>
              </div>
              <div class="form-group">
                <div class="text-right">
                  <button type="submit" class="btn btn-default">Login</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <button type="button" class="btn btn-default" onclick="location.href='<c:url value="/main"/>'">Cancel</button>
                </div>
              </div>
              <br><br>
              <div class="col-sm-4"></div>
              <div class="col-sm-5" ><a href="<c:url value="/forgotPassword"/>"><span style="color:blue">Forgot Password?</span></a></div>
            </form>
          </div>
        </div>
      </div>
    </div>
<%@include file="footer.jsp" %>
</body>
</html>