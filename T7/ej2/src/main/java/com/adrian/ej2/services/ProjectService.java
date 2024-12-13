package com.adrian.ej2.services;

import java.util.List;

import com.adrian.ej2.domain.Project;

public interface ProjectService {
    Project add(Project project);
    List<Project> getAll();
    Project getById(long id) throws RuntimeException;
    Project edit(Project project) throws RuntimeException;
    void delete(long id) throws RuntimeException;
}
