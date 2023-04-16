package com.sgic.semita.utils;

public class EndPointURI {
  private static final String BASE_API_PATH = "/api/v1/";
  public static final String ID = "/{id}";
  /*
   * Module: Designation || Author: Keerthana || Date: 16-04-2023
   */
  public static final String DESIGNATION = BASE_API_PATH + "designation";
  public static final String DESIGNATIONS = BASE_API_PATH + "designations";
  public static final String DESIGNATION_BY_ID = DESIGNATION + ID;
}
