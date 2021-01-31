<%--
  Created by IntelliJ IDEA.
  User: PRG
  Date: 2021/1/25
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>客户列表</title>
    <style>
        th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<a href="page/add.html">添加</a>

<table>
    <thead>
    <tr>
        <th>姓名</th>
        <th>年龄</th>
        <th>身高</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${customers}" var="customer" varStatus="s">
        <tr>
            <td>${customer.name}</td>
            <td>${customer.age}</td>
            <td>${customer.height}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
