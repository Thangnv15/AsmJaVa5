<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Thêm</title>
</head>
<body>
<h1 style="text-align: center">Thêm Màu Sắc</h1>
<sf:form action="/mau-sac/store" method="post" modelAttribute="vm">
    <div>
        <label>Mã</label>
        <sf:input path="ma"/>
        <sf:errors path="ma" />
    </div>
    <div>
        <label>Tên</label>
        <sf:input path="ten"/>
        <sf:errors path="ten" />
    </div>
    <button>Thêm</button>
</sf:form>
</body>
</html>