<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Thêm</title>
</head>
<body>
<h1 style="text-align: center">Thêm Nhân Viên</h1>
<sf:form action="/nhan-vien/store" method="post"
         modelAttribute="vm"
         cssStyle="text-align: center"
>
    <div>
        <label>Mã</label>
        <sf:input path="ma"/>
        <sf:errors path="ma"/>
    </div>
    <div>
        <label>Tên</label>
        <sf:input path="ten"/>
        <sf:errors path="ten"/>
    </div>
    <div>
        <label>Tên Đệm</label>
        <sf:input path="tenDem"/>
        <sf:errors path="tenDem"/>
    </div>
    <div>
        <label>Họ</label>
        <sf:input path="ho"/>
        <sf:errors path="ho"/>
    </div>
    <div>
        <label>Giới Tính</label>
        Nam<sf:radiobutton value="Nam" path="gioiTinh"/>
        Nữ<sf:radiobutton value="Nữ" path="gioiTinh"/>
        <sf:errors path="gioiTinh"/>
    </div>
    <div>
        <label>Ngày Sinh</label>
        <sf:input type="Date" path="ngaySinh"/>
        <sf:errors path="ngaySinh"/>
    </div>
    <div>
        <label>Địa chỉ</label>
        <sf:input path="diaChi"/>
        <sf:errors path="diaChi"/>
    </div>
    <div>
        <label>SĐT</label>
        <sf:input path="sdt"/>
        <sf:errors path="sdt"/>
    </div>
    <div>
        <label>Mật Khẩu</label>
        <sf:password path="matKhau"/>
        <sf:errors path="matKhau"/>
    </div>
    <div>
        <label>Cửa Hàng</label>
        <sf:select path="idCuaHang">
            <c:forEach var="ch" items="${listCH}">
                <sf:option value="${ch.id}">${ch.ten}</sf:option>
            </c:forEach>
        </sf:select>
    </div>
    <div>
        <label>Chức Vụ</label>
        <sf:select path="idChucVu">
            <c:forEach var="cv" items="${listCV}">
                <sf:option value="${cv.id}">${cv.ten}</sf:option>
            </c:forEach>
        </sf:select>
    </div>
    <div>
        <label>Trạng Thái</label>
        <sf:radiobutton path="trangThai" value="1" checked="true"/>Làm
        <sf:radiobutton path="trangThai" value="0"/> Nghỉ
        <sf:errors path="trangThai"/>
    </div>
    <button>Thêm</button>
</sf:form>
</body>
</html>