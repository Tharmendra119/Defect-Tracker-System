package com.sgic.semita.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ModuleAllocation {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
@ManyToOne
@JoinColumn(name="module_id",nullable = false)
private Module module;
@ManyToOne
@JoinColumn(name="sub_module_id",nullable = false)
private SubModule subModule;
@ManyToOne
@JoinColumn(name="project_allocation_id",nullable = false)
private Employee employee;
public Long getId() {
  return id;
}
public void setId(Long id) {
  this.id = id;
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
public Employee getEmployee() {
  return employee;
}
public void setEmployee(Employee employee) {
  this.employee = employee;
}


}
