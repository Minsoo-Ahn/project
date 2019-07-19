<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
        <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="../css/signup.css" rel="stylesheet" type="text/css">
<title>Input password</title>
</head>
<body>
      
<%@include file="header.jsp" %>         
        <div class="section">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <form class="form-horizontal" role="form"  method="post" action="<c:url value="/boardDelete"/>">
                        <h3 class="text-center">Enter your account password!</h3><br><br>
                            <div class="form-group has-feedback"><div class="col-sm-2"><label for="inputEmail3" class="control-label">Password</label></div>
                                
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                                  
                                </div>
                            </div><br>
                          <input type="text" name="seq" value="${seq }" hidden="true">
                            <div class="form-group">
                                <div class="col-sm-10 col-sm-offset-2 text-right">
                                    <button type="submit" class="active btn btn-success">Delete</button>
                                    <button  type="button" class="active btn btn-default" onclick="location.href='<c:url value="/main"/>'">Cancel</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
<%@include file="footer.jsp" %>       
    
</body>
</html>