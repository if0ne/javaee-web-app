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
            <div class="aside-menu">
                <form class="all-courses-form">
                    <button class="btn btn-default">Мои курсы</button>
                </form>
                <form class="logout-form tabletop-offset">
                    <button class="btn">
                        Выйти
                        <i class="fas fa-sign-out-alt"></i>
                    </button>
                </form>
                <form class="form-helper">
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
                <h1 class="fk-title">Создание</h1>
                <section class="edit-block">
                    <form id="create-form">
                        <div class="new-field">
                            <label for="name">Наименование факультета:</label>
                            <input id="name" class="input-field"/>
                        </div>

                        <div class="new-field">
                            <label for="begin">Дата начала:</label>
                            <input id="begin" type="date" value="2001-01-01" class="date"/>
                        </div>

                        <div class="new-field">
                            <label for="end">Дата окончания:</label>
                            <input id="end"  type="date" value="2001-01-01" class="date"/>
                        </div>

                        <div class="new-field">
                            <label for="day">День недели занятий:</label>
                            <select id="day" form="create-form" required>
                                <option value="1">Понедельник</option>
                                <option value="2">Вторник</option>
                                <option value="3">Среда</option>
                                <option value="4">Четверг</option>
                                <option value="5">Пятница</option>
                                <option value="6">Суббота</option>
                                <option value="7">Воскресенье</option>
                            </select>
                        </div>

                        <div class="new-field">
                            <label for="desc" class="no-align">Описание:</label>
                            <textarea id="desc" name="desc" form="create-form">
                            </textarea>
                        </div>

                        <div class="new-field">
                            <label></label>
                            <button class="btn btn-default btn-edit">Создать</button>
                        </div>
                    </form>
                </section>
            </div>
            <div class="edit-yulya"></div>
        </section>
    </main>
</body>
</html>