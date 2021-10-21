<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>首頁</title>
</head>
<body>
<jsp:include page="/static/navbar.jsp"></jsp:include>

<div class="container">
    <div class="row mt-5">
        <c:forEach var="product" items="${requestScope.page.items}">
            <div class="card col-md-3">
                <img class="card-img-top" src="https://picsum.photos/250" alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title">${product.name}</h5>
                    <p class="card-text">${product.note}</p>
                    <a href="#" class="btn btn-primary">前往購買</a>
                </div>
            </div>
        </c:forEach>
    </div>

    <nav aria-label="Page navigation example border border-primary">
        <ul class="pagination justify-content-center">
            <c:choose>
                <c:when test="${requestScope.page.pageCount <=5}">
                    <c:set var="begin" value="${1}"></c:set>
                    <c:set var="end" value="${requestScope.page.pageCount}"></c:set>
                </c:when>
                <c:when test="${requestScope.page.pageCount > 5}">
                    <c:choose>
                        <c:when test="${requestScope.page.pageNo <= 3}">
                            <c:set var="begin" value="${1}"></c:set>
                            <c:set var="end" value="${5}"></c:set>
                        </c:when>
                        <%--- 倒數後5頁 ---%>
                        <c:when test="${requestScope.page.pageNo > requestScope.page.pageCount-3}">
                            <c:set var="begin" value="${requestScope.page.pageCount-4}"></c:set>
                            <c:set var="end" value="${requestScope.page.pageCount}"></c:set>
                        </c:when>
                        <c:otherwise>
                            <c:set var="begin" value="${requestScope.page.pageNo-2}"></c:set>
                            <c:set var="end" value="${requestScope.page.pageNo+2}"></c:set>
                        </c:otherwise>
                    </c:choose>
                </c:when>
            </c:choose>

            <c:forEach begin="${begin}" end="${end}" var="i">
                <c:if test="${i == requestScope.page.pageNo}">
                    <li class="page-item active"><a class="page-link"
                                                    href="?action=page&pageNo=${i}">${i}</a></li>
                </c:if>
                <c:if test="${i != requestScope.page.pageNo}">
                    <li class="page-item"><a class="page-link" href="?action=page&pageNo=${i}">${i}</a>
                    </li>
                </c:if>
            </c:forEach>
        </ul>
    </nav>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kQtW33rZJAHjgefvhyyzcGF3C5TFyBQBA13V1RKPf4uH+bwyzQxZ6CmMZHmNBEfJ"
        crossorigin="anonymous"></script>

</body>
</html>

