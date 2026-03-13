<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Mail Settings</title>

    <style>

        body{
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg,#ff4d4d,#b30000);
            display:flex;
            justify-content:center;
            align-items:center;
            height:100vh;
        }

        /* animation form xuất hiện */
        @keyframes fadeIn{
            from{
                opacity:0;
                transform:translateY(30px);
            }
            to{
                opacity:1;
                transform:translateY(0);
            }
        }

        .container{
            background:white;
            padding:35px;
            width:420px;
            border-radius:12px;
            box-shadow:0 10px 25px rgba(0,0,0,0.2);
            animation:fadeIn 0.6s ease;
        }

        h2{
            text-align:center;
            margin-bottom:25px;
            color:#cc0000;
        }

        /* label */
        label{
            font-weight:bold;
            margin-top:15px;
            display:block;
        }

        /* input */
        select, textarea{
            width:100%;
            padding:10px;
            margin-top:6px;
            border-radius:6px;
            border:2px solid #eee;
            transition:all 0.3s;
        }

        /* highlight khi focus */
        select:focus, textarea:focus{
            border-color:#ff3333;
            box-shadow:0 0 8px rgba(255,0,0,0.3);
            outline:none;
        }

        /* checkbox */
        .checkbox{
            margin-top:10px;
            cursor:pointer;
        }

        /* button */
        button{
            width:100%;
            padding:12px;
            margin-top:25px;
            border:none;
            border-radius:6px;
            background:#ff3333;
            color:white;
            font-size:16px;
            font-weight:bold;
            cursor:pointer;
            transition:all 0.3s;
        }

        /* hover button */
        button:hover{
            background:#cc0000;
            transform:translateY(-2px);
            box-shadow:0 6px 15px rgba(0,0,0,0.2);
        }

        /* click button */
        button:active{
            transform:scale(0.97);
        }

    </style>
</head>

<body>

<div class="container">

    <h2>Mail Settings</h2>

    <form:form action="/update" modelAttribute="setting" method="post">

        <label>Languages</label>
        <form:select path="language" items="${languages}"/>

        <label>Page Size</label>
        <form:select path="pageSize" items="${pageSizes}"/>

        <label>Spam Filter</label>
        <div class="checkbox">
            <form:checkbox path="spamFilter"/> Enable spam filter
        </div>

        <label>Signature</label>
        <form:textarea path="signature" rows="4"/>

        <button type="submit">Update</button>

    </form:form>

</div>

</body>
</html>