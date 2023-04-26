package com.sgic.semita.request.dto;

public class DefectRequestDto {
  private Long id;
  private String code;
  private String stepToRecreate;
  private String description;
  private Long releaseId;
  private Long fixedInId;
  private Long typeId;
  private Long severityId;
  private Long priorityId;
  private Long statusId;
  private Long assignToId;
  private Long foundById;
  private Long projectId;
  private Long moduleId;
  private Long subModuleId;
  
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
  }
  public String getStepToRecreate() {
    return stepToRecreate;
  }
  public void setStepToRecreate(String stepToRecreate) {
    this.stepToRecreate = stepToRecreate;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public Long getReleaseId() {
    return releaseId;
  }
  public void setReleaseId(Long releaseId) {
    this.releaseId = releaseId;
  }
  public Long getFixedInId() {
    return fixedInId;
  }
  public void setFixedInId(Long fixedInId) {
    this.fixedInId = fixedInId;
  }
  public Long getTypeId() {
    return typeId;
  }
  public void setTypeId(Long typeId) {
    this.typeId = typeId;
  }
  public Long getSeverityId() {
    return severityId;
  }
  public void setSeverityId(Long severityId) {
    this.severityId = severityId;
  }
  public Long getPriorityId() {
    return priorityId;
  }
  public void setPriorityId(Long priorityId) {
    this.priorityId = priorityId;
  }
  public Long getStatusId() {
    return statusId;
  }
  public void setStatusId(Long statusId) {
    this.statusId = statusId;
  }
  public Long getAssignToId() {
    return assignToId;
  }
  public void setAssignToId(Long assignToId) {
    this.assignToId = assignToId;
  }
  public Long getFoundById() {
    return foundById;
  }
  public void setFoundById(Long foundById) {
    this.foundById = foundById;
  }
  public Long getProjectId() {
    return projectId;
  }
  public void setProjectId(Long projectId) {
    this.projectId = projectId;
  }
  public Long getModuleId() {
    return moduleId;
  }
  public void setModuleId(Long moduleId) {
    this.moduleId = moduleId;
  }
  public Long getSubModuleId() {
    return subModuleId;
  }
  public void setSubModuleId(Long subModuleId) {
    this.subModuleId = subModuleId;
  }
  
}
