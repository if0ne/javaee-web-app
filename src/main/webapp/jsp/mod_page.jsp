<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="data" scope="request" type="ru.rsreu.javaeewebapp.commands.outputs.ShowModPageOutput"/>
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
                <form class="logout-form tabletop-offset" action="/controller" method="get" style="margin: 0;">
                    <input type="hidden" name="command" value="logout">
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
                        <tbody
                            <c:forEach var="student" items="${data.students}">
                                <tr>
                                    <td class="table-cont left-info">${student.name}</td>
                                    <td class="table-cont">
                                            ${student.status ? "Заблокирован" : "Незаблокирован"}
                                    </td>
                                    <td class="table-cont">
                                        <form action="/controller" method="post">
                                            <input type="hidden" name="command" value="change_user_status">
                                            <input type="hidden" name="user_id" value="${student.id}">
                                            <input type="hidden" name="user_status" value="${student.status ? 1 : 0}">
                                            <button class="btn btn-danger">
                                                ${student.status ? "Разблокировать" : "Заблокировать" }
                                            </button>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </section>
            </div>
            <div class="edit-yulya"></div>
        </section>
    </main>
</body>
</html>