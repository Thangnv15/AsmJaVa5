<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Chức Vụ</title>
</head>
<body>
<h1 style="text-align: center"> Chức Vụ</h1>
<table border="1">
    <a href="/chuc-vu/create">
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

    <c:forEach items="${chucvu}" var="cv" varStatus="stt">
        <tr>
            <td>${stt.index}</td>
<%--            <td>${cv.getId()}</td>--%>
            <td>${cv.ma}</td>
            <td>${cv.ten}</td>
            <td>
                <a href="/chuc-vu/delete/${cv.id}">
                    <button>Xóa</button>
                </a>
                <a href="/chuc-vu/edit/${cv.id}">
                    <button>Sửa</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>