<%@ page language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getScheme() + "://" +
            request.getServerName() + ":" +
            request.getServerPort() + request.getContextPath() + "/";
%>
<nav class="navbar navbar-expand-lg navbar-light " style="background-color: rgb(159, 214, 247);">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <img src="<%=path%>static/img/atom.png" alt="" width="30" height="30" class="d-inline-block align-text-top">
            Bootstrap
        </a>
        <div class="d-inline-block">
            <%--            <a class="nav-link  d-inline-block" aria-current="page" href="#">Home</a>--%>
            <%--            <a class="nav-link  d-inline-block" href="#">Features234</a>--%>
            <%--            <a class="nav-link  d-inline-block" href="#">Pricing</a>--%>
            <a class="nav-link  d-inline-block" href="<%=path%>pages/manager/manager.jsp">後臺管理</a>
            <a class="nav-link  d-inline-block" href="<%=path%>pages/user/login.jsp">登入</a>
        </div>
    </div>
</nav>