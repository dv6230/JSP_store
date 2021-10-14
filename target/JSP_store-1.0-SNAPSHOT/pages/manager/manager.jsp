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
    <title>Hello, world!</title>
</head>
<body>
<jsp:include page="../../static/navbar.jsp"/>
<div class="container">
    <h2 class="p-3">
        管理系統頁面
    </h2>
    <a href="book_manager.jsp" class="d-block m-2">商品管理</a>
    <a href="order_manager.jsp" class="d-block m-2">訂單管理</a>
    <a href="../../index.jsp" class="d-block m-2">返回首頁</a>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</body>
</html>

