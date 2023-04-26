package com.sgic.semita.request.dto;

import java.time.LocalDate;

public class ProjectRequestDto {
  private Long id;
  private String projectName;
  private String prefix;
  private LocalDate startDate;
  private LocalDate endDate;
  private Long projectTypeId;
  private Long projectStatusId;
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
  public Long getProjectTypeId() {
    return projectTypeId;
  }
  public void setProjectTypeId(Long projectTypeId) {
    this.projectTypeId = projectTypeId;
  }
  public Long getProjectStatusId() {
    return projectStatusId;
  }
  public void setProjectStatusId(Long projectStatusId) {
    this.projectStatusId = projectStatusId;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  
}
