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
        <div class="aside-menu single-form">
            <form class="logout-form" action="/controller" method="get">
                <input type="hidden" name="command" value="logout">
                <button class="btn">
                    Выйти
                    <i class="fas fa-sign-out-alt"></i>
                </button>
            </form>
        </div>
        <div class="fk-list">
            <c:forEach var="link" items="${teacher_courses}">
                <a href="/controller?command=show_detailed_course&course_id=${link.id}">${link.title}</a>
            </c:forEach>
        </div>
    </aside>
    <section class="edit-info">
        <div class="content-offset">
            <p style="visibility: hidden; font-size: 1.5em;">КОСТЫЛЬ</p>
            <h1 class="fk-title">Мои курсы</h1>
            <section class="fk-container container-teacher">
                <c:forEach var="course" items="${teacher_courses}">
                    <section class="fk-item">
                        <div class="fk-item-container">
                            <div class="fk-info">
                                <h2 class="fk-title">${course.title}</h2>
                                <div class="fk-short-desc-container">
                                    <p>Количество студентов: ${course.studentCount}</p>
                                    <p>Следующее занятие: ${course.nextDate}</p>
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
            </section>
        </div>
        <div class="edit-yulya"></div>
    </section>
</main>
</body>
</html>