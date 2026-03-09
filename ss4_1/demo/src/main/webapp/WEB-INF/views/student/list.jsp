<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Student List</title>

    <style>
        th:nth-child(1), td:nth-child(1){
            width:20%;
        }

        th:nth-child(2), td:nth-child(2){
            width:50%;
        }

        th:nth-child(3), td:nth-child(3){
            width:30%;
        }
        body{
            font-family: Arial, sans-serif;
            background-color: #f4f6f9;
            margin:0;
            padding:40px;
            display:flex;
            justify-content:center;
        }

        .container{
            width:700px;
            background:white;
            padding:25px;
            border-radius:10px;
            box-shadow:0 4px 10px rgba(0,0,0,0.1);
        }

        h2{
            text-align:center;
            margin-bottom:20px;
        }

        table{
            width:100%;
            border-collapse:collapse;
        }

        th, td{
            padding:12px;
            text-align:center;
        }

        th{
            background:#4CAF50;
            color:white;
        }

        tr:nth-child(even){
            background:#f2f2f2;
        }

        tr:hover{
            background:#e8f5e9;
        }

        td{
            border-bottom:1px solid #ddd;
        }

    </style>

</head>
<body>

<div class="container">

    <h2>Danh sách sinh viên</h2>
    <a href="/student/add">thêm</a>
    <table>

        <tr>
            <th>Mã sinh viên</th>
            <th>Họ tên</th>
            <th>Điểm</th>
        </tr>

        <c:forEach var="l" items="${students}">
            <tr>
                <td>${l.id}</td>
                <td>${l.name}</td>
                <td>${l.score}</td>
            </tr>
        </c:forEach>

    </table>

</div>

</body>
</html>