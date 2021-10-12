<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-uWxY/CJNBR+1zjPWmfnSnVxwRheevXITnMqoEIeG1LJrdI0GlVs/9cVSyPYXdcSF" crossorigin="anonymous">
    <base href="<%=BasePath%>">
    <title>登入</title>
</head>

<body>

<%@include file="../../static/navbar.jsp" %>

<div class="container">
    <div class="col-md-6 col-sm-12">
        <h2 style="margin-top: 15px; margin-bottom: 15px; padding: 0px;">註冊</h2>
        <div class="login-form d-flex align-items-center col-8" style="margin-top: 50px;">
            <form method="POST" action="UserServlet">
                <small class="ml-auto <%=request.getAttribute("msg") != null ? "text-danger" : "text-dark" %>">
                    <%=request.getAttribute("msg") != null ? request.getAttribute("msg") : "請輸入帳號密碼"%>
                </small>
                <input type="hidden" name="action" value="register">
                <div class="form-group mb-3">
                    <label for="username">帳號名稱</label>
                    <input type="text" class="form-control" id="username" name="username"
                           value="<%=request.getAttribute("username") == null ? "" : request.getAttribute("username")%>">
                </div>
                <div class="form-group mb-3">
                    <label for="exampleInputPassword1">密碼</label>
                    <input type="password" class="form-control" id="exampleInputPassword1" placeholder=""
                           name="password">
                </div>
                <div class="form-group mb-3">
                    <label for="exampleInputEmail1">電子郵件</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" name="email"
                           value="<%=request.getAttribute("email") == null ? "" : request.getAttribute("email")%>">
                </div>
                <button type=" submit" class="btn btn-primary" style="margin-right: 10px;">送出</button>
                <a href="pages/user/login.jsp" type="submit" class="btn btn-secondary">取消</a>
            </form>
        </div>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kQtW33rZJAHjgefvhyyzcGF3C5TFyBQBA13V1RKPf4uH+bwyzQxZ6CmMZHmNBEfJ"
        crossorigin="anonymous"></script>

</body>

</html>