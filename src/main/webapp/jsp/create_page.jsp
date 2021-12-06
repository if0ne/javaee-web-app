<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="data" scope="request" type="ru.rsreu.javaeewebapp.commands.outputs.ShowTeacherPageOutput"/>
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
                <form class="all-courses-form" action="/controller" method="get">
                    <input type="hidden" name="command" value="show_teacher_page">
                    <button class="btn btn-default">Мои курсы</button>
                </form>
                <form class="logout-form tabletop-offset" action="/controller" method="get">
                    <input type="hidden" name="command" value="logout">
                    <button class="btn">
                        Выйти
                        <i class="fas fa-sign-out-alt"></i>
                    </button>
                </form>
                <form class="form-helper">
                </form>
            </div>
            <div class="fk-list">
                <c:forEach var="link" items="${data.courses}">
                    <a href="/controller?command=edit_course&course_id=${link.id}">${link.title}</a>
                </c:forEach>
            </div>
        </aside>
        <section class="edit-info">
            <div class="content-offset">
                <p style="visibility: hidden; font-size: 1.5em;">КОСТЫЛЬ</p>
                <h1 class="fk-title">Создание</h1>
                <section class="edit-block">
                    <form id="create-form" action="/controller" method="post">
                        <input type="hidden" name="command" value="create_course">
                        <div class="new-field">
                            <label for="name">Наименование факультета:</label>
                            <input id="name" class="input-field" name="title"/>
                        </div>

                        <div class="new-field">
                            <label for="begin">Дата начала:</label>
                            <input id="begin" type="date" value="2001-01-01" class="date" name="begin"/>
                        </div>

                        <div class="new-field">
                            <label for="end">Дата окончания:</label>
                            <input id="end"  type="date" value="2001-01-01" class="date" name="end"/>
                        </div>

                        <div class="new-field">
                            <label for="day">День недели занятий:</label>
                            <select id="day" form="create-form" name="day" required>
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
<textarea id="desc" name="description" form="create-form">
</textarea>
                        </div>

                        <div class="new-field">
                            <label></label>
                            <button class="btn btn-default btn-edit">Создать</button>
                        </div>
                    </form>
                    <p class="error-message">
                        ${wrongTitle}
                    </p>
                    <p class="error-message">
                        ${wrongDates}
                    </p>
                </section>
            </div>
            <div class="edit-yulya"></div>
        </section>
    </main>
</body>
</html>