package com.crowdfunding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crowdfunding.dto.ProjectDTO;

import Service.ProjectService;
import jakarta.validation.Valid;


@RestController
@CrossOrigin(origins = "https://localhost:3000/")
@RequestMapping("/api/projects")
public class ProjectController {
		
		@Autowired
	    private ProjectService projectService;

	    @GetMapping("/{id}")
	    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable Long projectId){
	    	return new ResponseEntity<>(projectService.getProjectById(projectId), HttpStatus.OK);
	    }

	    @GetMapping("/")
	    public ResponseEntity<List<ProjectDTO>> getAllProjects(){
	    	List<ProjectDTO> projects = projectService.getAllProjects();
	    	return new ResponseEntity<>(projects, HttpStatus.OK);
	    }

	    @PostMapping("/") //Creates or Saves a new project
	    public ResponseEntity<ProjectDTO> createProject(@Valid @RequestBody ProjectDTO projectDTO){
	    	return new ResponseEntity<>(projectService.createProject(projectDTO), HttpStatus.OK);
	    }
	    
	    @PutMapping("/{id}")
	    public ResponseEntity<ProjectDTO> updateProject(@PathVariable Long projectId,
	    		@Valid @RequestBody ProjectDTO projectDTO) {
	    	return new ResponseEntity<>(projectService.updateProject(projectId, projectDTO), HttpStatus.OK);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteProject(@PathVariable Long projectId){
	    		projectService.deleteProject(projectId);
	    	return new ResponseEntity<>(HttpStatus.OK);
	    }
}

	