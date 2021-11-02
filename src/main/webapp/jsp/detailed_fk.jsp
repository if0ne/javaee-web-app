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
                <h1 class="user-name">Агафонов Павел</h1>
                <p class="role-label">Студент</p>
                <div class="student-aside-panel">
                    <form class="all-courses-form">
                        <button class="btn btn-default">Мои курсы</button>
                    </form>
                    <form class="logout-form">
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
                        <h1 class="fk-title">Название ФК №1</h1>
                        <p class="role-label">Преподаватель</p>
                        <p class="fk-desc">
                            Это описание. Это описание. Это описание. Это описание. Это описание. Это описание. Это описание. Это описание.
                            Это описание. Это описание. Это описание. Это описание. Это описание. Это описание. Это описание. Это описание.
                            Это описание. Это описание. Это описание. Это описание. Это описание. Это описание. Это описание. Это описание.
                            Это описание. Это описание. Это описание. Это описание. Это описание. Это описание. Это описание. Это описание.
                            Это описание. Это описание. Это описание. Это описание. Это описание. Это описание. Это описание. Это описание.
                            Это описание. Это описание. Это описание. Это описание. Это описание. Это описание. Это описание. Это описание.
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
                    <section class="part-info">
                        <h2 class="fk-section-title">Отчисление</h2>
                        <form id="delete-student" class="form-area">
                            <button class="btn btn-danger btn-leave">Отчислиться</button>
                        </form>
                    </section>
                </section>
            </div>
        </div>
    </main>
</body>
</html>