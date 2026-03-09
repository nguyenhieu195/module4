<%--
  Created by IntelliJ IDEA.
  User: hieuvannguyen
  Date: 9/3/26
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Dictionary</title>
</head>
<body>

<h2>Từ điển Anh - Việt</h2>

<form action="/dictionary/search" method="post">
    Nhập từ tiếng Anh:
    <input type="text" name="word">
    <button type="submit">Tra cứu</button>
</form>

<p>${word} : ${result}</p>

</body>
</html>