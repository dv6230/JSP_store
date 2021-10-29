<%@ page import="java.util.Map" %>
<%@ page import="com.example.pojo.Cart" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Enumeration" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: allis
  Date: 2021/10/22
  Time: 下午 12:09
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
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>購物車</title>

</head>
<body>
<jsp:include page="/static/navbar.jsp"/>

<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">商品名稱</th>
            <th scope="col">數量</th>
            <th scope="col">單價</th>
            <th scope="col">總價</th>
            <th scope="col">刪除</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${sessionScope.cart.cartList}">
            <tr>
                <td>${item.value.name}</td>
                <td>${item.value.count}</td>
                <td>${item.value.price}</td>
                <td>${item.value.total}</td>
                <td><a class="deleteItem"
                       href="<%=path%>/cartServlet?action=deleteItem&productId=${item.value.id}">刪除</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <c:if test="${not empty sessionScope.cart.cartList}">
        <p>總金額為$${sessionScope.cart.totalPrice}</p>
        <a href="<%=path%>cartServlet?action=clearItem" class="m-3">清空購物車</a>
        <a href="<%=path%>orderServlet?action=createOrder" class="m-3">結帳</a>
    </c:if>
    <c:if test="${ empty sessionScope.cart.cartList}">
        <p>當前購物車為空</p>
    </c:if>
</div>
<script>
    $(function () {
        $("a.deleteItem").click(function () {
            confirm("確定要刪除 "+$(this).parent().parent().find("td:first").text()+" 嗎?")
        });
    });
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</body>
</html>
