<%--
  Created by IntelliJ IDEA.
  User: Abyss
  Date: 2018/5/3
  Time: 下午4:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登出页面</title>
</head>
<body>
<%
    session.invalidate();
%>
<h3>已登出</h3>
</body>
</html>
