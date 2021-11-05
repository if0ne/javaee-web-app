--АДМИНИСТРАТОР
--Запросы на изменение БД
    --Добавить пользователя
    insert into users (id_user, login, password, last_name, first_name, middle_name, role)
    values (?, ?, ?, ?, ?, ?, ?)
    /
    --Удалить пользователя
    delete from users
    where id_user = ?
    /
        --запрос на получение id роли по имени (пусть пока тут будет, если что удалю)
        select id_role
        from roles
        where name = ?
        /
--Запросы на получение информации из БД
    --Список всех пользователей системы
    select last_name, first_name, middle_name, roles.name
    from users inner join roles on users.role = roles.id_role 
    where roles.name <> 'Администратор'
    group by roles.name, last_name, first_name, middle_name
    /
    
--МОДЕРАТОР
--Запросы на изменение БД
    --Заблокировать пользователя
    update users
    set blocked = 1
    where id_user = ?
    /
    --Разблокировать пользователя
    update users
    set blocked = 0
    where id_user = ?
    /
--Запросы на получение информации из БД
    --список всех студентов с текущим статусом
    select last_name, first_name, middle_name, blocked
    from users inner join roles on users.role = roles.id_role 
    where roles.name = 'Студент'
    /

--ПРЕПОДАВАТЕЛЬ
--Запросы на изменение БД
    --добавление курса
    insert into courses (id_course, name, description, teacher) values (?, ?, ?, ?)
    /
    --добавление дат нового курса (после вычисления дат из промежутка)
    --для одного курса добавляется несколько записей с разными датами
    insert into dates (id_date, course_date, id_course) values (?, ?, ?)
    /
    --отчисление студента с курса (также как и у студента)
    --добавление итоговой оценки студенту
    update ratings
    set final_grade = ?
    where ratings.id_rating = (select id_rating
                                from user_courses
                                where id_student = ? and id_course = ?)
    /
    --добавление информации о студенте (успеваемости и посещаемости в определённую дату)
    update classes
    set attendance = ?, grade = ?
    where classes.rating = (select id_rating from user_courses where id_student = ? and id_course = ?)
    and classes.course_date = (select id_date from dates where course_date = ? and id_course = ?)
    /
--Запросы на получение информации из БД
    --информация о конкретном курсе и успеваемости студентов (также как и у студента)
    --получить список дат(для таблицы успеваемости)
    select course_date from dates where id_course = ?
    /
    --список курсов преподавателя
        --ДОБАВИТЬ СЛЕДУЮЩУЮ ДАТУ ЗАНЯТИЯ
    select name, last_name, first_name, middle_name, count(id_student) as count
    from (user_courses inner join courses on user_courses.id_course = courses.id_course) inner join users on courses.teacher = users.id_user
    where teacher = ?
    group by name, last_name, first_name, middle_name
    order by name
    /

--СТУДЕНТ
--Запросы на изменение БД
    --записаться на курс (новые id и id_rating вычисляются отдельно)
    insert into users_courses (id, id_student, id_course, id_rating)
    values (?, ?, ?, ?)
    /
    --отчисление с курса
    delete from user_courses
    where id_student = ? and id_course = ?
    /
    --при каскадном удалении(чтобы удалить и всю информацию об оценках, и о студенте на курсе) (лучше этот вариант)
    delete from ratings
    where id_rating = (select id_rating
                        from user_courses
                        where id_student = ? and id_course = ?)
    /
--Запросы на получение информации из БД
    --Получить свои курсы
    select name, description, last_name, first_name, middle_name
    from courses inner join users on courses.teacher = users.id_user
    where id_course in (select id_course
                        from user_courses
                        where id_student = ?)
    /
    --получить все курсы
    
            --ДОБАВИТЬ КОЛИЧЕСТВО СТУДЕНТОВ У КАЖДОГО КУРСА И СОРТИРОВКУ ПО КОЛИЧЕСТВУ
   
        --курсы, на которые записан
        select name, description, last_name, first_name, middle_name
        from courses inner join users on courses.teacher = users.id_user
        where id_course in (select id_course
                            from user_courses
                            where id_student = ?) 
        /
        --курсы, на которые не записан
        select name, description, last_name, first_name, middle_name
        from courses inner join users on courses.teacher = users.id_user
        where id_course not in (select id_course
                            from user_courses
                            where id_student = ?)
        /
    --получить информацию о курсе
        --информация о конкрентом курсе
        select name, description, last_name, first_name, middlename
        from courses inner join users on courses.teacher = users.id_user
        where courses.id_course = ?
        /
        --успеваемость студентов на курсе
        select last_name, first_name, middle_name, final_grade, dates.course_date, grade, attendance
        from (((user_courses inner join users on user_courses.id_student = users.id_user)
                inner join ratings on user_courses.id_rating = ratings.id_rating)
                inner join classes on ratings.id_rating = classes.rating)
                inner join dates on dates.id_date = classes.course_date
        where user_courses.id_course = ?
        /
--доп. запросы для получения последнего id
--id пользователя
select id_user
from (select id_user from users order by id_user desc)
where rownum = 1
/
--id курса
select id_course
from (select id_course from courses order by id_course desc)
where rownum = 1
/
--id даты
select id_date
from (select id_date from dates order by id_date desc)
where rownum = 1
/
--id_users_courses
select id
from (select id from user_courses order by id desc)
where rownum = 1
/
--id рейтинга
select id_rating
from (select id_rating from ratings order by id_rating desc)
where rownum = 1
/
--id класса
select id_class
from (select id_class from classes order by id_class desc)
where rownum = 1
/
    
    
    
    
