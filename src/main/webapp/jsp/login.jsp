<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login to ELECTIVES</title>
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
    <main class="login-main">
        <div class="login-main-container">
            <section class="login-window">
                <h1 class="logo" style="align-self: center; color: #000">ELECTIVES</h1>
                <h2 class="form-title" style="align-self: center;">Вход</h2>
                <form method="post" action="" class="login-form">
                    <div class="field">
                        <label for="login">Логин:</label>
                        <input id="login" class="input-field">
                    </div>
                    <div class="field">
                        <label for="password">Пароль:</label>
                        <input id="password" type="password" class="input-field">
                    </div>
                    <button class="btn btn-default" style="align-self: center;">Войти</button>
                </form>
                <p class="error-message">
                    Неверный логин или пароль
                </p>
            </section>
        </div>
    </main>
</body>
</html>