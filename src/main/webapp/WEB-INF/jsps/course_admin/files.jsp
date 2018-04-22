<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>慕课网课程图片上传</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/main.css" type="text/css" />
</head>
<body>
	<div align="center">
		<h1>文件上传</h1>
		<form method="post" action="/course/doUpload" enctype="multipart/form-data">
			<input type="file" name="file">
			<input type="submit" />
		</form>
	</div>
</body>
</html>