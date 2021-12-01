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
        if (finalGrade == null) {
            return UNEXPOSED;
        }
        switch (finalGrade) {
            case "1":
                return CREDITED;
            case "0":
                return FAILED;
            default:
                return UNEXPOSED;
        }
    }

    public String getFinalGradeId() {
        return this.finalGrade;
    }
}
