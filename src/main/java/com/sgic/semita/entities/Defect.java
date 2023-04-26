package com.sgic.semita.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Defect {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String stepToRecreate;
  private String description;
  private String code;

  @ManyToOne
  @JoinColumn(name = "release_id",nullable = false)
  private Release release;

  @ManyToOne
  @JoinColumn(name = "fixed_in_release_id",nullable = false)
  private Release fixedIn;

  @ManyToOne
  @JoinColumn(name = "defect_type_id",nullable = false)
  private DefectType type;

  @ManyToOne
  @JoinColumn(name = "severity_id",nullable = false)
  private Severity severity;

  @ManyToOne
  @JoinColumn(name = "priority_id",nullable = false)
  private Priority priority;

  @ManyToOne
  @JoinColumn(name = "defect_status_id",nullable = false)
  private DefectStatus status;

  @ManyToOne
  @JoinColumn(name = "assignee_id",nullable = false)
  private ProjectAllocation assignTo;

  @ManyToOne
  @JoinColumn(name = "found_by_id",nullable = false)
  private ProjectAllocation foundBy;

  @ManyToOne
  @JoinColumn(name = "project_id",nullable = false)
  private Project project;

  @ManyToOne
  @JoinColumn(name = "module_id",nullable = false)
  private Module module;

  @ManyToOne
  @JoinColumn(name = "sub_module_id",nullable = false)
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
