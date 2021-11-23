package ru.rsreu.javaeewebapp.commands.inputs;

public class UserInfoInput {

    private int userId;
    private int userStatus;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public void setUserIdFromRequest(Object userId) {
        this.userId = Integer.parseInt(userId.toString());
    }
}
