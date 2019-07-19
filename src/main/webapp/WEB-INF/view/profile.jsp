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
        <link href="css/signup.css" rel="stylesheet" type="text/css">
        <link href="css/profile.css" rel="stylesheet" type="text/css">
<title>Your profile</title>
</head>
<body>
 
<%@include file="header.jsp" %>
        <form action="<c:url value="/imageUpload"/>" method="post" enctype="multipart/form-data"  role="form">
        <div class="section">
            <div class="container">
                <div class="row">
                    <div class="col-md-4"></div>
                    <div class="col-md-7">
                    	<label for="imageUpload" >
                    	<c:if test="${member.image !=null }">
                    	<img src="uploads/${member.image }" height ="300" width="240">
                    	</c:if>
                    	</label><br>
                    	<input type="file" id="imageUpload" name="fileName" value="" hidden="true">
                    	<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Click the image to change a picture!</p>
                    	<button id="button" type="submit">button</button>
                    </div>
                </div>
        <br><hr><br>
       	<div class="col-sm-3"></div>
                    	<table>
                    	<tbody style="font-size:20px;">
                    		<tr>
                    			<th class="text-left" width="400" height="50">ID</th>
                    			<td></td>
                 			<td class="text-left">${member.id }</td>
                    		</tr>
                    		<tr>
                    			<th class="text-left" height="50">Name</th>
                    			<td></td>
                    			<td class="text-left">${member.name }</td>
                    		</tr>
                    		<tr>
                    			<th class="text-left" height="50">Phone</th>
                    			<td></td>
                    			
                    			<td class="text-left">${member.phone }</td>
                    		</tr>
                    		<tr>
                    			<th class="text-left" height="50">Email</th>
                    			<td></td>
                    			<td class="text-left">${member.email }</td>
                    		</tr>
                    	</tbody>
                    	</table>
            </div>
       	</div>
     <%@include file="footer.jsp"  %>
  	</form>
    
</body>
<script>

</script>
</html>