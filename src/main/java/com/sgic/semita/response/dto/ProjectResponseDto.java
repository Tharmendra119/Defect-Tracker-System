package com.sgic.semita.response.dto;

import java.time.LocalDate;
import com.sgic.semita.entities.ProjectStatus;
import com.sgic.semita.entities.ProjectType;

public class ProjectResponseDto {
  private Long id;
  private String projectName;
  private String prefix;
  private LocalDate startDate;
  private LocalDate endDate;
  private ProjectType projectType;
  private ProjectStatus projectStatus;
  private String description;
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getProjectName() {
    return projectName;
  }
  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }
  public String getPrefix() {
    return prefix;
  }
  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }
  public LocalDate getStartDate() {
    return startDate;
  }
  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }
  public LocalDate getEndDate() {
    return endDate;
  }
  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }
  public ProjectType getProjectType() {
    return projectType;
  }
  public void setProjectType(ProjectType projectType) {
    this.projectType = projectType;
  }
  public ProjectStatus getProjectStatus() {
    return projectStatus;
  }
  public void setProjectStatus(ProjectStatus projectStatus) {
    this.projectStatus = projectStatus;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  
  
}
