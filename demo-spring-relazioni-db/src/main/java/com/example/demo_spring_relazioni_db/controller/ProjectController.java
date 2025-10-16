package com.example.demo_spring_relazioni_db.controller;

import com.example.demo_spring_relazioni_db.model.Project;
import com.example.demo_spring_relazioni_db.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectController(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    @GetMapping
    public List<Project> gettAllProjects(){
        return projectRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id){
        Project project = projectRepository.findById(id).orElse(null);
        if (project == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(project);
    }

    @PostMapping
    public Project createProject(@RequestBody Project project){
        return projectRepository.save(project);
    }
}
