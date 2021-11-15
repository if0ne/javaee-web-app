package ru.rsreu.javaeewebapp.util;

public class ParameterChecker {

    private ParameterChecker() {

    }

    public static boolean isAnyFieldNull(Object... params) {
        for (Object param: params) {
            if (param == null) {
                return true;
            }
        }
        return false;
    }

}
