<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Sửa</title>
</head>
<body>
<h1 style="text-align: center">Sửa Cửa Hàng</h1>
<sf:form action="${update}" method="post" modelAttribute="vm">
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
    <div>
        <label>Địa chỉ</label>
        <sf:input path="diaChi"/>
        <sf:errors path="diaChi" />
    </div>
    <div>
        <label>Thành Phố</label>
        <sf:input path="thanhPho"/>
        <sf:errors path="thanhPho" />
    </div>
    <div>
        <label>Quốc Gia</label>
        <sf:input path="quocGia"/>
        <sf:errors path="quocGia" />
    </div>
    <button>Sửa</button>
</sf:form>
</body>
</html>