<%--
  Created by IntelliJ IDEA.
  User: hieuvannguyen
  Date: 11/3/26
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Sandwich Condiments</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body{
            background: linear-gradient(135deg,#667eea,#764ba2);
            min-height:100vh;
            display:flex;
            justify-content:center;
            align-items:center;
            font-family: Arial, sans-serif;
        }

        .card{
            border-radius:20px;
            padding:30px;
            box-shadow:0 15px 35px rgba(0,0,0,0.2);
        }

        .title{
            font-weight:bold;
            color:#333;
        }

        .btn-custom{
            background:#667eea;
            border:none;
            padding:10px 25px;
            font-weight:bold;
        }

        .btn-custom:hover{
            background:#5563d6;
        }

        .result-box{
            background:#f8f9fa;
            border-radius:10px;
            padding:15px;
            margin-top:15px;
        }
    </style>
</head>

<body>

<div class="card col-md-5">

    <h2 class="text-center title mb-4">Choose Your Sandwich Condiments</h2>

    <form action="sandwich" method="post">

        <div class="form-check">
            <input class="form-check-input" type="checkbox" name="condiments" value="Lettuce">
            <label class="form-check-label">Lettuce</label>
        </div>

        <div class="form-check">
            <input class="form-check-input" type="checkbox" name="condiments" value="Tomato">
            <label class="form-check-label">Tomato</label>
        </div>

        <div class="form-check">
            <input class="form-check-input" type="checkbox" name="condiments" value="Mustard">
            <label class="form-check-label">Mustard</label>
        </div>

        <div class="form-check">
            <input class="form-check-input" type="checkbox" name="condiments" value="Sprouts">
            <label class="form-check-label">Sprouts</label>
        </div>

        <div class="text-center mt-4">
            <button class="btn btn-custom text-white">Save</button>
        </div>

    </form>

    <c:if test="${condiments != null}">
        <div class="result-box mt-4">
            <h5>Condiments Selected:</h5>
            <ul>
                <c:forEach var="c" items="${condiments}">
                    <li>${c}</li>
                </c:forEach>
            </ul>
        </div>
    </c:if>

</div>

</body>
</html>