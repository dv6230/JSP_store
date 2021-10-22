<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String BasePath = request.getScheme() + "://" +
            request.getServerName() + ":" +
            request.getServerPort() + request.getContextPath() + "/";
    Object username = request.getAttribute("username");
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

<jsp:include page="/static/navbar.jsp"></jsp:include>

<div class="container">
    <div class="col-md-6 col-sm-12 ">
        <h2 style="margin-top: 15px; margin-bottom: 15px; padding: 0px;">登入</h2>
        <div class="login-form d-flex align-items-center col-8" style="margin-top: 50px;">
            <form class="" method="POST" action="UserServlet">
                <small class="ml-auto <%=request.getAttribute("msg") != null ? "text-danger" : "text-dark" %>">
                    ${ empty requestScope.msg ? "請輸入照號密碼": requestScope.msg }
                </small>
                <input type="hidden" name="action" value="login">
                <div class="form-group mb-3">
                    <label>帳號名稱</label>
                    <input type="text" class="form-control" placeholder="" name="username"
                           value="<%=username != null ? username : "" %>">
                </div>
                <div class="form-group mb-3">
                    <label>密碼</label>
                    <input type="password" class="form-control" placeholder="" name="password">
                </div>
                <button type="submit" class="btn btn-primary" style="margin-right: 10px;">登入</button>
                <a href="pages/user/register.jsp" type="submit" class="btn btn-secondary">註冊</a>
            </form>
        </div>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kQtW33rZJAHjgefvhyyzcGF3C5TFyBQBA13V1RKPf4uH+bwyzQxZ6CmMZHmNBEfJ"
        crossorigin="anonymous"></script>

</body>

</html>