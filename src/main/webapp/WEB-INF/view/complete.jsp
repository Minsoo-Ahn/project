<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<title>Congratulation</title>
<script>
alert("You have been successfully signed up. Thank you for your attentions.");
location.href='<c:url value="/main"/>';
</script>
</head>
<body>

</body>
</html>