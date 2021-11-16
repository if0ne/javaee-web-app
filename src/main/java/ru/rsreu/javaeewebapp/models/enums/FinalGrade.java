package ru.rsreu.javaeewebapp.models.enums;

import ru.rsreu.javaeewebapp.util.MessageManager;

public enum FinalGrade {
    CREDITED(MessageManager.getProperty("role.credited")),
    FAILED(MessageManager.getProperty("role.failed"));

    private String finalGrade;

    FinalGrade(String finalGrade) {
        this.finalGrade = finalGrade;
    }

    public String getFinalGrade() {
        return this.finalGrade;
    }
}
