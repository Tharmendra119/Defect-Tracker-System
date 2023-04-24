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
  /*
   * Module: Employee || Author: kajanthan || Date: 18-04-2023
   */
  public static final String EMPLOYEE = BASE_API_PATH + "employee";
  public static final String EMPLOYEES = BASE_API_PATH + "employees";
  public static final String EMPLOYEE_BY_ID = EMPLOYEE + ID;
  public static final String EMPLOYEE_DESIGNATION_BY_ID = EMPLOYEE+"/designation"+ID;
  /*
   * Module: Release || Author: kajanthan || Date: 21-04-2023
   */
  public static final String RELEASE = BASE_API_PATH + "release";
  public static final String RELEASES = BASE_API_PATH + "releases";
  public static final String RELEASE_BY_ID = RELEASE + ID; 
  /*
   * Module: Module || Author: kajanthan || Date: 21-04-2023
   */
  public static final String MODULE = BASE_API_PATH + "module";
  public static final String MODULES = BASE_API_PATH + "modules";
  public static final String MODULE_BY_ID = MODULE + ID;
  /*
   * Module: Peoject_Type || Author: kajanthan || Date: 21-04-2023
   */ 
  public static final String PROJECT_TYPE = BASE_API_PATH + "project-type";
  public static final String PROJECT_TYPES = BASE_API_PATH + "project-types";
  public static final String PROJECT_TYPE_BY_ID = PROJECT_TYPE + ID;
  /*
   * Module: SubModule || Author: kajanthan || Date: 22-04-2023
   */ 
  public static final String SUBMODULE = BASE_API_PATH + "submodule";
  public static final String SUBMODULES = BASE_API_PATH + "submodules";
  public static final String SUBMODULE_BY_ID = SUBMODULE + ID;
  /*
   * Module: Project || Author: kajanthan || Date: 22-04-2023
   */ 
  public static final String PROJECT = BASE_API_PATH + "project";
  public static final String PROJECTS = BASE_API_PATH + "projects";
  public static final String PROJECT_BY_ID = PROJECT + ID;
  /*
   * Module: Module Allocation || Author: kajanthan || Date: 23-04-2023
   */
  public static final String MODULE_ALLOCATION = BASE_API_PATH + "module-allocation";
  public static final String MODULE_ALLOCATIONS = BASE_API_PATH + "module-allocations";
  public static final String MODULE_ALLOCATION_BY_ID = MODULE_ALLOCATION + ID;
  public static final String MODULE_ALLOCATION__BY_EMPLOYEE_ID = MODULE_ALLOCATION + "/employee" + ID;
  /*
   * Module: Project Allocation || Author: kajanthan || Date: 22-04-2023
   */
  public static final String PROJECT_ALLOCATION = BASE_API_PATH + "project-allocation";
  public static final String PROJECT_ALLOCATIONS = BASE_API_PATH + "project-allocations";
  public static final String PROJECT_ALLOCATION_BY_ID = PROJECT_ALLOCATION + ID;
  public static final String PROJECT_ALLOCATION_PROJECT_BY_ID = PROJECT_ALLOCATION + "/project" + ID;
  public static final String PROJECT_ALLOCATION_EMPLOYEE_BY_ID = PROJECT_ALLOCATION + "/employee" + ID;
  /*
   * Module: Defect || Author: kajanthan || Date: 23-04-2023
   */
  public static final String DEFECT = BASE_API_PATH + "defect";
  public static final String DEFECTS = BASE_API_PATH + "defects";
  public static final String DEFECT_BY_ID = DEFECT + ID;
  public static final String DEFECT_PROJECT_BY_ID = DEFECT+"/project"+ID;
}
