<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="data" scope="request" type="ru.rsreu.javaeewebapp.commands.outputs.ShowStudentPageOutput"/>
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
                <h1 class="user-name">${sessionScope.userLastName} ${sessionScope.userFirstName}</h1>
                <p class="role-label">${sessionScope.roleName}</p>
                <div class="student-aside-panel">
                    <form class="all-courses-form" action="/controller" method="get">
                        <input type="hidden" name="command" value="show_all_courses">
                        <button class="btn btn-default">Все курсы</button>
                    </form>
                    <form class="logout-form" action="/controller" method="post">
                        <input type="hidden" name="command" value="logout">
                        <button class="btn">
                            Выйти
                            <i class="fas fa-sign-out-alt"></i>
                        </button>
                    </form>
                </div>
                <div class="student-fk-list">
                    <c:forEach var="link" items="${data.courses}">
                        <a href="/controller?command=show_student_detailed_course&course_id=${link.id}">${link.title}</a>
                    </c:forEach>
                </div>
            </aside>
            <section class="fk-container">
                <c:choose>
                    <c:when test="${data.courses.size() > 0}">
                        <c:forEach var="course" items="${data.courses}">
                            <section class="fk-item">
                                <div class="fk-item-container">
                                    <div class="fk-info">
                                        <h2 class="fk-title">${course.title}</h2>
                                        <p class="role-label">${course.teacherName}</p>
                                        <div class="fk-short-desc-container">
                                            <p class="fk-short-desc">
                                                    ${course.description}
                                            </p>
                                        </div>
                                    </div>
                                    <form class="fk-goto" action="/controller" method="get">
                                        <input type="hidden" name="command" value="show_student_detailed_course">
                                        <input type="hidden" name="course_id" value="${course.id}">
                                        <button class="btn btn-default">Подробнее</button>
                                    </form>
                                </div>
                            </section>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <p>Вы еще никуда не записаны</p>
                    </c:otherwise>
                </c:choose>
            </section>
        </div>
    </main>
</body>
</html>