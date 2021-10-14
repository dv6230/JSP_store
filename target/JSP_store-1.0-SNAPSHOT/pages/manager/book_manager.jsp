<%--
  Created by IntelliJ IDEA.
  User: allis
  Date: 2021/10/13
  Time: 下午 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
</head>
<body>
<jsp:include page="../../static/navbar.jsp"/>
<div class="container mt-4">
        <a href="#" class="btn-primary d-inline-block btn">新增商品</a>
    <div class="clearfix"></div>
    <table class="table table-striped mt-3">
        <thead>
        <tr>
            <td>名稱</td>
            <td>價格</td>
            <td>資訊</td>
            <td>銷售數量</td>
            <td>庫存數量</td>
            <td colspan="2">編輯</td>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>資訊概論</td>
            <td>$1200</td>
            <td>unknown</td>
            <td>150</td>
            <td>300</td>
            <td><a href="book_edit.jsp">修改</a></td>
            <td><a href="#">删除</a></td>
        </tr>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>