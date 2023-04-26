package com.sgic.semita.response.dto;

import com.sgic.semita.entities.DefectStatus;
import com.sgic.semita.entities.DefectType;
import com.sgic.semita.entities.Module;
import com.sgic.semita.entities.Priority;
import com.sgic.semita.entities.Project;
import com.sgic.semita.entities.ProjectAllocation;
import com.sgic.semita.entities.Release;
import com.sgic.semita.entities.Severity;
import com.sgic.semita.entities.SubModule;


public class DefectResponseDto {
  private Long id;
  private String code;
  private String stepToRecreate;
  private String description;
  private Release release;
  private Release fixedIn;
  private DefectType type;
  private Severity severity;
  private Priority priority;
  private DefectStatus status;
  private ProjectAllocation assignTo;
  private ProjectAllocation foundBy;
  private Project project;
  private Module module;
  private SubModule subModule;
  
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
  public Release getRelease() {
    return release;
  }
  public void setRelease(Release release) {
    this.release = release;
  }
  public Release getFixedIn() {
    return fixedIn;
  }
  public void setFixedIn(Release fixedIn) {
    this.fixedIn = fixedIn;
  }
  public DefectType getType() {
    return type;
  }
  public void setType(DefectType type) {
    this.type = type;
  }
  public Severity getSeverity() {
    return severity;
  }
  public void setSeverity(Severity severity) {
    this.severity = severity;
  }
  public Priority getPriority() {
    return priority;
  }
  public void setPriority(Priority priority) {
    this.priority = priority;
  }
  public DefectStatus getStatus() {
    return status;
  }
  public void setStatus(DefectStatus status) {
    this.status = status;
  }
  public ProjectAllocation getAssignTo() {
    return assignTo;
  }
  public void setAssignTo(ProjectAllocation assignTo) {
    this.assignTo = assignTo;
  }
  public ProjectAllocation getFoundBy() {
    return foundBy;
  }
  public void setFoundBy(ProjectAllocation foundBy) {
    this.foundBy = foundBy;
  }
  public Project getProject() {
    return project;
  }
  public void setProject(Project project) {
    this.project = project;
  }
  public Module getModule() {
    return module;
  }
  public void setModule(Module module) {
    this.module = module;
  }
  public SubModule getSubModule() {
    return subModule;
  }
  public void setSubModule(SubModule subModule) {
    this.subModule = subModule;
  }
  
}
