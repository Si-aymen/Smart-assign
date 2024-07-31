package org.example.SmartAssign.serviceImpls;

import lombok.extern.slf4j.Slf4j;
import org.example.SmartAssign.models.Project;
import org.example.SmartAssign.repositories.ProjectRepository;
import org.example.SmartAssign.services.IProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class ProjectService implements IProjectService {

    private  ProjectRepository projectRepository;

    @Override
    public List<Project> retrieveAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project retrieveProject(String ProjectID) {
        return projectRepository.findById(ProjectID).get();
    }

    @Override
    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public void removeProject(String projectID) {
        projectRepository.deleteById(projectID);

    }

    @Override
    public Project modifyProject(Project project) {
        //todo
        return null;
    }
}
