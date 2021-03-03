<%--
  Created by IntelliJ IDEA.
  User: PRG
  Date: 2021/2/26
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="skill/add" method="post">
        <div>
            名称<input type="text" name="name">
        </div>
        <div>
            描述<input type="text" name="intro">
        </div>
        <div>
            等级<input type="text" name="my_level">
        </div>
        <div>
            <button type="submit">添加</button>
        </div>
    </form>
</body>
</html>
