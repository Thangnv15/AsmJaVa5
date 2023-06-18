<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>NSX</title>
</head>
<body>
<h1 style="text-align: center">NSX</h1>
<table border="1">
    <a href="/nsx/create">
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

    <c:forEach items="${nsx}" var="nsx" varStatus="stt">
        <tr>
            <td>${stt.index}</td>
<%--            <td>${cv.getId()}</td>--%>
            <td>${nsx.ma}</td>
            <td>${nsx.ten}</td>
            <td>
                <a href="/nsx/delete/${nsx.id}">
                    <button>Xóa</button>
                </a>
                <a href="/nsx/edit/${nsx.id}">
                    <button>Sửa</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>