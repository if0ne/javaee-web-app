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
        <div class="aside-menu single-form">
            <form class="logout-form" action="/controller" method="get">
                <input type="hidden" name="command" value="show_create_page">
                <button class="btn btn-default">
                    Создать
                </button>
            </form>
            <form class="logout-form" action="/controller" method="get">
                <input type="hidden" name="command" value="logout">
                <button class="btn">
                    Выйти
                    <i class="fas fa-sign-out-alt"></i>
                </button>
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
            <h1 class="fk-title">Мои курсы</h1>
            <section class="fk-container container-teacher">
                <c:choose>
                    <c:when test="${data.courses.size() > 0}">
                        <c:forEach var="course" items="${data.courses}">
                            <section class="fk-item">
                                <div class="fk-item-container">
                                    <div class="fk-info">
                                        <h2 class="fk-title">${course.title}</h2>
                                        <div class="fk-short-desc-container">
                                            <p>Количество студентов: ${course.studentsNumber}</p>
                                            <p>Следующее занятие: ${course.nextClassDate == "" ? "Занятий нет" : course.nextClassDate}</p>
                                        </div>
                                    </div>
                                    <form class="fk-goto" action="/controller" method="get">
                                        <input type="hidden" name="command" value="edit_course">
                                        <input type="hidden" name="course_id" value="${course.id}">
                                        <button class="btn btn-default">Редактировать</button>
                                    </form>
                                </div>
                            </section>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <p>Вы еще не создали ни одного курса</p>
                    </c:otherwise>
                </c:choose>
            </section>
        </div>
        <div class="edit-yulya"></div>
    </section>
</main>
</body>
</html>