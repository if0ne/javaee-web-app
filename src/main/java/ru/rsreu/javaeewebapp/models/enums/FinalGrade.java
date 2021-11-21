package ru.rsreu.javaeewebapp.models.enums;

public enum FinalGrade {
    CREDITED("Зачтено"),
    FAILED("Незачтено");

    private String finalGrade;

    FinalGrade(String finalGrade) {
        this.finalGrade = finalGrade;
    }

    public static FinalGrade getGradeFromInt(String finalGrade) {
        switch (finalGrade) {
            case "Зачтено":
                return CREDITED;
            case "Незачтено":
                return FAILED;
            default:
                return null;
        }
    }

    public String getFinalGradeId() {
        return this.finalGrade;
    }
}
