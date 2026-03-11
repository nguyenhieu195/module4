<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Home</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>

        body{
            height:100vh;
            display:flex;
            justify-content:center;
            align-items:center;
            background:linear-gradient(135deg,#43cea2,#185a9d);
            font-family:Arial;
        }

        .home-card{
            padding:50px;
            border-radius:20px;
            background:white;
            box-shadow:0 20px 40px rgba(0,0,0,0.2);
            text-align:center;
            animation:slideUp 0.8s ease;
        }

        .home-card:hover{
            transform:translateY(-5px);
            transition:0.3s;
        }

        .logout-btn{
            margin-top:20px;
            padding:10px 25px;
            border-radius:10px;
            transition:0.3s;
        }

        .logout-btn:hover{
            transform:scale(1.1);
        }

        @keyframes slideUp{
            from{
                opacity:0;
                transform:translateY(40px);
            }
            to{
                opacity:1;
                transform:translateY(0);
            }
        }

        .username{
            color:#0d6efd;
            font-weight:bold;
        }

    </style>

</head>

<body>

<div class="home-card">

    <h2>🏠 Home Page</h2>

    <h4>Welcome: <span class="username">${sessionScope.user.username}</span></h4>

    <a href="logout" class="btn btn-danger logout-btn">Logout</a>

</div>

</body>
</html>