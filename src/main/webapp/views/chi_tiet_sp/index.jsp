<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>CTSP</title>
</head>
<body>
<h1 style="text-align: center">Chi Tiết Sản Phẩm</h1>
<table border="1">
    <a href="/chi-tiet-sp/create">
        <button>Thêm</button>
    </a>
    <thead>
    <tr>
        <th>STT</th>
        <th>IdSP</th>
        <th>IdNsx</th>
        <th>IdMauSac</th>
        <th>IdSanPham</th>
        <th>Năm BH</th>
        <th>Mô Tả</th>
        <th>Số Lượng tồn</th>
        <th>Giá Nhập</th>
        <th>Giá Bán</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${chitietsp.content}" var="ctsp" varStatus="stt">
        <tr>
            <td>${stt.index}</td>
            <td>${ctsp.sanPham.id}</td>
            <td>${ctsp.nsx.id}</td>
            <td>${ctsp.mauSac.id}</td>
            <td>${ctsp.dongSP.id}</td>
            <td>${ctsp.namBH}</td>
            <td>${ctsp.moTa}</td>
            <td>${ctsp.soLuongTon}</td>
            <td>${ctsp.giaNhap}</td>
            <td>${ctsp.giaBan}</td>
            <td>
                <a href="/chi-tiet-sp/delete/${ctsp.id}">
                    <button>Xóa</button>
                </a>
                <a href="/chi-tiet-sp/edit/${ctsp.id}">
                    <button>Sửa</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<c:forEach begin="0" end="${chitietsp.totalPages -1}" varStatus="loop">
    <button>
        <a href="/chi-tiet-sp/index?page=${loop.begin + loop.count -1}">
            ${loop.begin + loop.count}
        </a>
    </button>
</c:forEach>
</button>
</body>
</html>