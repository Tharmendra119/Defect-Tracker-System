package com.sgic.semita.request.dto;


public class ModuleAllocationRequestDto {
  private Long id;
  private Long moduleId;
  private Long subModuleId;
  private Long employeeId;
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
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
  public Long getEmployeeId() {
    return employeeId;
  }
  public void setEmployeeId(Long employeeId) {
    this.employeeId = employeeId;
  }
  
}
