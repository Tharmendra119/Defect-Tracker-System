package com.sgic.semita.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:validationmessage.properties")
public class ValidationFailureResponseCode {
  /*
   * Module: Designation || Author: Keerthana || Date: 16-04-2023
   */
  @Value("${validation.designation.alreadyexists}")
  private String designationAlreadyExists;

  @Value("${validation.designation.notexists}")
  private String designationNotExists;

  public String getDesignationAlreadyExists() {
    return designationAlreadyExists;
  }

  public void setDesignationAlreadyExists(String designationAlreadyExists) {
    this.designationAlreadyExists = designationAlreadyExists;
  }

  public String getDesignationNotExists() {
    return designationNotExists;
  }

  public void setDesignationNotExists(String designationNotExists) {
    this.designationNotExists = designationNotExists;
  }

  /*
   * Module: Employee || Author: kajanthan || Date: 18-04-2023
   */
  @Value("${validation.employee.alreadyexists}")
  private String employeeAlreadyExists;

  @Value("${validation.employee.notexists}")
  private String employeeNotExists;

  public String getEmployeeAlreadyExists() {
    return employeeAlreadyExists;
  }

  public void setEmployeeAlreadyExists(String employeeAlreadyExists) {
    this.employeeAlreadyExists = employeeAlreadyExists;
  }

  public String getEmployeeNotExists() {
    return employeeNotExists;
  }

  public void setEmployeeNotExists(String employeeNotExists) {
    this.employeeNotExists = employeeNotExists;
  }
  
  /*
   * Module: Release || Author: kajanthan || Date: 21-04-2023
   */
  @Value("${validation.release.alreadyexists}")
  private String releaseAlreadyExists;

  @Value("${validation.release.notexists}")
  private String releaseNotExists;

  public String getReleaseAlreadyExists() {
    return releaseAlreadyExists;
  }

  public void setReleaseAlreadyExists(String releaseAlreadyExists) {
    this.releaseAlreadyExists = releaseAlreadyExists;
  }

  public String getReleaseNotExists() {
    return releaseNotExists;
  }

  public void setReleaseNotExists(String releaseNotExists) {
    this.releaseNotExists = releaseNotExists;
  }

  /*
   * Module: Module || Author: kajanthan || Date: 21-04-2023
   */
  @Value("${validation.module.alreadyexists}")
  private String moduleAlreadyExists;

  @Value("${validation.module.notexists}")
  private String moduleNotExists;

  public String getModuleAlreadyExists() {
    return moduleAlreadyExists;
  }

  public void setModuleAlreadyExists(String moduleAlreadyExists) {
    this.moduleAlreadyExists = moduleAlreadyExists;
  }

  public String getModuleNotExists() {
    return moduleNotExists;
  }

  public void setModuleNotExists(String moduleNotExists) {
    this.moduleNotExists = moduleNotExists;
  }
  
  /*
   * Module: Project_Type || Author: kajanthan || Date: 21-04-2023
   */
  @Value("${validation.projectType.alreadyexists}")
  private String projectTypeAlreadyExists;

  @Value("${validation.projectType.notexists}")
  private String projectTypeNotExists;

  public String getProjectTypeAlreadyExists() {
    return projectTypeAlreadyExists;
  }

  public void setProjectTypeAlreadyExists(String projectTypeAlreadyExists) {
    this.projectTypeAlreadyExists = projectTypeAlreadyExists;
  }

  public String getProjectTypeNotExists() {
    return projectTypeNotExists;
  }

  public void setProjectTypeNotExists(String projectTypeNotExists) {
    this.projectTypeNotExists = projectTypeNotExists;
  }

  /*
   * Module: SubModule || Author: kajanthan || Date: 22-04-2023
   */
  @Value("${validation.subModule.alreadyexists}")
  private String SubModuleAlreadyExists;

  @Value("${validation.subModule.notexists}")
  private String SubModuleNotExists;

  public String getSubModuleAlreadyExists() {
    return SubModuleAlreadyExists;
  }

  public void setSubModuleAlreadyExists(String subModuleAlreadyExists) {
    SubModuleAlreadyExists = subModuleAlreadyExists;
  }

  public String getSubModuleNotExists() {
    return SubModuleNotExists;
  }

  public void setSubModuleNotExists(String subModuleNotExists) {
    SubModuleNotExists = subModuleNotExists;
  }
  /*
   * Module: Project || Author: kajanthan || Date: 21-04-2023
   */
  @Value("${validation.project.alreadyexists}")
  private String projectAlreadyExists;

  @Value("${validation.project.notexists}")
  private String projectNotExists;

  public String getProjectAlreadyExists() {
    return projectAlreadyExists;
  }

  public void setProjectAlreadyExists(String projectAlreadyExists) {
    this.projectAlreadyExists = projectAlreadyExists;
  }

  public String getProjectNotExists() {
    return projectNotExists;
  }

  public void setProjectNotExists(String projectNotExists) {
    this.projectNotExists = projectNotExists;
  }

  /*
   * Module: Module Allocation || Author: kajanthan || Date: 22-04-2023
   */
  @Value("${validation.moduleAllocation.alreadyexists}")
  private String moduleAllocationAlreadyExists;

  @Value("${validation.moduleAllocation.notexists}")
  private String moduleAllocationNotExists;

  public String getModuleAllocationAlreadyExists() {
    return moduleAllocationAlreadyExists;
  }

  public void setModuleAllocationAlreadyExists(String moduleAllocationAlreadyExists) {
    this.moduleAllocationAlreadyExists = moduleAllocationAlreadyExists;
  }

  public String getModuleAllocationNotExists() {
    return moduleAllocationNotExists;
  }

  public void setModuleAllocationNotExists(String moduleAllocationNotExists) {
    this.moduleAllocationNotExists = moduleAllocationNotExists;
  }
  
  /*
   * Module: Project Allocation || Author: kajanthan || Date: 22-04-2023
   */
  @Value("${validation.projectAllocation.alreadyexists}")
  private String projectAllocationAlreadyExists;

  @Value("${validation.projectAllocation.notexists}")
  private String projectAllocationNotExists;

  public String getProjectAllocationAlreadyExists() {
    return projectAllocationAlreadyExists;
  }

  public void setProjectAllocationAlreadyExists(String projectAllocationAlreadyExists) {
    this.projectAllocationAlreadyExists = projectAllocationAlreadyExists;
  }

  public String getProjectAllocationNotExists() {
    return projectAllocationNotExists;
  }

  public void setProjectAllocationNotExists(String projectAllocationNotExists) {
    this.projectAllocationNotExists = projectAllocationNotExists;
  }
  /*
   * Module:Defect || Author: kajanthan || Date: 23-04-2023
   */
  @Value("${validation.defect.alreadyexists}")
  private String defectAlreadyExists;

  @Value("${validation.defect.notexists}")
  private String defectNotExists;

  public String getDefectAlreadyExists() {
    return defectAlreadyExists;
  }

  public void setDefectAlreadyExists(String defectAlreadyExists) {
    this.defectAlreadyExists = defectAlreadyExists;
  }

  public String getDefectNotExists() {
    return defectNotExists;
  }

  public void setDefectNotExists(String defectNotExists) {
    this.defectNotExists = defectNotExists;
  }
  
  
}
