package org.example.SmartAssign.services;

import org.example.SmartAssign.models.Project;

import java.util.List;

public interface IProjectService {


    public List<Project> retrieveAllProjects();

    public Project retrieveProject(String ProjectID);

    public Project addProject(Project project);

    public void removeProject(String projectID);

    public Project modifyProject(Project project);
}
