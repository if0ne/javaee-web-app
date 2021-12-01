package ru.rsreu.javaeewebapp.models.enums;

public enum Grade {
    FIVE(5), FOUR(4), THREE(3), TWO(2), ZERO(0);

    private Integer grade;

    Grade(Integer grade) {
        this.grade = grade;
    }

    public static Grade getGradeFromInt(Integer gradeId) {
        if (gradeId == null) {
            return ZERO;
        }
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
                return ZERO;
        }
    }

    public Integer getGrade() {
        return this.grade;
    }
}
