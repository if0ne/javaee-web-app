package ru.rsreu.javaeewebapp.commands.outputs;

public class LoginOutput {

    private boolean isSuccessLogin;
    private int userId;
    private String role;
    private String wrongLoginPasswordMessage;

    public LoginOutput() {

    }

    public boolean isSuccessLogin() {
        return isSuccessLogin;
    }

    public void setSuccessLogin(boolean successLogin) {
        isSuccessLogin = successLogin;
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

    public String getWrongLoginPasswordMessage() {
        return wrongLoginPasswordMessage;
    }

    public void setWrongLoginPasswordMessage(String wrongLoginPasswordMessage) {
        this.wrongLoginPasswordMessage = wrongLoginPasswordMessage;
    }
}
