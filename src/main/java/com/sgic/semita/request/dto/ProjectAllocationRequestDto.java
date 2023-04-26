package com.sgic.semita.request.dto;


public class ProjectAllocationRequestDto {
  private Long id;
  private Long projectId;
  private Long employeeId;
  private String employeeAvailability;
  private Long roleId;
  private double contribution;
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public Long getProjectId() {
    return projectId;
  }
  public void setProjectId(Long projectId) {
    this.projectId = projectId;
  }
  public Long getEmployeeId() {
    return employeeId;
  }
  public void setEmployeeId(Long employeeId) {
    this.employeeId = employeeId;
  }
  public String getEmployeeAvailability() {
    return employeeAvailability;
  }
  public void setEmployeeAvailability(String employeeAvailability) {
    this.employeeAvailability = employeeAvailability;
  }
  public Long getRoleId() {
    return roleId;
  }
  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }
  public double getContribution() {
    return contribution;
  }
  public void setContribution(double contribution) {
    this.contribution = contribution;
  }
  
}
