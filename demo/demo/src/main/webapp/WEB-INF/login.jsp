<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>

        body{
            height:100vh;
            display:flex;
            justify-content:center;
            align-items:center;
            background:linear-gradient(135deg,#667eea,#764ba2);
            font-family:Arial;
        }

        .login-card{
            width:380px;
            padding:40px;
            border-radius:20px;
            background:rgba(255,255,255,0.15);
            backdrop-filter:blur(15px);
            box-shadow:0 20px 40px rgba(0,0,0,0.2);
            transition:0.3s;
            animation:fadeIn 1s ease;
        }

        .login-card:hover{
            transform:translateY(-8px);
            box-shadow:0 25px 50px rgba(0,0,0,0.3);
        }

        h2{
            text-align:center;
            margin-bottom:30px;
            color:white;
        }

        input{
            margin-bottom:15px;
            border-radius:10px !important;
        }

        button{
            width:100%;
            border-radius:10px !important;
            transition:0.3s;
        }

        button:hover{
            transform:scale(1.05);
        }

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

    </style>

</head>

<body>

<div class="login-card">

    <h2>🔐 Login</h2>

    <form action="login" method="post">

        <input type="text" name="username" class="form-control" placeholder="Username">

        <input type="password" name="password" class="form-control" placeholder="Password">

        <button class="btn btn-light mt-3">Login</button>

    </form>

</div>

</body>
</html>