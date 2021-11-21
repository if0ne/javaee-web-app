package ru.rsreu.javaeewebapp.dao.oracle;

import ru.rsreu.javaeewebapp.Client;
import ru.rsreu.javaeewebapp.interfaces.ProgressDAO;
import ru.rsreu.javaeewebapp.util.MessageManager;

public class OracleProgressDAO implements ProgressDAO {

    private static final String SQL_UPDATE_PROGRESS = MessageManager.getProperty("sql.update.progress");
    private static final String SQL_UPDATE_FINAL_GRADE = MessageManager.getProperty("sql.update.final.grade");

    private Client client;

    public OracleProgressDAO(Client client) {
        this.client = client;
    }

    @Override
    public void updateStudentProgress(int studentId, int courseId, int dateId, int attendance, int grade) {
        this.client.updateData(SQL_UPDATE_PROGRESS, Integer.toString(attendance),
                                                    Integer.toString(grade),
                                                    Integer.toString(studentId),
                                                    Integer.toString(courseId),
                                                    Integer.toString(dateId));
    }

    @Override
    public void updateFinalGrade(int studentId, int courseId, int finalGrade) {
        this.client.updateData(SQL_UPDATE_FINAL_GRADE, Integer.toString(finalGrade),
                                                        Integer.toString(studentId),
                                                        Integer.toString(courseId));
    }
}
