--enter to system by login and password
select id_user, roles.name, last_name, first_name, middle_name, blocked
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
    select id_user, last_name, first_name, middle_name, roles.name as name
    from users inner join roles on users.role = roles.id_role 
    where roles.name <> 'Администратор'
    group by roles.name, last_name, first_name, middle_name, id_user
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
    --all students list with their current statuses
    select id_user, last_name, first_name, middle_name, blocked
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
    and classes.course_date = ?
    /
--get database information requests
    --get information about the course and the student progress (as well as a student)
    --get dates list (for progress table)
    select id_date, course_date
    from dates 
    where id_course = ?
    order by id_date asc
    /
    --get the teacher courses list
        --ADD NEXT DATE OF THE CLASS
         --, course_date as "next_date" = select course
    select id_course, name, count(id_student) as count
    from user_courses inner join courses on user_courses.id_course = courses.id_course
    where teacher = ?
    group by id_course, name
    /

--Student
--database change requests
    --register for a course
    insert into users_courses (id, id_student, id_course, id_rating) values (?, ?, ?, ?)
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
        select id_course, name, description, last_name, first_name, middle_name
        from courses inner join users on courses.teacher = users.id_user
        where id_course in (select id_course
                            from user_courses
                            where id_student = ?)
        /
        --get a courses list for which you are not registered
        select id_course, name, description, last_name, first_name, middle_name
        from courses inner join users on courses.teacher = users.id_user
        where id_course not in (select id_course
                            from user_courses
                            where id_student = ?)
        /
    --get information about the course
        --get information about the course
        select id_course, name, description, last_name, first_name, middle_name
        from courses inner join users on courses.teacher = users.id_user
        where courses.id_course = ?
        /
        
        --get students list with final grade on course
        select id_user, last_name, first_name, middle_name, final_grade
        from (user_courses inner join users on user_courses.id_student = users.id_user)
                inner join ratings on user_courses.id_rating = ratings.id_rating
        where user_courses.id_course = ?
        /
        
        --get students progress list on the course
        select grade, attendance
        from ((user_courses inner join ratings on user_courses.id_rating = ratings.id_rating)
                inner join classes on ratings.id_rating = classes.rating)
                inner join dates on dates.id_date = classes.course_date
        where user_courses.id_course = ? and user_courses.id_student = ?
        order by id_date asc
        /
        
        --get next date of teacher course
        select first_value(course_date)
        over (order by id_date asc) as next_date
        from dates
        where id_course = 0 and course_date >= current_date
        /
--additional requests to get the last id
--user id
select first_value(id_user)
over (order by id_user desc) as "id"
from users
/
--course id
select first_value(id_course)
over (order by id_course desc) as "id"
from courses
/
--date id
select first_value(id_date)
over (order by id_date desc) as "id"
from dates
/
--id_users_courses
select first_value(id)
over (order by id desc) as "id"
from user_courses
/
--rating id
select first_value(id_rating)
over (order by id_rating desc) as "id"
from ratings
/
--class id
select first_value(id_class)
over (order by id_class desc) as "id"
from classes
/
--request to determine an existing login
select id_user
from users
where ? not in (select login
                    from users)
/
    
    
    
