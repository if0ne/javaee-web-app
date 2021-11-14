package ru.rsreu.javaeewebapp.interfaces;

import ru.rsreu.javaeewebapp.models.Progress;

import java.util.List;

public interface ProgressDAO {
    List<Progress> getStudentsProgress(int course);
}
