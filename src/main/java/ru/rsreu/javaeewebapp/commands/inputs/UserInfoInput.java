package ru.rsreu.javaeewebapp.commands.inputs;

public class UserInfoInput {
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserIdFromRequest(Object userId) {
        this.userId = Integer.parseInt(userId.toString());
    }
}
