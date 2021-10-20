<%@ page import="com.example.pojo.Product" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: allis
  Date: 2021/10/13
  Time: 下午 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getScheme() + "://" +
            request.getServerName() + ":" +
            request.getServerPort() + request.getContextPath() + "/";
%>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>商品管理</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<jsp:include page="../../static/navbar.jsp"/>
<div class="container mt-4">
    <a href="<%=path%>pages/manager/book_edit.jsp?method=add" class="btn-primary d-inline-block btn">新增商品</a>
    <div class="clearfix"></div>
    <table class="table table-striped mt-3">
        <thead>
        <tr>
            <td>名稱</td>
            <td>價格</td>
            <td>資訊</td>
            <td>銷售數量</td>
            <td>庫存數量</td>
            <td class="col-2">編輯</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.products}" var="item">
            <tr>
                <td>${item.name}</td>
                <td>$${item.price}</td>
                <td>${item.note}</td>
                <td>${item.sales}</td>
                <td>${item.stock}</td>
                <td class="">
                    <a class="btn btn-primary d-inline" href="<%=path%>manage/productServlet?action=getProduct&id=${item.id}&method=update">修改</a>
                    <a class="btn btn-primary d-inline deleteClass"
                       href="<%=path%>manage/productServlet?action=delete&id=${item.id}">刪除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<script type="text/javascript">
    $(function () {
        $("a.deleteClass").click(function () {
            console.log("test hello")
            var str = $(this).parent().parent().find("td:first").text();
            return confirm("確定刪除" + str + "?");
        });
    });
</script>
</body>
</html>