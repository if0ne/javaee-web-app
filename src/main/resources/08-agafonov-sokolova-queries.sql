--�������������
--������� �� ��������� ��
    --�������� ������������
    insert into users (id_user, login, password, last_name, first_name, middle_name, role)
    values (?, ?, ?, ?, ?, ?, ?)
    /
    --������� ������������
    delete from users
    where id_user = ?
    /
        --������ �� ��������� id ���� �� ����� (����� ���� ��� �����, ���� ��� �����)
        select id_role
        from roles
        where name = ?
        /
--������� �� ��������� ���������� �� ��
    --������ ���� ������������� �������
    select last_name, first_name, middle_name, roles.name
    from users inner join roles on users.role = roles.id_role 
    where roles.name <> '�������������'
    group by roles.name, last_name, first_name, middle_name
    /
    
--���������
--������� �� ��������� ��
    --������������� ������������
    update users
    set blocked = 1
    where id_user = ?
    /
    --�������������� ������������
    update users
    set blocked = 0
    where id_user = ?
    /
--������� �� ��������� ���������� �� ��
    --������ ���� ��������� � ������� ��������
    select last_name, first_name, middle_name, blocked
    from users inner join roles on users.role = roles.id_role 
    where roles.name = '�������'
    /

--�������������
--������� �� ��������� ��
    --���������� �����
    insert into courses (id_course, name, description, teacher) values (?, ?, ?, ?)
    /
    --���������� ��� ������ ����� (����� ���������� ��� �� ����������)
    --��� ������ ����� ����������� ��������� ������� � ������� ������
    insert into dates (id_date, course_date, id_course) values (?, ?, ?)
    /
    --���������� �������� � ����� (����� ��� � � ��������)
    --���������� �������� ������ ��������
    update ratings
    set final_grade = ?
    where ratings.id_rating = (select id_rating
                                from user_courses
                                where id_student = ? and id_course = ?)
    /
    --���������� ���������� � �������� (������������ � ������������ � ����������� ����)
    update classes
    set attendance = ?, grade = ?
    where classes.rating = (select id_rating from user_courses where id_student = ? and id_course = ?)
    and classes.course_date = (select id_date from dates where course_date = ? and id_course = ?)
    /
--������� �� ��������� ���������� �� ��
    --���������� � ���������� ����� � ������������ ��������� (����� ��� � � ��������)
    --�������� ������ ���(��� ������� ������������)
    select course_date from dates where id_course = ?
    /
    --������ ������ �������������
        --�������� ��������� ���� �������
    select name, last_name, first_name, middle_name, count(id_student) as count
    from (user_courses inner join courses on user_courses.id_course = courses.id_course) inner join users on courses.teacher = users.id_user
    where teacher = ?
    group by name, last_name, first_name, middle_name
    order by name
    /

--�������
--������� �� ��������� ��
    --���������� �� ���� (����� id � id_rating ����������� ��������)
    insert into users_courses (id, id_student, id_course, id_rating)
    values (?, ?, ?, ?)
    /
    --���������� � �����
    delete from user_courses
    where id_student = ? and id_course = ?
    /
    --��� ��������� ��������(����� ������� � ��� ���������� �� �������, � � �������� �� �����) (����� ���� �������)
    delete from ratings
    where id_rating = (select id_rating
                        from user_courses
                        where id_student = ? and id_course = ?)
    /
--������� �� ��������� ���������� �� ��
    --�������� ���� �����
    select name, description, last_name, first_name, middle_name
    from courses inner join users on courses.teacher = users.id_user
    where id_course in (select id_course
                        from user_courses
                        where id_student = ?)
    /
    --�������� ��� �����
    
            --�������� ���������� ��������� � ������� ����� � ���������� �� ����������
   
        --�����, �� ������� �������
        select name, description, last_name, first_name, middle_name
        from courses inner join users on courses.teacher = users.id_user
        where id_course in (select id_course
                            from user_courses
                            where id_student = ?) 
        /
        --�����, �� ������� �� �������
        select name, description, last_name, first_name, middle_name
        from courses inner join users on courses.teacher = users.id_user
        where id_course not in (select id_course
                            from user_courses
                            where id_student = ?)
        /
    --�������� ���������� � �����
        --���������� � ���������� �����
        select name, description, last_name, first_name, middlename
        from courses inner join users on courses.teacher = users.id_user
        where courses.id_course = ?
        /
        --������������ ��������� �� �����
        select last_name, first_name, middle_name, final_grade, dates.course_date, grade, attendance
        from (((user_courses inner join users on user_courses.id_student = users.id_user)
                inner join ratings on user_courses.id_rating = ratings.id_rating)
                inner join classes on ratings.id_rating = classes.rating)
                inner join dates on dates.id_date = classes.course_date
        where user_courses.id_course = ?
        /
--���. ������� ��� ��������� ���������� id
--id ������������
select id_user
from (select id_user from users order by id_user desc)
where rownum = 1
/
--id �����
select id_course
from (select id_course from courses order by id_course desc)
where rownum = 1
/
--id ����
select id_date
from (select id_date from dates order by id_date desc)
where rownum = 1
/
--id_users_courses
select id
from (select id from user_courses order by id desc)
where rownum = 1
/
--id ��������
select id_rating
from (select id_rating from ratings order by id_rating desc)
where rownum = 1
/
--id ������
select id_class
from (select id_class from classes order by id_class desc)
where rownum = 1
/
    
    
    
    
