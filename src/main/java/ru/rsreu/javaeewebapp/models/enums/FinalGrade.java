package ru.rsreu.javaeewebapp.models.enums;

import ru.rsreu.javaeewebapp.util.MessageManager;

public enum FinalGrade {
    CREDITED(0),
    FAILED(1);

    private int finalGrade;

    FinalGrade(int finalGrade) {
        this.finalGrade = finalGrade;
    }

    public int getFinalGrade() {
        return this.finalGrade;
    }
}
