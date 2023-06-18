<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Sản Phẩm</title>
</head>
<body>
<h1 style="text-align: center">Sản Phẩm</h1>
<table border="1">
    <a href="/san-pham/create">
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

    <c:forEach items="${sanpham}" var="sp" varStatus="stt">
        <tr>
            <td>${stt.index}</td>
<%--            <td>${cv.getId()}</td>--%>
            <td>${sp.ma}</td>
            <td>${sp.ten}</td>
            <td>
                <a href="/san-pham/delete/${sp.id}">
                    <button>Xóa</button>
                </a>
                <a href="/san-pham/edit/${sp.id}">
                    <button>Sửa</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>