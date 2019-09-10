package com.agileintelligence.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agileintelligence.ppmtool.domain.Project;
import com.agileintelligence.ppmtool.exceptions.ProjectIdException;
import com.agileintelligence.ppmtool.repositories.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	@Override
	public Project saveOrUpdatProject(Project project) {
		try {
			project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			return projectRepository.save(project);
		}catch(Exception e) {
			throw new ProjectIdException("ProjectIdentifier '"+project.getProjectIdentifier()+"' already exists.");
		}
				
	}

	@Override
	public Project findProjectByProjectIdentifier(String projectId) {
		Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
		if(project == null) {
			throw new ProjectIdException("ProjectIdentifier '"+projectId+"' does not exists.");
		}
		return project;
	}

	@Override
	public Iterable<Project> findAllProjects() {
		return projectRepository.findAll();
	}

	@Override
	public void deleteProjectByIdentifier(String projectId) {
		Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
		if(project == null) {
			throw new ProjectIdException("Can't delete '"+projectId+"'. This project doesn't exist");
		}
		projectRepository.delete(project);
	}

}
