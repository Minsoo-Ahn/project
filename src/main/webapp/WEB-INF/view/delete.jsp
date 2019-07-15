<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/write.css" rel="stylesheet" type="text/css">
 <script type="text/javascript" src="js/write.js"></script>

</head>
<body>
<form action="<c:url value="/write"/>" method="post" enctype="multipart/form-data" class="form-inline" role="form">
<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close" aria-hidden="true">×</button>
    <h3 class="smaller lighter blue no-margin modal-title">Add new story</h3>
</div>
 
<div class="modal-body">
    <textarea id ="mytext" class="form-control" style="resize:none" cols="80" rows="2" placeholder="What's on your mind?" name="content"></textarea><br><br>
<div class="fileBox">
	<input type="text" class="fileName" name="image" readonly="readonly">
	<label for="uploadBtn" class="btn_file" >Upload!</label>
	<input type="file" name="fileName" id="uploadBtn" class="uploadBtn">
</div>
</div>

<div class="modal-footer">
    <button type="reset" class="btn btn-sm btn-warning" id="testDel">
        Reset
    </button>
    <button type ="submit" class="btn btn-sm btn-success" id="testSave">
       <i class="ace-icon fa fa-angellist"></i> Save
    </button>
    <button class="btn btn-sm btn-danger pull-right" data-dismiss="modal" id="btnClose">
        <i class="ace-icon fa fa-times"></i>Close
    </button>
</div>
</form>
</body>
</html>