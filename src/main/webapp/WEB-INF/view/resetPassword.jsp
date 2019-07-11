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
        <link href="css/signup.css" rel="stylesheet" type="text/css">
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
                                    <li class="divider"></li>
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
        <div class="section">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <form:form commandName="memberVO" class="form-horizontal" role="form"  method="post">
                        <h3 class="text-center">Set your new password!</h3><br><br>
                            <div class="form-group has-feedback"><div class="col-sm-2"><label for="inputEmail3" class="control-label">Password</label></div>
                                
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                                   <span style="color:red"><form:errors path="password" /> </span>
                                </div>
                            </div><br>
                          
                            <div class="form-group">
                                <div class="col-sm-10 col-sm-offset-2 text-right">
                                    <button type="submit" class="active btn btn-success">Done</button>
                                    <button  type="button" class="active btn btn-default" onclick="location.href='<c:url value="/main"/>'">Cancel</button>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
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
                            <div class="col-md-12 hidden-lg hidden-md hidden-sm text-left">
                                <a href="#"><i class="fa fa-3x fa-fw fa-instagram text-inverse"></i></a>
                                <a href="#"><i class="fa fa-3x fa-fw fa-twitter text-inverse"></i></a>
                                <a href="#"><i class="fa fa-3x fa-fw fa-facebook text-inverse"></i></a>
                                <a href="#"><i class="fa fa-3x fa-fw fa-github text-inverse"></i></a>
                            </div>
                        </div>
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
    
</body>
</html>