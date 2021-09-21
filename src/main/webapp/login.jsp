<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login to FCK</title>
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
<main class="login-main">
    <div class="login-main-container">
        <h1 class="logo">FCK</h1>
        <section class="login-window">
            <h2>Вход</h2>
            <form method="post" action="" class="login-form">
                <label for="login">Логин:</label>
                <br>
                <input id="login">
                <br>
                <label for="password">Пароль:</label>
                <br>
                <input id="password" type="password">
                <br>
                <button class="btn btn-default" style="align-self: center;">Войти</button>
            </form>
        </section>
    </div>
    <!--<section class="bg-heart">
        <div class="heart h-1">
        </div>
        <div class="heart h-2">
        </div>
        <div class="heart h-3">
        </div>
    </section>-->
</main>
</body>
</html>
