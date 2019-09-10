package com.agileintelligence.ppmtool.services;

import com.agileintelligence.ppmtool.domain.Project;

public interface ProjectService {
	
	public Project saveOrUpdatProject(Project project);
	
	public Project findProjectByProjectIdentifier(String projectId);
	
	public Iterable<Project> findAllProjects();

	public void deleteProjectByIdentifier(String projectId);
}
