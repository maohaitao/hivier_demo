<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>香蕉打卡 - 后台管理系统</title>
    <%@include file="pages/header.html" %>
</head>
<body ng-app="bananaApp" ng-controller="appCtrl" ng-init="setContextPath('${pageContext.request.contextPath}')">
<div ng-if="!isAuthorized" style="height: 100%" ng-include="'pages/login.html'">
</div>
<div ng-if="isAuthorized" style="height: 100%" ng-include="'pages/main.html'">
</div>
</body>
<%@include file="pages/footer.html" %>
</html>