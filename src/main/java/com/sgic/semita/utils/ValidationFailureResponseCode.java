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
}
