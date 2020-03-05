<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/12/10
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>显示</title>
</head>
<style>
 #div1{margin: 0 auto;text-align: center}
 #div1  #table1{margin: 0 auto;text-align: center}
</style>
<body>
<div id="div1">
<h2>用户数据列表</h2>
<table border="1" width="100%" id="table1">
    <tr>
        <td colspan="7">
            <form id="form1" name="form1" method="post" action="ShowServlet">
                <!--保存页码  目的是带条件提交表单传页码-->
                <input type="hidden" name="page" id="setPage" value="1">
                卡种分类 :
                    <select name="type" id="select">
                        <option value="">全部</option>
                        <c:forEach items="${typeList}" var="n">
                        <option ${param.type==n.cardId?"selected":""} value="${n.cardId}">${n.cardName}</option>
                        </c:forEach>
                    </select>
                姓名 :
                    <input type="text" name="name" id="textfield" value="${param.name}"/>
                    <input type="submit" name="button" id="button" value="查询"/>
                <a href="GoAddServlet">添加账户</a>
            </form>
        </td>
    </tr>
    <tr>
        <td>账户编号</td>
        <td>姓名</td>
        <td>详细地址</td>
        <td>开户日期</td>
        <td>卡种</td>
        <td>删除</td>
        <td>修改</td>
    </tr>
    <c:forEach items="${list}" var="t">
    <tr>
        <td>${t.userNum}</td>
        <td>${t.userName}</td>
        <td>${t.userAddr}</td>
        <td>${t.createDate}</td>
        <td>${t.cardName}</td>
        <td><a href="GetServlet?id=${t.userId} ">修改</a></td>
        <td><a href="DeleteServlet?id=${t.userId}">删除</a></td>
    </tr>
    </c:forEach>
<tr>
    <td colspan="7">
        <a href="javascript:go(1)">首页</a>
        <a href="javascript:go(${curPage==1?1:curPage-1})">上一页</a>
        <a href="javascript:go(${curPage==totalPage?totalPage:curPage+1})">下一页</a>

        <%--跳转指定页面--%>
        <input type="text" name="p" id="p" value="${curPage}">
        <input type="button" name="but" id="but" onclick="go(this.previousElementSibling.value)" value="GO">

        <a href="javascript:go(${totalPage})">尾页</a>
        第${curPage}页/共${totalPage}页
    </td>
</tr>
</table>
</div>
<script language="JavaScript" type="text/javascript">
    //编写条件分页实现
    function go(page) {  //页码
        //给表单设置页码
        document.getElementById("setPage").value = page;
        //提交表单
        document.getElementById("form1").submit();
    }
</script>

</body>
</html>