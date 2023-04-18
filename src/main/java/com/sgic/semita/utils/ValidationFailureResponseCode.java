package com.sgic.semita.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
