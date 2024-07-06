package com.crowdfunding.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crowdfunding.dto.ProjectDTO;
import com.crowdfunding.entity.Project;
import com.crowdfunding.entity.project;
import com.crowdfunding.exception.ResourceNotFoundException;
import com.crowdfunding.repo.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ProjectDTO getProjectById(Long projectId) {
		Optional <project> optionalProject = projectRepository.findById(projectId);
		if(optionalProject.isEmpty()) {
			throw new ResourceNotFoundException("Project not found");
		}
		Project project = optionalProject.get();
		return modelMapper.map(project, ProjectDTO.class);
	}

	@Override
	public List<ProjectDTO> getAllprojects() {
		List<Project> projects = projectRepository.findAll();
		return projects.stream().map(project -> modelMapper.map(project, ProjectDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public projectDTO createProject(ProjectDTO projectDTO) {
		Project project = modelMapper.map(projectDTO, project.class);
		projectRepository.save(project);
		return modelMapper.map(project,ProjectDTO.class);
	}
	@Override
	public ProjectDTO updateProject(Long projectId,ProjectDTO projectDTO) {
		Optional<Project> optionalProject = projectRepository.findbyId(projectid);
		if(optionalproject.isEmpty()) {
			throw new ResourceNotFoundException("Project not found");
		}
	    com.crowdfunding.entity.project project = optionalProject.get();
		project.setId(projectDTO.getId());
		project.setName(projectDTO.getName());
		project.setDescription(projectDTO.getDescription());
		project.setGoalAmount(projectDTO.getGoalAmount());
		project.setAmountRaised(project);
		projectRepository.save(project);
		return modelMapper.map(project, ProjectDTO.class);
	}
	@override
	public boolean deleteproject(Long projectId) {
		optional<project> optionalProject = projectRepository.findbyId(projectId);
		if(optionalProject.isEmpty()) {
			throw new ResourceNotFoundException("project not found");
		}
		Project project = optionalproject.get();
		projectRepository.delete(project);
		return true;
	}

	@Override
	public boolean deleteProject(Long projectId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ProjectDTO> getAllProjects() {
		// TODO Auto-generated method stub
		return null;
	}		
	}
		