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
                <p class="role-label">Администратор</p>
            </div>
            <div class="aside-menu">
                <form class="logout-form tabletop-offset" style="margin: 0;">
                    <button class="btn">
                        Выйти
                        <i class="fas fa-sign-out-alt"></i>
                    </button>
                </form>
                <form class="form-helper">
                </form>
            </div>
        </aside>
        <section class="edit-info">
            <div class="content-offset">
                <p style="visibility: hidden; font-size: 1.5em;">КОСТЫЛЬ</p>
                <h1 class="fk-title">Пользователи</h1>
                <section class="edit-block">
                    <h2 class="fk-section-title">Добавление пользователя</h2>
                    <form id="user-add" class="form-area">
                        <div class="field-area">
                            <div class="edit-field">
                                <label for="user-second-name">Фамилия</label>
                                <input id="user-second-name" class="input-field"/>
                            </div>

                            <div class="edit-field">
                                <label for="user-first-name">Имя</label>
                                <input id="user-first-name" class="input-field"/>
                            </div>

                            <div class="edit-field">
                                <label for="user-middle-name">Отчество</label>
                                <input id="user-middle-name" class="input-field"/>
                            </div>

                            <div class="edit-field">
                                <label for="user-role">Роль</label>
                                <select id="user-role" form="user-add" required>
                                    <option>Модератор</option>
                                    <option>Преподаватель</option>
                                    <option>Студент</option>
                                </select>
                            </div>
                        </div>
                        <button class="btn btn-default btn-edit">Добавить</button>
                    </form>
                </section>
                <hr>
                <section class="edit-block">
                    <h2 class="fk-section-title">Список пользователей</h2>
                    <table class="student-grades">
                        <thead>
                            <tr>
                                <th class="table-head left-info-head">ФИО</th>
                                <th class="table-head">Роль</th>
                                <th class="table-head"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td class="table-cont left-info">Агафонов Павел</td>
                                <td class="table-cont">Студент</td>
                                <td class="table-cont">
                                    <form>
                                        <button class="btn btn-danger">Удалить</button>
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td class="table-cont left-info">Агафонов Павел</td>
                                <td class="table-cont">Преподаватель</td>
                                <td class="table-cont">
                                    <form>
                                        <button class="btn btn-danger">Удалить</button>
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td class="table-cont left-info">Агафонов Павел</td>
                                <td class="table-cont">Модератор</td>
                                <td class="table-cont">
                                    <form>
                                        <button class="btn btn-danger">Удалить</button>
                                    </form>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </section>
            </div>
            <div class="edit-yulya"></div>
        </section>
    </main>
</body>
</html>