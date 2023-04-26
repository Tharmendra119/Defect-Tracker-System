package com.sgic.semita.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ProjectAllocation {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @ManyToOne
  @JoinColumn(name="project_id",nullable = false)
  private Project project;
  @ManyToOne
  @JoinColumn(name="employee_id",nullable = false)
  private Employee employee;
  @ManyToOne
  @JoinColumn(name="role_id",nullable = false)
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
