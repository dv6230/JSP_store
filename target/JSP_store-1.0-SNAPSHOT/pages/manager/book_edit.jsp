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
<%
    String path = request.getScheme() + "://" +
            request.getServerName() + ":" +
            request.getServerPort() + request.getContextPath() + "/";
%>
<div class="container">
    <form action="<%=path%>manage/productServlet" method="POST" class="col-md-5 mt-5 mb-5">
        <input hidden name="action" value="add">
        <div class="mb-3">
            <label for="name" class="form-label">商品名稱</label>
            <input type="text" class="form-control" id="name" name="name" aria-describedby="emailHelp">
        </div>
        <div class="mb-3">
            <label for="note" class="form-label">商品資訊</label>
            <input type="text" class="form-control" id="note" name="note">
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">商品價格</label>
            <input type="number" class="form-control" id="price" name="price">
        </div>
        <div class="mb-3">
            <label for="sales" class="form-label">商品銷售數量</label>
            <input type="number" class="form-control" id="sales" name="sales">
        </div>
        <div class="mb-3">
            <label for="stock" class="form-label">商品庫存</label>
            <input type="number" class="form-control" id="stock" name="stock">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</body>
</html>