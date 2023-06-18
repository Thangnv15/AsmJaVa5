<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title> DongSP </title>
</head>
<body>
<h1 style="text-align: center">DongSP</h1>
<table border="1">
    <a href="/dong-sp/create">
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

    <c:forEach items="${dongsp}" var="dsp" varStatus="stt">
        <tr>
            <td>${stt.index}</td>
<%--            <td>${cv.getId()}</td>--%>
            <td>${dsp.ma}</td>
            <td>${dsp.ten}</td>
            <td>
                <a href="/dong-sp/delete/${dsp.id}">
                    <button>Xóa</button>
                </a>
                <a href="/dong-sp/edit/${dsp.id}">
                    <button>Sửa</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>