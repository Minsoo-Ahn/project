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
<title>Insert title here</title>
</head>
<body>
<form action="<c:url value="/main" />" method="post" class="form-inline" role="form">
      <div class="section">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="jumbotron">
                            <h1>Welcome to My SNS</h1>
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
                                <a data-toggle="modal" href="<c:url value="/write"/>" data-target="#modal-testNew" role="button" data-backdrop="static" >Write</a>
                            <div id="modal-testNew" class="modal fade" tabindex="-1" role="dialog" >
						    <div class="modal-dialog" style="width:700px;height:1000px">
						    <div class="modal-content"></div></div></div>

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
                                        <a href="#">One more separated link</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </div><br>
        <div class="col-md-8"></div><div class=" col-md-4 text-left">
        <input type="text" class="form-control" name ="search" placeholder="Search your friends"><button class="btn btn-default btn-xs" type="submit"><img alt="search" src="img/search.jpg" width="30" height="30"></button></div>
        </div>
        <div class="col-md-6">
		</div>
		<button class="btn btn-default" onclick="history.go(0)">Refresh</button>
        <div class="container">
        <div class="section"><div class="container"><div class="row"><div class="col-md-3"><div class="col-md-12">  <h1>Friends list</h1> <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet.</p></div></div>
        
        <div class="col-md-7 text-center" style="white-space:pre;"><div class="col-md-12"> 
        <c:forEach var="board" items="${boardList }" varStatus="loop">
        <table class="table" style="margin-left: auto; margin-right: auto; margin-top: 15px;">
		<thead>
		<tr>
			<th><h4><strong>작성자 : ${board.id }</strong></h4></th>
		</tr>
		</thead>
		<tbody>
		<tr>
			<td class="text-left" colspan="2">${board.regDate }</td>
		</tr>
		<tr>
			<td class="text-left " colspan="2">${board.content }

		<c:if test="${board.image != null }">
			<img src="upload/${board.image }" width="400" height="300">
		</c:if>
			</td>
		</tr>
		<tr>
			<td class="text-left"><button class="btn btn-default"><img alt="like" src="img/like.png" width="20" height="20"><strong>${board.num }</strong></button></td>
			<td class="text-right"><button class="btn btn-warning">수정</button>&nbsp;&nbsp;<button class="btn btn-danger">삭제</button></td>
		</tr>
		<tr>
		<td class="text-right" colspan="2">
			<textarea class="form-control" style="resize:none" cols="58" rows="1" placeholder="Write a commnet..." name="comment"></textarea>&nbsp;&nbsp;<button class="btn btn-default">Send</button></td>
		</tr>
		</tbody>
       </table>
       <hr>
	</c:forEach>
        </div></div><div class="row"> </div></div></div></div></div>
        
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
    
</form>
</body>
</html>