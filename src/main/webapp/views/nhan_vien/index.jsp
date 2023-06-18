<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nhân Viên</title>
</head>

<body>
<h1 style="text-align:center">Quản Lí Nhân Viên</h1>
<form action="/nhan-vien/search" method="get">
    <label><input name="keyword"> </label>
    <button type="submit">Search</button>
</form>
<a href="/nhan-vien/create">
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
        <th>Giới Tính</th>
        <th>Ngày Sinh</th>
        <th>Địa Chỉ</th>
        <th>SĐT</th>
        <th>Mật Khẩu</th>
        <th>IdCH</th>
        <th>IdCV</th>
        <th>Trạng Thái</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="nv" items="${nhanvien.content}" varStatus="stt">
        <tr>
            <td>${stt.index +1}</td>
            <td>${nv.ma}</td>
            <td>${nv.ten}</td>
            <td>${nv.tenDem}</td>
            <td>${nv.ho}</td>
            <td>${nv.gioiTinh}</td>
            <td>${nv.ngaySinh}</td>
            <td>${nv.diaChi}</td>
            <td>${nv.sdt}</td>
            <td>${nv.matKhau}</td>
            <td>${nv.cuaHang.id}</td>
            <td>${nv.chucVu.id}</td>
            <td>${nv.trangThai == 1 ? "Làm":"Nghỉ"}</td>
            <td>
                <a href="/nhan-vien/delete/${nv.id}">
                    <button>Xóa</button>
                </a>
                <a href="/nhan-vien/edit/${nv.id}">
                    <button>Sửa</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<c:forEach begin="0" end="${nhanvien.totalPages -1}" varStatus="loop">
    <button>
        <a href="/nhan-vien/index?page=${loop.begin + loop.count -1}">
                ${loop.begin + loop.count}
        </a>
    </button>
</c:forEach>
</body>
</html>