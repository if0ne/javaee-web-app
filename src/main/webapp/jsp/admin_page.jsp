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
                <h1 class="user-name" style="color: #FFF; display: block;">${user_last_name} ${user_first_name}</h1>
                <p class="role-label">${user_role}</p>
            </div>
            <div class="aside-menu">
                <form class="logout-form tabletop-offset" action="/controller" method="get" style="margin: 0;">
                    <input type="hidden" name="command" value="logout">
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
                    <form id="user-add" class="form-area" action="/controller" method="post">
                        <input type="hidden" name="command" value="create_user">
                        <div class="field-area">
                            <div class="edit-field">
                                <label for="user-second-name">Фамилия</label>
                                <input id="user-second-name" class="input-field" name="last_name"/>
                            </div>

                            <div class="edit-field">
                                <label for="user-first-name">Имя</label>
                                <input id="user-first-name" class="input-field" name="first_name"/>
                            </div>

                            <div class="edit-field">
                                <label for="user-middle-name">Отчество</label>
                                <input id="user-middle-name" class="input-field" name="middle_name"/>
                            </div>

                            <div class="edit-field">
                                <label for="user-role">Роль</label>
                                <select id="user-role" form="user-add" name="new_user_role" required>
                                    <option value="2">Модератор</option>
                                    <option value="1">Преподаватель</option>
                                    <option value="0">Студент</option>
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
                            <c:forEach var="user" items="${users}">
                                <tr>
                                    <td class="table-cont left-info">${user.lastName} ${user.firstName}</td>
                                    <td class="table-cont">${user.role}</td>
                                    <td class="table-cont">
                                        <form action="/controller" method="post">
                                            <input type="hidden" name="command" value="delete_user">
                                            <input type="hidden" name="delete_user_id" value="${user.id}">
                                            <button class="btn btn-danger">Удалить</button>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </section>
            </div>
            <div class="edit-yulya"></div>
        </section>
    </main>
</body>
</html>