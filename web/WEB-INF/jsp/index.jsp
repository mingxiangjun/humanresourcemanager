<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2017/12/17
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>系统首页</title>
    <script type="text/javascript" src="/js/index.js"></script>
    <script type="text/javascript" src="/js/jquery-1.7.2.min.js"></script>
</head>
<body>
    <input type="text" width="80px" id="msgKey" maxlength="16"/>
    <input type="text" width="80px" id="msgContent" maxlength="16"/>
    <a href="javascript:;" onclick="sendRedisMsg()">发送redis消息</a>
</body>
</html>
