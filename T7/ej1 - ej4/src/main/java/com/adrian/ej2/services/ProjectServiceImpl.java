package com.adrian.ej2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrian.ej2.domain.Project;
import com.adrian.ej2.repositories.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project add(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project getById(long id) throws RuntimeException {
        return projectRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no department with that id"));
    }

    @Override
    public Project edit(Project project) throws RuntimeException {
        getById(project.getId()); // Check if project exists
        return projectRepository.save(project);
    }

    @Override
    public void delete(long id) throws RuntimeException {
        getById(id);
        projectRepository.deleteById(id);
    }
}
