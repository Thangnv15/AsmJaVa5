<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Màu sắc</title>
</head>
<body>
<h1 style="text-align: center">Màu sắc</h1>
<table border="1">
    <a href="/mau-sac/create">
        <button>Thêm</button>
    </a>
    <thead>
    <tr>
        <th>STT</th>
        <th>Mã</th>
        <th>Tên</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${mausac}" var="ms" varStatus="stt">
        <tr>
            <td>${stt.index}</td>
            <td>${ms.ma}</td>
            <td>${ms.ten}</td>
            <td>
                <a href="/mau-sac/delete/${ms.id}">
                    <button>Xóa</button>
                </a>
                <a href="/mau-sac/edit/${ms.id}">
                    <button>Sửa</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>