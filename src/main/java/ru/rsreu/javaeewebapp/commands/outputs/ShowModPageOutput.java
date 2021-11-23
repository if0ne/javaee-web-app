package ru.rsreu.javaeewebapp.commands.outputs;

import ru.rsreu.javaeewebapp.models.StudentStatus;

import java.io.Serializable;
import java.util.List;

public class ShowModPageOutput implements Serializable {

    private List<StudentStatus> students;

    public List<StudentStatus> getStudents() {
        return students;
    }

    public void setStudents(List<StudentStatus> students) {
        this.students = students;
    }
}
