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
    <title>Calculator</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>

        body {
            background: linear-gradient(135deg, #6a11cb, #2575fc);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            font-family: Arial;
        }

        .card {
            padding: 40px;
            border-radius: 20px;
            box-shadow: 0 15px 40px rgba(0, 0, 0, 0.2);
        }

        button {
            width: 150px;
        }

    </style>

</head>

<body>

<div class="card text-center">

    <h1 class="mb-4">🧮 Calculator</h1>

    <form action="calc" method="post">

        <div class="row mb-3">
            <div class="col">
                <input type="number" step="any" name="num1" value="${num1}" class="form-control" placeholder="Number 1">
            </div>

            <div class="col">
                <input type="number" step="any" name="num2" value="${num2}" class="form-control" placeholder="Number 2">
            </div>
        </div>

        <div class="d-flex gap-3 justify-content-center mb-3">

            <button class="btn btn-success" name="operation" value="+">Addition (+)</button>

            <button class="btn btn-warning" name="operation" value="-">Subtraction (-)</button>

            <button class="btn btn-primary" name="operation" value="*">Multiplication (×)</button>

            <button class="btn btn-danger" name="operation" value="/">Division (/)</button>

        </div>

    </form>

    <%-- Result --%>

    <c:if test="${result != null}">
        <div class="alert alert-info">
            Result: <b>${result}</b>
        </div>
    </c:if>

    <c:if test="${error != null}">
        <div class="alert alert-danger">
                ${error}
        </div>
    </c:if>

</div>

</body>
</html>