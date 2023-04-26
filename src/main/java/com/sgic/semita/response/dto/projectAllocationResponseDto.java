package com.sgic.semita.response.dto;

import com.sgic.semita.entities.Employee;
import com.sgic.semita.entities.Project;
import com.sgic.semita.entities.Role;


public class projectAllocationResponseDto {
  private Long id;
  private Project project;
  private Employee employee;
  private Role role;
  private double contribution;
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public Project getProject() {
    return project;
  }
  public void setProject(Project project) {
    this.project = project;
  }
  public Employee getEmployee() {
    return employee;
  }
  public void setEmployee(Employee employee) {
    this.employee = employee;
  }
  public Role getRole() {
    return role;
  }
  public void setRole(Role role) {
    this.role = role;
  }
  public double getContribution() {
    return contribution;
  }
  public void setContribution(double contribution) {
    this.contribution = contribution;
  }
  
}
