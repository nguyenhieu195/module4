<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hieuvannguyen
  Date: 9/3/26
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>USD to VND Converter</title>
</head>
<body>

<h2>Chuyển đổi USD sang VNĐ</h2>

<form action="convert" method="post">

    Tỉ giá (VND/USD):
    <input type="text" name="rate"><br><br>

    Số USD:
    <input type="text" name="usd"><br><br>

    <button type="submit">Chuyển đổi</button>

</form>

<h3>Kết quả: ${usd} USD = ${vnd} VNĐ</h3>

</body>
</html>
