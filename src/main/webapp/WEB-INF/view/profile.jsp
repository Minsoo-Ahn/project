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
<title>Insert title here</title>
</head>
<body>
       <div class="section">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="jumbotron">
                            <h1>Hello, world!</h1>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <ul class="nav nav-justified nav-pills">
                            <li class="active">
                                <a href="<c:url value="/main"/>">Home</a>
                            </li>
                            <li class="active">
                                <a href="#">Profile</a>
                            </li>
                            <li class="active">
                                <a href="#">Messages</a>
                            </li>
                            <li class="active">
                                <a href="#">Contact us</a>
                            </li>
                            <li class="active dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <i class="fa fa-border fa-caret-down fa-fw pull-right text-muted"></i></a>
                                <ul class="dropdown-menu" role="menu">
                                                   <li>
				                      <a href="<c:url value="/signup"/>">Sign up</a>
				                  </li>
				                  <c:if test="${member == null }">
				                  <li>
				                      <a href="<c:url value="/login"/>">Login</a>
				                  </li>
				                  </c:if>
				                  <c:if test="${member != null }">
				                  <li>
				                      <a href="<c:url value="/logout"/>">Logout</a>
				                  </li>
				                  <li class="divider"></li>
				                  <li>
				                      <a href="<c:url value="/accountSetting"/>">Account Setting</a>
				                  </li>
				                  </c:if>
				                  <li class="divider"></li>
				                  <li>
                                    <li>
                                        <a href="#">One more separated link</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
                
            </div>
        </div>
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
        <footer class="section section-primary">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <h1>Footer header</h1>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisici elit,
                            <br>sed eiusmod tempor incidunt ut labore et dolore magna aliqua.
                            <br>Ut enim ad minim veniam, quis nostrud</p>
                    </div>
                    <div class="col-sm-6">
                        <p class="text-info text-right">
                            <br>
                            <br>
                        </p>
                        
                        <div class="row">
                            <div class="col-md-12 hidden-xs text-right">
                                <a href="#"><i class="fa fa-3x fa-fw fa-instagram text-inverse"></i></a>
                                <a href="#"><i class="fa fa-3x fa-fw fa-twitter text-inverse"></i></a>
                                <a href="#"><i class="fa fa-3x fa-fw fa-facebook text-inverse"></i></a>
                                <a href="#"><i class="fa fa-3x fa-fw fa-github text-inverse"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
  	</form>
    
</body>
<script>

</script>
</html>