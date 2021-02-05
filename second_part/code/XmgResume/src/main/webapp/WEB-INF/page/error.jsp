<%--
  Created by IntelliJ IDEA.
  User: PRG
  Date: 2021/2/1
  Time: 2:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setAttribute("ctx", request.getContextPath()); %>
<html>
<head>
    <title>小码哥教育-Error</title>
    <%@include file="admin/common/style.jsp"%>
</head>
<body class="five-zero-zero">
<div class="five-zero-zero-container">
    <div class="error-title">喔豁，出错了</div>
    <div class="error-msg">${error}</div>
    <div class="button-place">
        <a href="#" class="btn btn-default btn-lg waves-effect">回到首页</a>
    </div>
</div>
</body>
</html>
