<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="data" scope="request" type="ru.rsreu.javaeewebapp.commands.outputs.ShowAdminPageOutput"/>
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
                <h1 class="user-name" style="color: #FFF; display: block;">${sessionScope.userLastName} ${sessionScope.userFirstName}</h1>
                <p class="role-label">${sessionScope.roleName}</p>
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
                                    <option value="1">Модератор</option>
                                    <option value="2">Преподаватель</option>
                                    <option value="3">Студент</option>
                                </select>
                            </div>

                            <div class="edit-field">
                                <label for="user-middle-name">Логин</label>
                                <input id="user-login" class="input-field" name="user_login"/>
                            </div>

                            <div class="edit-field">
                                <label for="user-middle-name">Пароль</label>
                                <input type="password" id="user-password" class="input-field" name="user_password"/>
                            </div>

                            <!--<div class="edit-field helper">
                                <label for="user-middle-name">Костыль</label>
                                <input type="password" class="input-field"/>
                            </div>

                            <div class="edit-field helper">
                                <label for="user-middle-name">Костыль</label>
                                <input type="password" class="input-field"/>
                            </div>-->
                        </div>
                        <button class="btn btn-default btn-edit">Добавить</button>
                    </form>
                    <p class="error-message">
                        ${wrongInputData}
                    </p>
                </section>
                <hr>
                <section class="edit-block">
                    <h2 class="fk-section-title">Список пользователей</h2>
                    <c:choose>
                        <c:when test="${data.allUsers.size() > 0}">
                            <table class="student-grades">
                                <thead>
                                <tr>
                                    <th class="table-head left-info-head">ФИО</th>
                                    <th class="table-head">Логин</th>
                                    <th class="table-head">Роль</th>
                                    <th class="table-head">Статус</th>
                                    <th class="table-head"></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="user" items="${data.allUsers}">
                                    <tr>
                                        <td class="table-cont left-info">${user.fullName}</td>
                                        <td class="table-cont">${user.login}</td>
                                        <td class="table-cont">${user.role}</td>
                                        <td class="table-cont">${user.logged ? "Онлайн" : "Оффлайн" }</td>
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
                        </c:when>
                        <c:otherwise>
                            <p>Список пользователей пуст</p>
                        </c:otherwise>
                    </c:choose>
                </section>
            </div>
            <div class="edit-yulya"></div>
        </section>
    </main>
</body>
</html>