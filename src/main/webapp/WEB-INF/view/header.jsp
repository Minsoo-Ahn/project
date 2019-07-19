<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <div class="section">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="jumbotron">
                            <h1>HappyStory♣</h1>
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
                                <a href="<c:url value="/profile"/>">Profile</a>
                            </li>
                            <li class="active">
                                <a data-toggle="modal" href="<c:url value="/write"/>" data-target="#modal-testNew" role="button" data-backdrop="static" >Write</a>
                             <div id="modal-testNew" class="modal fade" tabindex="-1" role="dialog" >
						    <div class="modal-dialog" style="width:700px;height:1000px">
						    <div class="modal-content"></div></div></div>

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
        
	
</body>
</html>