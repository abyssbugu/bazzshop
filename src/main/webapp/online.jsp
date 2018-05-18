<%--
  Created by IntelliJ IDEA.
  User: Abyss
  Date: 2018/5/3
  Time: 下午4:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>在线人数</title>
</head>
<body>
<h3>在线人数为${onlineNum}人</h3>
<a href="${pageContext.request.contextPath}/logout.jsp">退出</a>
<%! int a=0;%>     <% int b=0; a++; b++; %> a=<%=a%><br/> b=<%=b%>
</body>
</html>
