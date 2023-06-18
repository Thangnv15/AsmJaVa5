<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Thêm</title>
</head>
<body>
<h1 style="text-align: center">Thêm Chi Tiết SP</h1>
<sf:form action="/chi-tiet-sp/store" method="post" modelAttribute="vm">
    <div>
        <label>Sản Phẩm</label>
        <sf:select path="idSP">
            <c:forEach var="sp" items="${listSP}">
                <sf:option value="${sp.id}">${sp.ten}</sf:option>
            </c:forEach>
        </sf:select>
    </div>
    <div>
        <label>NSX</label>
        <sf:select path="idNsx">
            <c:forEach var="nsx" items="${listNsx}">
                <sf:option value="${nsx.id}">${nsx.ten}</sf:option>
            </c:forEach>
        </sf:select>
    </div>
    <div>
        <label>Màu Sắc</label>
        <sf:select path="idMauSac">
            <c:forEach var="ms" items="${listMS}">
                <sf:option value="${ms.id}">${ms.ten}</sf:option>
            </c:forEach>
        </sf:select>
    </div>
    <div>
        <label>Dong SP</label>
        <sf:select path="idDongSP">
            <c:forEach var="dsp" items="${listDSP}">
                <sf:option value="${dsp.id}">${dsp.ten}</sf:option>
            </c:forEach>
        </sf:select>
    </div>
    <div>
        <label>Năm BH</label>
        <sf:input path="namBH"/>
        <sf:errors path="namBH" />
    </div>
    <div>
        <label>Mô tả</label>
        <sf:textarea path="moTa"/>
        <sf:errors path="moTa" />
    </div><div>
        <label>Số Lượng Tồn</label>
        <sf:input  path="soLuongTon"/>
        <sf:errors path="soLuongTon" />
    </div>
    <div>
        <label>Giá Nhập</label>
        <sf:input  path="giaNhap"/>
        <sf:errors path="giaNhap" />
    </div>
    <div>
        <label>Giá Bán</label>
        <sf:input path="giaBan"/>
        <sf:errors path="giaBan" />
    </div>
    <button>Thêm</button>
</sf:form>
</body>
</html>