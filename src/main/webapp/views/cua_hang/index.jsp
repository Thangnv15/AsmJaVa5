<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Cửa hàng</title>
</head>
<body>
<h1 style="text-align: center"> Cửa Hàng</h1>
<table border="1">
    <a href="/cua-hang/create"><button>Thêm</button></a>
    <thead>
    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>Mã</th>
        <th>Tên</th>
        <th>Địa Chỉ</th>
        <th>Thành Phố</th>
        <th>Quốc Gia</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>

        <c:forEach items="${cuahang}" var="ch" varStatus="stt">
        <tr>
            <td>${stt.index}</td>
            <td>${ch.getId()}</td>
            <td>${ch.ma}</td>
            <td>${ch.ten}</td>
            <td>${ch.diaChi}</td>
            <td>${ch.thanhPho}</td>
            <td>${ch.quocGia}</td>
            <td>
                <a href="/cua-hang/delete/${ch.id}"><button>Xóa</button></a>
                <a href="/cua-hang/edit/${ch.id}"><button>Sửa</button></a>
            </td>
        </tr>
        </c:forEach>

    </tbody>
</table>
</body>
</html>