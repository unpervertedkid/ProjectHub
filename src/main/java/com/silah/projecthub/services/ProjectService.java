package com.silah.projecthub.services;

import com.silah.projecthub.entities.Project;
import com.silah.projecthub.entities.ProjectCategory;
import com.silah.projecthub.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    public long saveProject(String name, String description, ProjectCategory category, String guide) {
        return projectRepository.save(new Project(name,description,category,guide)).getId();
    }

    public Optional<Project> getProjectById(long id) {
        return projectRepository.findById(id);
    }
}
