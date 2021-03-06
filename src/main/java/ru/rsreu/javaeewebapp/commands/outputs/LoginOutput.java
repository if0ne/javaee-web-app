package ru.rsreu.javaeewebapp.commands.outputs;

public class LoginOutput {

    private boolean isSuccessLogin;
    private int userId;
    private String role;
    private String roleName;

    private String firstName;
    private String lastName;
    private boolean status;

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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getWrongLoginPasswordMessage() {
        return wrongLoginPasswordMessage;
    }

    public void setWrongLoginPasswordMessage(String wrongLoginPasswordMessage) {
        this.wrongLoginPasswordMessage = wrongLoginPasswordMessage;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
