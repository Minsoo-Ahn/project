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
        <link href="css/main.css" rel="stylesheet" type="text/css">
<title>Friend request</title>
<script type="text/javascript">
</script>
</head>
<body>
<%@include file="header.jsp" %>
<form action="<c:url value="/main" />" method="post" class="form-inline" role="form">
<input type="text" id="like" value="${like }" hidden="true">

        <div class="col-md-6">
		</div>
		<button class="btn btn-default" onclick="history.go(0)">Refresh</button>
        <div class="container">
        <div class="section"><div class="container"><div class="row"><div class="col-md-3"><div class="col-md-12">  <h1>Friends list</h1> <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet.</p></div></div>
        
        <div class="col-md-7 text-center" style="white-space:pre;"><div class="col-md-12"> 
      <h4 class="text-center">Search List</h4>
         <table class="table" style="margin-left: auto; margin-right: auto; margin-top: 15px;">
         <thead>
         	<tr>
         		<td class="text-left">ID</td>  <td class="text-right">Request</td>
         	</tr>
         </thead>
        <c:forEach var="list" items="${pendingList }" varStatus="loop">
        <tr>
        <td class="text-left"><span style="color:blue">${list}</span></td><td class="text-right"><button class="btn btn-success btn-s" type="button" onclick="location.href='<c:url value="/pendingAccept/${list}"/>'">Accept</button>   <button class="btn btn-danger btn-s" type="button" onclick="location.href='<c:url value="/pendingReject/${list}"/>'">Reject</button></td>
        </c:forEach>
        </table>
        </div></div><div class="row"> </div></div></div></div></div>
        
<%@include file="footer.jsp" %>        
</form>
</body>
</html>