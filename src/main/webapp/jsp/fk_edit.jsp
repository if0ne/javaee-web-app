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
                <form class="all-courses-form" action="/controller" method="get">
                    <input type="hidden" name="command" value="show_my_courses">
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
                <c:forEach var="link" items="${teacher_courses}">
                    <a
                            href="/controller?command=show_detailed_course&course_id=${link.id}"
                            class="${course.id == link.id ? "selected-fk" : ""}"
                    >
                        ${link.title}
                    </a>
                </c:forEach>
            </div>
        </aside>
        <section class="edit-info">
            <div class="content-offset">
                <p style="visibility: hidden; font-size: 1.5em;">КОСТЫЛЬ</p>
                <h1 class="fk-title">${course.title}</h1>
                <section class="edit-block">
                    <h2 class="fk-section-title">Обновление информации о студенте</h2>
                    <form id="update-student-info" class="form-area" action="/controller" method="post">
                        <input type="hidden" name="command" value="edit_user">
                        <div class="field-area">
                            <div class="edit-field">
                                <label for="update-student-name">Студент</label>
                                <select id="update-student-name" form="update-student-info" name="name" required>
                                    <c:forEach var="student" items="${students}">
                                        <option value="${student.id}">${student.lastName} ${student.firstName}</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="edit-field">
                                <label for="update-student-date">Дата занятия</label>
                                <select id="update-student-date" form="update-student-info" name="date" required>
                                    <c:forEach var="date" items="${dates}">
                                        <option value="${date.id}">date.date</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="edit-field">
                                <label for="update-student-attendance">Посещаемость</label>
                                <select id="update-student-attendance" form="update-student-info" name="attendance" required>
                                    <option value="0">Присутствие</option>
                                    <option value="1">Уважительная причина</option>
                                    <option value="2">Прогул</option>
                                </select>
                            </div>

                            <div class="edit-field">
                                <label for="update-student-grade">Оценка</label>
                                <select id="update-student-grade" form="update-student-info" name="grade" required>
                                    <option value="0">2</option>
                                    <option value="1">3</option>
                                    <option value="2">4</option>
                                    <option value="3">5</option>
                                </select>
                            </div>
                        </div>
                        <button class="btn btn-default btn-edit">Обновить</button>
                    </form>
                </section>
                <hr>
                <section class="edit-block">
                    <h2 class="fk-section-title">Итоговые оценки</h2>
                    <form id="update-student-final-grade" class="form-area" action="/controller" method="post">
                        <input type="hidden" name="command" value="edit_grade">
                        <div class="field-area">
                            <div class="edit-field">
                                <label for="update-student-final-name">Студент</label>
                                <select id="update-student-final-name" form="update-student-final-grade" name="name" required>
                                    <c:forEach var="student" items="${students}">
                                        <option value="${student.id}">${student.lastName} ${student.firstName}</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="edit-field">
                                <label for="update-student-final-date">Оценка</label>
                                <select id="update-student-final-date" form="update-student-info" name="grade" required>
                                    <option value="0">Незачтено</option>
                                    <option value="1">Зачтено</option>
                                </select>
                            </div>

                            <!--Тоже костыль-->
                            <div class="edit-field">
                            </div>
                            <div class="edit-field">
                            </div>
                        </div>
                        <button class="btn btn-default btn-edit">Обновить</button>
                    </form>
                </section>
                <hr>
                <section class="edit-block">
                    <h2 class="fk-section-title">Студенты</h2>
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
                <section class="edit-block">
                    <h2 class="fk-section-title">Отчисление</h2>
                    <form id="delete-student" class="form-area" action="/controller" method="post">
                        <input type="hidden" name="command" value="remove_student">
                        <div class="field-area">
                            <div class="edit-field">
                                <label for="delete-select">Студент</label>
                                <select id="delete-select" form="delete-student" name="name" required>
                                    <c:forEach var="student" items="${students}">
                                        <option value="${student.id}">${student.lastName} ${student.firstName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <button class="btn btn-danger btn-edit">Отчислить</button>
                    </form>
                </section>
            </div>
            <div class="edit-yulya"></div>
        </section>
    </main>
</body>
</html>