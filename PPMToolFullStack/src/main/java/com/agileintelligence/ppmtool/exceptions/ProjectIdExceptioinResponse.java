package com.agileintelligence.ppmtool.exceptions;

public class ProjectIdExceptioinResponse{
	private String projectIdentifier;

	public ProjectIdExceptioinResponse(String projectIdentifier) {
		super();
		this.projectIdentifier = projectIdentifier;
	}

	public String getProjectIdentifier() {
		return projectIdentifier;
	}

	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}
	
}
