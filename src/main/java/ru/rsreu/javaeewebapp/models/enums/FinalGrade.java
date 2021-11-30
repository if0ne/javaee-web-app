package ru.rsreu.javaeewebapp.models.enums;

public enum FinalGrade {
    CREDITED("Зачтено"),
    FAILED("Незачтено"),
    UNEXPOSED("");

    private String finalGrade;

    FinalGrade(String finalGrade) {
        this.finalGrade = finalGrade;
    }

    public static FinalGrade getGradeFromString(String finalGrade) {
        switch (finalGrade) {
            case "Зачтено":
                return CREDITED;
            case "Незачтено":
                return FAILED;
            default:
                return UNEXPOSED;
        }
    }

    public String getFinalGradeId() {
        return this.finalGrade;
    }
}
