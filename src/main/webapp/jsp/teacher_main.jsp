<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ELECTIVES</title>
    <link href="css/style.css" rel="stylesheet">
    <script src="https://kit.fontawesome.com/c52007ae7d.js" crossorigin="anonymous"></script>
</head>
<body>
<main class="edit-main">
    <aside class="aside-edit">
        <h1 class="logo" style="align-self: center;">ELECTIVES</h1>
        <div class="side-profile">
            <h1 class="user-name" style="color: #FFF; display: block;">Агафонов Павел</h1>
            <p class="role-label">Преподаватель</p>
        </div>
        <div class="aside-menu single-form">
            <form class="logout-form">
                <button class="btn">
                    Выйти
                    <i class="fas fa-sign-out-alt"></i>
                </button>
            </form>
        </div>
        <div class="fk-list">
            <a href="#">Название ФК №1</a>
            <a href="#">Очень большое название ФК №2</a>
            <a href="#">Название ФК №3</a>
        </div>
    </aside>
    <section class="edit-info">
        <div class="content-offset">
            <p style="visibility: hidden; font-size: 1.5em;">КОСТЫЛЬ</p>
            <h1 class="fk-title">Мои курсы</h1>
            <section class="fk-container container-teacher">
                <section class="fk-item">
                    <div class="fk-item-container">
                        <div class="fk-info">
                            <h2 class="fk-title">Название ФК №1</h2>
                            <div class="fk-short-desc-container">
                                <p>Количество студентов: 19</p>
                                <p>Следующее занятие: 19.09.21</p>
                            </div>
                        </div>
                        <form class="fk-goto">
                            <button class="btn btn-default">Редактировать</button>
                        </form>
                    </div>
                </section>
                <section class="fk-item">
                    <div class="fk-item-container">
                        <div class="fk-info">
                            <h2 class="fk-title">Название ФК №2</h2>
                            <div class="fk-short-desc-container">
                                <p>Количество студентов: 19</p>
                                <p>Следующее занятие: 19.09.21</p>
                            </div>
                        </div>
                        <form class="fk-goto">
                            <button class="btn btn-default">Редактировать</button>
                        </form>
                    </div>
                </section>
                <section class="fk-item">
                    <div class="fk-item-container">
                        <div class="fk-info">
                            <h2 class="fk-title">Ооооооооооооооооооооооочень длинное название ФК №3</h2>
                            <div class="fk-short-desc-container">
                                <p>Количество студентов: 19</p>
                                <p>Следующее занятие: 19.09.21</p>
                            </div>
                        </div>
                        <form class="fk-goto">
                            <button class="btn btn-default">Редактировать</button>
                        </form>
                    </div>
                </section>
            </section>
        </div>
        <div class="edit-yulya"></div>
    </section>
</main>
</body>
</html>