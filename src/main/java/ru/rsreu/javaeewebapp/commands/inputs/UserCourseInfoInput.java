package ru.rsreu.javaeewebapp.commands.inputs;

public class UserCourseInfoInput {

    private int userId;
    private int courseId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setUserIdFromRequest(Object userId) {
        this.userId = Integer.parseInt(userId.toString());
    }
    public void setCourseIdFromRequest(Object courseId) {
        this.courseId = Integer.parseInt(courseId.toString());
    }
}
