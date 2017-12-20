<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2017/12/17
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>创建用户账号</title>
</head>
<body>
<div class="head"></div>
<div class="main">
    <form action="/accountInfo/saveAccountInfo">
        <table>
            <tr>
                <td>账号</td>
                <td><input type="text" id="account" name="account" placeholder="请输入6-16位数字字母组合账号" maxlength="16"/></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" id="email" name="email" placeholder="请输入账号安全邮箱" maxlength="16"/></td>
            </tr>
            <tr>
                <td>安全问题</td>
                <td><input type="text" id="securityQues" name="securityQues" placeholder="请输入账号安全问题" maxlength="16"/></td>
            </tr>
            <tr>
                <td>安全问题答案</td>
                <td><input type="text" id="securityAns" name="securityAns" placeholder="请输入账号安全问题" maxlength="16"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="添加用户"/>
                    <input type="reset" value="重置"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
