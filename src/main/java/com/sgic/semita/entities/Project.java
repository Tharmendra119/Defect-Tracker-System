package com.sgic.semita.entities;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Project {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String projectName;
  private String prefix;
  private LocalDate startDate;
  private LocalDate endDate;
  @ManyToOne
  @JoinColumn(name="project_type_id",nullable = false)
  private ProjectType projectType;
  @ManyToOne
  @JoinColumn(name="project_status_id",nullable = false)
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
