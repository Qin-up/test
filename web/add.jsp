<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.team.myproject.entity.Card" %>
<%@ page import="com.team.myproject.service.CardService" %>
<%@ page import="com.team.myproject.service.impl.CardServiceimpl" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/12/8
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加</title>
</head>
<style>
    #div1{margin: 0 auto;text-align: center}
    #div1  #table1{margin: 0 auto;text-align: center}
</style>
<body>
<%--添加--%>

<div id="div1">
    <h2>添加信息</h2>
    <table border="1" id="table1">
    <form action="AddServlet" method="post" name="form1" id="form1">
        <tr><td>账户编号:</td>
            <td><input type="text" name="num" id="title"></td>
        </tr>

        <tr><td>姓名:</td>
            <td><input type="text" name="name" id="textfield2"/></td>
        </tr>
        <tr><td>详细地址:</td>
            <td><input type="text" name="add" id="textarea"/></td>
        </tr>
        <tr><td>卡种:</td>
            <td>
                <select name="type" id="select">
                    <option value="">请选择</option>
                    <c:forEach items="${list}" var="t">
                        <option value="${t.cardId}">${t.cardName}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" name="button" id="button1" value="添加"/>
                <input type="reset" name="button" id="button2" value="重置"/>
            </td>
        </tr>

    </form>
    </table>
</div>
</body>
</html>
