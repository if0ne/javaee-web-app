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
                <p class="role-label">Преподаватель</p>
            </div>
            <div class="aside-menu">
                <form class="all-courses-form">
                    <button class="btn btn-default">Мои курсы</button>
                </form>
                <form class="logout-form tabletop-offset">
                    <button class="btn">
                        Выйти
                        <i class="fas fa-sign-out-alt"></i>
                    </button>
                </form>
                <form class="form-helper">
                </form>
            </div>
            <div class="fk-list">
                <a href="#" class="selected-fk">Название ФК №1</a>
                <a href="#">Очень большое название ФК №2</a>
                <a href="#">Название ФК №3</a>
            </div>
        </aside>
        <section class="edit-info">
            <div class="content-offset">
                <p style="visibility: hidden; font-size: 1.5em;">КОСТЫЛЬ</p>
                <h1 class="fk-title">Название ФК №1</h1>
                <section class="edit-block">
                    <h2 class="fk-section-title">Обновление информации о студенте</h2>
                    <form id="update-student-info" class="form-area">
                        <div class="field-area">
                            <div class="edit-field">
                                <label for="update-student-name">Студент</label>
                                <select id="update-student-name" form="update-student-info" required>
                                </select>
                            </div>

                            <div class="edit-field">
                                <label for="update-student-date">Дата занятия</label>
                                <select id="update-student-date" form="update-student-info" required>
                                </select>
                            </div>

                            <div class="edit-field">
                                <label for="update-student-attendance">Посещаемость</label>
                                <select id="update-student-attendance" form="update-student-info" required>
                                </select>
                            </div>

                            <div class="edit-field">
                                <label for="update-student-grade">Оценка</label>
                                <select id="update-student-grade" form="update-student-info" required>
                                </select>
                            </div>
                        </div>
                        <button class="btn btn-default btn-edit">Обновить</button>
                    </form>
                </section>
                <hr>
                <section class="edit-block">
                    <h2 class="fk-section-title">Итоговые оценки</h2>
                    <form id="update-student-final-grade" class="form-area">
                        <div class="field-area">
                            <div class="edit-field">
                                <label for="update-student-final-name">Студент</label>
                                <select id="update-student-final-name" form="update-student-final-grade" required>
                                </select>
                            </div>

                            <div class="edit-field">
                                <label for="update-student-final-date">Оценка</label>
                                <select id="update-student-final-date" form="update-student-info" required>
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
                                <th class="table-head">25.02.21</th>
                                <th class="table-head">25.02.21</th>
                                <th class="table-head">25.02.21</th>
                                <th class="table-head">25.02.21</th>
                                <th class="table-head">25.02.21</th>
                                <th class="table-head">25.02.21</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td class="table-cont left-info">Агафонов Павел</td>
                                <td class="table-cont">Зачтено</td>
                                <td class="table-cont skipped"></td>
                                <td class="table-cont">3</td>
                                <td class="table-cont official"></td>
                                <td class="table-cont">5</td>
                                <td class="table-cont">5</td>
                                <td class="table-cont">5</td>
                            </tr>
                            <tr>
                                <td class="table-cont left-info">Агафонов Павел</td>
                                <td class="table-cont">Зачтено</td>
                                <td class="table-cont skipped"></td>
                                <td class="table-cont">3</td>
                                <td class="table-cont official"></td>
                                <td class="table-cont">5</td>
                                <td class="table-cont">5</td>
                                <td class="table-cont">5</td>
                            </tr>
                            <tr>
                                <td class="table-cont left-info">Агафонов Павел</td>
                                <td class="table-cont">Зачтено</td>
                                <td class="table-cont skipped"></td>
                                <td class="table-cont">3</td>
                                <td class="table-cont official"></td>
                                <td class="table-cont">5</td>
                                <td class="table-cont">5</td>
                                <td class="table-cont">5</td>
                            </tr>
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
                    <form id="delete-student" class="form-area">
                        <div class="field-area">
                            <div class="edit-field">
                                <label for="delete-select">Студент</label>
                                <select id="delete-select" form="delete-student" required>
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