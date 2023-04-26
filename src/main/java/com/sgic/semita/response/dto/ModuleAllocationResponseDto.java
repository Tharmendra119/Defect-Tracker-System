package com.sgic.semita.response.dto;

import com.sgic.semita.entities.Employee;
import com.sgic.semita.entities.Module;
import com.sgic.semita.entities.SubModule;

public class ModuleAllocationResponseDto {
  private Long id;
  private Module module;
  private SubModule subModule;
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
