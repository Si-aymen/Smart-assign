package org.example.SmartAssign.controllers;

import lombok.AllArgsConstructor;
import org.example.SmartAssign.models.Project;
import org.example.SmartAssign.services.IProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Projects")
@AllArgsConstructor
@PreAuthorize("hasRole('SUPERADMIN')")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowedHeaders = "*", allowCredentials = "true")
public class ProjectController {
    IProjectService projectService;

    @GetMapping("/GetAll/Projects")
    public List<Project> getProjects() {
        return projectService.retrieveAllProjects();

    }

    @GetMapping("/GetByID/{project-id}")
    public Project getProject(@PathVariable("project-id") String projectID) {
        return projectService.retrieveProject(projectID);

    }

    @PostMapping("/add-project")
    public Project addProject(@RequestBody Project project) {
        return projectService.addProject(project);

    }

    @DeleteMapping("/remove-Project/{project-id}")
    public void removeTransports(@PathVariable("project-id") String projectID) {
        projectService.removeProject(projectID);
    }




}
