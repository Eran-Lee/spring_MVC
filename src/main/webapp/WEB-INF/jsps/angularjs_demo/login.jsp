<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>angularjs实验</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/main.css" type="text/css" />
<script src="<%=request.getContextPath()%>/resources/js/angular.js"></script>
</head>
<body ng-app="myApp">
    <div>
        <ul id="loginForm" ng-controller="LoginForm">
            <li>用户名：<input type="text" name="uname" ng-model="uname" /></li>
            <li>密　码：<input type="password" name="pword" ng-model="pword" /></li>
            <li id="loginBtn"><input type="button" value="提交" ng-click="submit()"/> <input type="button" value="重置" ng-click="resetInfo()"/></li>
        </ul>
    </div>

<script>
angular.module("myApp", []).controller("LoginForm", function($scope,$http) {

    $scope.resetInfo=function()
    {
        $scope.uname="";
        $scope.pword="";
    }

    $scope.submit=function()
    {
        var postData = "?uname="+$scope.uname+"&"+"pword="+$scope.pword;
        var url = "login" + postData;

        $http.post(url).success(function(data)
        {
            alert(JSON.stringify(data));
        });

    }

});
</script>
</body>
</html>