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
                <p class="role-label">Модератор</p>
            </div>
            <div class="aside-menu">
                <form class="logout-form tabletop-offset" style="margin: 0;">
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
                <h1 class="fk-title">Список студентов</h1>
                <section class="edit-block">
                    <table class="student-grades mod-table">
                        <thead>
                            <tr>
                                <th class="table-head left-info-head">ФИО</th>
                                <th class="table-head">Статус</th>
                                <th class="table-head"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td class="table-cont left-info">Агафонов Павел</td>
                                <td class="table-cont">Не заблокирован</td>
                                <td class="table-cont">
                                    <form>
                                        <button class="btn btn-danger">Заблокировать</button>
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td class="table-cont left-info">Агафонов Павел</td>
                                <td class="table-cont">Заблокирован</td>
                                <td class="table-cont">
                                    <form>
                                        <button class="btn btn-default">Разблокировать</button>
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td class="table-cont left-info">Агафонов Павел</td>
                                <td class="table-cont">Не заблокирован</td>
                                <td class="table-cont">
                                    <form>
                                        <button class="btn btn-danger">Заблокировать</button>
                                    </form>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </section>
            </div>
            <div class="edit-yulya"></div>
        </section>
    </main>
</body>
</html>