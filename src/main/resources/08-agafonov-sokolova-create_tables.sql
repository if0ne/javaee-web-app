-- User roles table.
-- It contains identifier and name of user roles.
-- The following roles are supposed to be stored in database: administrator, moderator, teacher, student.
create table roles (
    id_role number not null,
    name varchar(30) not null,
    constraint pk_role primary key (id_role)
)
/
-- Users table.
-- It contains a main information about users: identifier, login and password to enter the system,
-- name and role of user and also user status (blocked or unblocked).
-- Information about user role is taken from the roles table.
create table users (
    id_user number not null,
    login varchar(50) not null,
    password varchar(50) not null,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    middle_name varchar(50),
    role number not null,
    blocked number(1, 0) default 0,
    constraint pk_user primary key (id_user),
    constraint fk_role foreign key (role) references roles (id_role),
    constraint unique_login unique (login)
)
/
-- Courses table.
-- It contains the main information about course: identifier, course name, description and course teacher.
-- Information about teacher is taken from the users table.
create table courses (
    id_course number not null,
    name varchar(50) not null,
    description varchar(1500),
    teacher number not null,
    constraint pk_course primary key (id_course),
    constraint fk_teacher foreign key (teacher) references users (id_user) on delete cascade
)
/
-- Dates table.
-- It contains all dates of classes. User (teacher) notes start course date, end course date and day of the week,
-- which the lesson will be held. A list of dates is formed on which the lesson will be held based on these data.
create table dates (
    id_date number not null,
    course_date date,
    id_course number,
    constraint pk_date primary key (id_date),
    constraint fk_date_course foreign key (id_course) references courses (id_course) on delete cascade
)
/
-- Students rating table.
-- It contains information about students rating, their attendance and class grades and also final grade for the course.
create table ratings (
    id_rating number not null,
    final_grade varchar(10),
    constraint pk_rating primary key (id_rating)
)
/

--Classes rating table.
--It contains information about student grade and attendance.
--This table allows to store multiply student grade delivered on different dates.
create table classes (
    id_class number not null,
    rating number not null,
    course_date number not null,
    grade number,
    attendance number default 0,
    constraint pk_class primary key (id_class),
    constraint fk_date foreign key (course_date) references dates (id_date) on delete cascade,
    constraint fk_rating_classes foreign key (rating) references ratings (id_rating) on delete cascade
)
/
-- Students and courses table is intermediate table for a many-to-many relationship between the students table and the course one.
-- Many students can study in one course and one student can study in several courses.
create table user_courses (
    id number not null,
    id_student number not null,
    id_course number not null,
    id_rating number not null,
    constraint pk_students_cources primary key (id),
    constraint fk_students foreign key (id_student) references users (id_user) on delete cascade,
    constraint fk_courses foreign key (id_course) references courses (id_course) on delete cascade,
    constraint fk_rating_user_cources foreign key (id_rating) references ratings (id_rating) on delete cascade,
    constraint unique_rating unique (id_rating)
)
/
/*drop table user_courses cascade constraints;
/
drop table classes cascade constraints;
/
drop table ratings cascade constraints;
/
drop table dates cascade constraints;
/
drop table courses cascade constraints;
/
drop table users cascade constraints;
/
drop table roles cascade constraints;
/*/