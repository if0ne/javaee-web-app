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
            <div class="info-container">
                <section class="fk-info">
                    <section class="part-info">
                        <h1 class="fk-title">${course.title}</h1>
                        <p class="role-label">${course.teacherLastName} ${course.teacherFirstName} ${course.teacherMiddleName}</p>
                        <p class="fk-desc">
                            ${course.description}
                        </p>
                    </section>
                    <hr>
                    <section class="part-info">
                        <h2 class="fk-section-title">Успеваемость</h2>
                        <table class="student-grades">
                            <thead>
                            <tr>
                                <th class="table-head left-info-head">ФИО</th>
                                <th class="table-head">Итоговая оценка</th>
                                <c:forEach var="date" items="${dates}">
                                    <th class="table-head">date.date</th>
                                </c:forEach>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="student" items="${students}">
                                <tr>
                                    <td class="table-cont left-info">${student.lastName} ${student.firstName}</td>
                                    <td class="table-cont">${student.finalGrade}</td>
                                    <c:forEach var="attendance" items="${student.progresses}">
                                        <td class="table-cont
                                            ${attendance.status == 0 ? "" :
                                            attendance.status == 1 ? "official" : "skipped"
                                        }">
                                                ${attendance.grade}
                                        </td>
                                    </c:forEach>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <div class="hints">
                            <div class="hint">
                                <span class="skipped" style="display: inline-block; width: 30px; height: 30px"></span>
                                <span class="hint-text"> - прогул</span>
                            </div>
                            <div class="hint">
                                <span class="official" style="display: inline-block; width: 30px; height: 30px"></span>
                                <span class="hint-text"> - уважительная причина</span>
                            </div>
                        </div>
                    </section>
                    <hr>
                    <section class="part-info">
                        <h2 class="fk-section-title">Отчисление</h2>
                        <form id="delete-student" class="form-area" action="/controller" method="post">
                            <input type="hidden" name="command" value="killme">
                            <button class="btn btn-danger btn-leave">Отчислиться</button>
                        </form>
                    </section>
                </section>
            </div>
        </div>
    </main>
</body>
</html>