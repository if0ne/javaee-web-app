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
    <nav>
        <div class="logo-container">
            <h1 class="logo">ELECTIVES</h1>
        </div>
    </nav>
    <main class="student-main">
        <div class="student-main-container">
            <aside class="student-aside">
                <h1 class="user-name">${user_last_name} ${user_first_name}</h1>
                <p class="role-label">${user_role}</p>
                <div class="student-aside-panel">
                    <form class="all-courses-form" action="/controller" method="get">
                        <input type="hidden" name="command" value="show_my_courses">
                        <button class="btn btn-default">Мои курсы</button>
                    </form>
                    <form class="logout-form" action="/controller" method="get">
                        <input type="hidden" name="command" value="logout">
                        <button class="btn">
                            Выйти
                            <i class="fas fa-sign-out-alt"></i>
                        </button>
                    </form>
                </div>
            </aside>
            <section class="fk-container">
                <c:forEach var="course" items="${courses}">
                    <section class="fk-item">
                        <div class="fk-item-container">
                            <div class="fk-info">
                                <h2 class="fk-title">${course.title}</h2>
                                <p class="role-label">${course.teacherLastName} ${course.teacherFirstName} ${course.teacherMiddleName}</p>
                                <div class="fk-short-desc-container">
                                    <p class="fk-short-desc">
                                        ${course.description}
                                    </p>
                                </div>
                            </div>
                            <form class="fk-goto" action="/controller" method="post">
                                <input type="hidden" name="command" value="subscribe">
                                <input type="hidden" name="course_id" value="${course.id}">
                                <button class="btn btn-subscribe">Записаться</button>
                            </form>
                        </div>
                    </section>
                </c:forEach>
        </div>
    </main>
</body>
</html>