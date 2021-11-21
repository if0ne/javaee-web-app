package ru.rsreu.javaeewebapp.models.enums;

public enum Grade {
    FIVE(5), FOUR(4), THREE(3), TWO(2);

    private int grade;

    Grade(int grade) {
        this.grade = grade;
    }

    public static Grade getGradeFromInt(int gradeId) {
        switch (gradeId) {
            case 2:
                return TWO;
            case 3:
                return THREE;
            case 4:
                return FOUR;
            case 5:
                return FIVE;
            default:
                return null;
        }
    }

    public int getGrade() {
        return this.grade;
    }
}
