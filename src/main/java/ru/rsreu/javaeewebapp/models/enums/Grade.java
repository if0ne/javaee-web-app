package ru.rsreu.javaeewebapp.models.enums;

public enum Grade {
    FIVE(5), FOUR(4), THREE(3), TWO(2);

    private int grade;

    Grade(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return this.grade;
    }
}
