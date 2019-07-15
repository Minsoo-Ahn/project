<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


</head>
<body>
<form action="<c:url value="/edit"/>" method="post" enctype="multipart/form-data" class="form-inline" role="form">
<div class="col-sm-6">
<h5>Enter your password</h5>
<input type="password" placeholder="password" name="password" class="form-control"><button class="btn btn-default" type="submit">Send</button>
</div>
</form>
</body>
</html>