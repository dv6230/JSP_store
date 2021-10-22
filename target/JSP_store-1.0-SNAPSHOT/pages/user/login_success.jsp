<%--
  Created by IntelliJ IDEA.
  User: allis
  Date: 2021/10/7
  Time: 下午 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    String BasePath = request.getScheme() + "://" +
            request.getServerName() + ":" +
            request.getServerPort() + request.getContextPath() + "/";
%>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <base href="<%=BasePath%>">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-uWxY/CJNBR+1zjPWmfnSnVxwRheevXITnMqoEIeG1LJrdI0GlVs/9cVSyPYXdcSF" crossorigin="anonymous">
    <title>登入成功</title>
</head>
<body>
<jsp:include page="/static/navbar.jsp"></jsp:include>
<div class="container">
    <div class="row text-center d-flex justify-content-center">
        <div class="col-sm-6">
            <br><br>
            <h2 style="color:#0fad00;margin-bottom: 10px;" class="p-5">成功</h2>

            <img class="d-block m-auto " src="static/img/check.png" height="30px" width="30px">

            <a href="#" class="btn btn-success mt-5">前往</a>
            <br><br>
        </div>

    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kQtW33rZJAHjgefvhyyzcGF3C5TFyBQBA13V1RKPf4uH+bwyzQxZ6CmMZHmNBEfJ"
        crossorigin="anonymous"></script>

</body>
</html>