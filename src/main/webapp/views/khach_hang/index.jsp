<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Khách</title>
</head>

<body>
<h1 style="text-align:center">Quản Lí Khách hàng</h1>
<a href="/khach-hang/create">
    <button>Thêm</button>
</a>
<table border="-1">
    <thead>
    <tr>
        <th>STT</th>
        <th>Mã</th>
        <th>Tên</th>
        <th>Tên Đệm</th>
        <th>Họ</th>
        <th>Ngày Sinh</th>
        <th>SĐT</th>
        <th>Địa Chỉ</th>
        <th>Thành Phố</th>
        <th>Quốc Gia</th>
        <th>Mật Khẩu</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="kh" items="${khachhang}" varStatus="stt">
        <tr>
            <td>${stt.index +1}</td>
            <td>${kh.ma}</td>
            <td>${kh.ten}</td>
            <td>${kh.tenDem}</td>
            <td>${kh.ho}</td>
            <td>${kh.ngaySinh}</td>
            <td>${kh.sdt}</td>
            <td>${kh.diaChi}</td>
            <td>${kh.thanhPho}</td>
            <td>${kh.quocGia}</td>
            <td>${kh.matKhau}</td>
            <td>
                <a href="/khach-hang/delete/${kh.id}">
                    <button>Xóa</button>
                </a>
                <a href="/khach-hang/edit/${kh.id}">
                    <button>Sửa</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>

</html>