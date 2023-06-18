<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Sửa</title>
</head>
<body>
<h1 style="text-align: center">Sửa NSX</h1>
<sf:form action="${update}" method="post" modelAttribute="vm"
         cssStyle="text-align: center">
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
    <button>Sửa</button>
</sf:form>
</body>
</html>