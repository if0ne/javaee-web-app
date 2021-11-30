<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ELECTIVES</title>
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
    <main class="login-main">
        <div class="login-main-container">
            <section class="login-window">
                <h2 class="form-title" style="align-self: center;">Вы заблокированы</h2>
                <form method="post" action="/controller" class="login-form">
                    <input type="hidden" name="command" value="logout">
                    <button class="btn btn-default" style="align-self: center;">Выйти</button>
                </form>
            </section>
        </div>
    </main>
</body>
</html>