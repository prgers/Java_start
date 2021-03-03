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
    <form action="test" method="post">
        <div>
            名称<input type="text" name="name">
        </div>
        <div>
            描述<input type="text" name="intro">
        </div>
        <div>
            等级<input type="text" name="level">
        </div>

        <div>
            足球<input type="checkbox" value="1" name="hobby">
        </div>
        <div>
            篮球<input type="checkbox" value="2" name="hobby">
        </div>
        <div>
            台球<input type="checkbox" value="3" name="hobby">
        </div>
        <div>
            <button type="submit">添加</button>
        </div>
    </form>

    <div>
        <form action="test2" method="post" enctype="multipart/form-data">
            <input name="username">
            <input name="password">
            <button type="submit">提交</button>
        </form>
    </div>

    <div>
        <form action="test3" method="post" enctype="multipart/form-data">
            <input name="username">
            <input type="file" name="photo">
            <button type="submit">提交</button>
        </form>
    </div>

    <div>
        日期处理：
        <form action="test4" method="post">
            <input name="birthday" type="text">
            <button type="submit">提交</button>
        </form>
    </div>
</body>
</html>
