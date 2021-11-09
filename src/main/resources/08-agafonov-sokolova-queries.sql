--enter to system by login and password
select id_user, roles.name
from users inner join roles on users.role = roles.id_role
where login = ? and password = ?
/
--Administrator
--database change requests 
    --add user
    insert into users (id_user, login, password, last_name, first_name, middle_name, role)
    values (?, ?, ?, ?, ?, ?, ?)
    /
    --delete user
    delete from users
    where id_user = ?
    /
        --get role id by name
        select id_role
        from roles
        where name = ?
        /
--get database information requests
    --all system users list
    select last_name, first_name, middle_name, roles.name
    from users inner join roles on users.role = roles.id_role 
    where roles.name <> 'Администратор'
    group by roles.name, last_name, first_name, middle_name
    /
    
--Moderator
--database change requests
    --block user
    update users
    set blocked = 1
    where id_user = ?
    /
    --unblock user
    update users
    set blocked = 0
    where id_user = ?
    /
--get database information requests
    --список всех студентов с текущим статусом
    select last_name, first_name, middle_name, blocked
    from users inner join roles on users.role = roles.id_role 
    where roles.name = 'Студент'
    /

--Teacher
--database change requests
    --add course
    insert into courses (id_course, name, description, teacher) values (?, ?, ?, ?)
    /
    --add dates for a new course (after calculating dates from a range)
    --several records with different dates are added for one course
    insert into dates (id_date, course_date, id_course) values (?, ?, ?)
    /
    --expul of a student from the course (as well as a student)
    --add final grade for the student
    update ratings
    set final_grade = ?
    where ratings.id_rating = (select id_rating
                                from user_courses
                                where id_student = ? and id_course = ?)
    /
    --add information about the student (attendance and progress on a certain date)
    update classes
    set attendance = ?, grade = ?
    where classes.rating = (select id_rating from user_courses where id_student = ? and id_course = ?)
    and classes.course_date = (select id_date from dates where course_date = ? and id_course = ?)
    /
--get database information requests
    --get information about the course and the student progress (as well as a student)
    --get dates list (for progress table)
    select course_date from dates where id_course = ?
    /
    --get the teacher courses list
        --ADD NEXT DATE OF THE CLASS
    select name, count(id_student) as count
    from user_courses inner join courses on user_courses.id_course = courses.id_course
    where teacher = ?
    group by name
    order by name
    /

--Student
--database change requests
    --register for a course
    insert into users_courses (id, id_student, id_course, id_rating)
    values (?, ?, ?, ?)
    /
    --drop out from the course
    delete from ratings
    where id_rating = (select id_rating
                        from user_courses
                        where id_student = ? and id_course = ?)
    /
--get database information requests
    --get your courses list
    select name, description, last_name, first_name, middle_name
    from courses inner join users on courses.teacher = users.id_user
    where id_course in (select id_course
                        from user_courses
                        where id_student = ?)
    /
    --get all courses list
    
            --ADD NUMBER OF STUDENTS TO EACH COURSE AND SORT BY NUMBER
   
        --get a courses list for which you are registered
        select name, description, last_name, first_name, middle_name
        from courses inner join users on courses.teacher = users.id_user
        where id_course in (select id_course
                            from user_courses
                            where id_student = ?) 
        /
        --get a courses list for which you are not registered
        select name, description, last_name, first_name, middle_name
        from courses inner join users on courses.teacher = users.id_user
        where id_course not in (select id_course
                            from user_courses
                            where id_student = ?)
        /
    --get information about the course
        --get information about the course
        select name, description, last_name, first_name, middlename
        from courses inner join users on courses.teacher = users.id_user
        where courses.id_course = ?
        /
        --get students progress list on the course
        select last_name, first_name, middle_name, final_grade, dates.course_date, grade, attendance
        from (((user_courses inner join users on user_courses.id_student = users.id_user)
                inner join ratings on user_courses.id_rating = ratings.id_rating)
                inner join classes on ratings.id_rating = classes.rating)
                inner join dates on dates.id_date = classes.course_date
        where user_courses.id_course = ?
        /
--additional requests to get the last id
--user id
select id_user
from (select id_user from users order by id_user desc)
where rownum = 1
/
--course id
select id_course
from (select id_course from courses order by id_course desc)
where rownum = 1
/
--date id
select id_date
from (select id_date from dates order by id_date desc)
where rownum = 1
/
--id_users_courses
select id
from (select id from user_courses order by id desc)
where rownum = 1
/
--rating id
select id_rating
from (select id_rating from ratings order by id_rating desc)
where rownum = 1
/
--class id
select id_class
from (select id_class from classes order by id_class desc)
where rownum = 1
/
    
    
    
    
