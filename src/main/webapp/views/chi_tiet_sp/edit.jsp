<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Sửa</title>
</head>
<body>
<h1 style="text-align: center">Sửa Sản Phẩm</h1>
<sf:form action="${update}" method="post" modelAttribute="vm">
    <div>
        <label>Năm BH</label>
        <sf:input path="namBH"/>
        <sf:errors path="namBH"/>
    </div>
    <div>
        <label>Mô tả</label>
        <sf:textarea path="moTa"/>
        <sf:errors path="moTa"/>
    </div>
    <div>
        <label>Số Lượng Tồn</label>
        <sf:input path="soLuongTon"/>
        <sf:errors path="soLuongTon"/>
    </div>
    <div>
        <label>Giá Nhập</label>
        <sf:input path="giaNhap"/>
        <sf:errors path="giaNhap"/>
    </div>
    <div>
        <label>Giá Bán</label>
        <sf:input path="giaBan"/>
        <sf:errors path="giaBan"/>
    </div>
    <button>Sửa</button>
</sf:form>
</body>
</html>