package com.sgic.semita.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sgic.semita.common.response.BasicResponse;
import com.sgic.semita.common.response.ContentResponse;
import com.sgic.semita.common.response.ValidationFailureResponse;
import com.sgic.semita.entities.Employee;
import com.sgic.semita.entities.Project;
import com.sgic.semita.entities.ProjectAllocation;
import com.sgic.semita.enums.RestApiResponseStatus;
import com.sgic.semita.request.dto.ProjectAllocationRequestDto;
import com.sgic.semita.services.EmployeeService;
import com.sgic.semita.services.ProjectAllocationService;
import com.sgic.semita.services.ProjectService;
import com.sgic.semita.utils.Constants;
import com.sgic.semita.utils.EndPointURI;
import com.sgic.semita.utils.ValidationFailureResponseCode;

@CrossOrigin
@RestController
public class ProjectAllocationController {
  @Autowired
  private ProjectAllocationService projectAllocationService;
  @Autowired
  private ValidationFailureResponseCode validationFailureResponseCode;
  @Autowired
  private EmployeeService employeeService;
  @Autowired
  private ProjectService projectService;

  /*
   * Description: Create Project Allocation API || Author: kajanthan || Date: 22-04-2023
   */
  @PostMapping(value = EndPointURI.PROJECT_ALLOCATION)
  public ResponseEntity<Object> createProjectAllocation(
      @RequestBody ProjectAllocationRequestDto projectAllocationRequestDto) {

    Project project = new Project();
    project.setId(projectAllocationRequestDto.getProjectId());
    Employee employee = new Employee();
    employee.setId(projectAllocationRequestDto.getEmployeeId());
    employee.setAvailability(projectAllocationRequestDto.getEmployeeAvailability());
    ProjectAllocation projectAllocation = new ProjectAllocation();
    BeanUtils.copyProperties(projectAllocationRequestDto, projectAllocation);
    projectAllocation.setProject(project);
    projectAllocation.setEmployee(employee);
    projectAllocationService.saveProjectAllocation(projectAllocation);
    return new ResponseEntity<>(
        new BasicResponse(RestApiResponseStatus.OK, Constants.ADD_PROJECT_ALLOCATION_SUCCESS),
        HttpStatus.OK);
  }

  /*
   * Description: Get all Project Allocation API || Author: kajanthan || Date: 22-04-2023
   */
  @GetMapping(value = EndPointURI.PROJECT_ALLOCATIONS)
  public ResponseEntity<Object> getAllProjectAllocation() {
    return new ResponseEntity<>(
        new ContentResponse<>(Constants.PROJECT_ALLOCATION,
            projectAllocationService.getAllProjectAllocation(), RestApiResponseStatus.OK),
        null, HttpStatus.OK);
  }

  /*
   * Description: Get Project Allocation by id API || Author: kajanthan || Date: 22-04-2023
   */
  @GetMapping(value = EndPointURI.PROJECT_ALLOCATION_BY_ID)
  public ResponseEntity<Object> getProjectAllocationById(@PathVariable Long id) {
    if (!projectAllocationService.existByProjectAllocation(id)) {
      return new ResponseEntity<>(
          new ValidationFailureResponse(Constants.PROJECT_ALLOCATION_NOT_EXISTS,
              validationFailureResponseCode.getProjectAllocationNotExists()),
          HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(
        new ContentResponse<>(Constants.PROJECT_ALLOCATION,
            projectAllocationService.getProjectAllocationById(id), RestApiResponseStatus.OK),
        null, HttpStatus.OK);
  }

  /*
   * Description: Delete Project Allocation API || Author: kajanthan || Date: 22-04-2023
   */
  @DeleteMapping(value = EndPointURI.PROJECT_ALLOCATION_BY_ID)
  public ResponseEntity<Object> deleteProjectAllocation(@PathVariable Long id) {
    if (projectAllocationService.existByProjectAllocation(id)) {
      projectAllocationService.deleteProjectAllocation(id);
      return new ResponseEntity<>(
          new BasicResponse(RestApiResponseStatus.OK, Constants.DELETE_PROJECT_ALLOCATION_SUCCESS),
          HttpStatus.OK);
    }
    return new ResponseEntity<>(
        new ValidationFailureResponse(Constants.PROJECT_ALLOCATION_NOT_EXISTS,
            validationFailureResponseCode.getProjectAllocationNotExists()),
        HttpStatus.BAD_REQUEST);
  }

  /*
   * Description: Get Project Allocation by Project_id API || Author: kajanthan || Date: 22-04-2023
   */

  @GetMapping(value = EndPointURI.PROJECT_ALLOCATION_PROJECT_BY_ID)
  public ResponseEntity<Object> getProjectAllocationByProjectId(@PathVariable Long id) {
    if (!projectService.existByProject(id)) {
      return new ResponseEntity<>(
          new ValidationFailureResponse(Constants.PROJECT_ALLOCATION_NOT_EXISTS,
              validationFailureResponseCode.getProjectAllocationNotExists()),
          HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(new ContentResponse<>(Constants.PROJECT_ALLOCATION,
        projectAllocationService.getAllProjectAllocationByProjectId(id), RestApiResponseStatus.OK),
        null, HttpStatus.OK);
  }
  /*
   * Description: Get Project Allocation by Employee_id API || Author: kajanthan || Date: 22-04-2023
   */

  @GetMapping(value = EndPointURI.PROJECT_ALLOCATION_EMPLOYEE_BY_ID)
  public ResponseEntity<Object> getProjectAllocationByEmployeeId(@PathVariable Long id) {
    if (!employeeService.existByEmployee(id)) {
      return new ResponseEntity<>(
          new ValidationFailureResponse(Constants.PROJECT_ALLOCATION_NOT_EXISTS,
              validationFailureResponseCode.getProjectAllocationNotExists()),
          HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(new ContentResponse<>(Constants.PROJECT_ALLOCATION,
        projectAllocationService.getAllProjectAllocationByEmployeeId(id), RestApiResponseStatus.OK),
        null, HttpStatus.OK);
  }


  /*
   * Description: Update Project Allocation API || Author: kajanthan || Date:22-04-2023
   */
  @PutMapping(value = EndPointURI.PROJECT_ALLOCATION)
  public ResponseEntity<Object> updateProjectAllocation(
      @RequestBody ProjectAllocationRequestDto projectAllocationRequestDto) {
    if (projectAllocationService.existByProjectAllocation(projectAllocationRequestDto.getId())) {

      Project project = new Project();
      project.setId(projectAllocationRequestDto.getProjectId());
      Employee employee = new Employee();
      employee.setId(projectAllocationRequestDto.getEmployeeId());
      employee.setAvailability(projectAllocationRequestDto.getEmployeeAvailability());
      ProjectAllocation projectAllocation = new ProjectAllocation();
      BeanUtils.copyProperties(projectAllocationRequestDto, projectAllocation);
      projectAllocation.setProject(project);
      projectAllocation.setEmployee(employee);
      projectAllocationService.saveProjectAllocation(projectAllocation);
      return new ResponseEntity<>(
          new BasicResponse(RestApiResponseStatus.OK, Constants.UPDATE_PROJECT_ALLOCATION_SUCCESS),
          HttpStatus.OK);
    }
    return new ResponseEntity<>(
        new ValidationFailureResponse(Constants.PROJECT_ALLOCATION_NOT_EXISTS,
            validationFailureResponseCode.getProjectAllocationNotExists()),
        HttpStatus.BAD_REQUEST);
  }
}
