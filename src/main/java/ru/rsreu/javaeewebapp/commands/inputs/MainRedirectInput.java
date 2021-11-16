package ru.rsreu.javaeewebapp.commands.inputs;

public class MainRedirectInput {

    private boolean isHasRole;
    private int userId;
    private String role;

    public MainRedirectInput() {

    }

    public boolean isHasRole() {
        return isHasRole;
    }

    public void setHasRole(boolean hasRole) {
        isHasRole = hasRole;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
