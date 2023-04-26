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
import com.sgic.semita.entities.Module;
import com.sgic.semita.entities.ModuleAllocation;
import com.sgic.semita.entities.SubModule;
import com.sgic.semita.enums.RestApiResponseStatus;
import com.sgic.semita.request.dto.ModuleAllocationRequestDto;
import com.sgic.semita.services.EmployeeService;
import com.sgic.semita.services.ModuleAllocationService;
import com.sgic.semita.services.ProjectAllocationService;
import com.sgic.semita.utils.Constants;
import com.sgic.semita.utils.EndPointURI;
import com.sgic.semita.utils.ValidationFailureResponseCode;

@CrossOrigin
@RestController
public class ModuleAllocationController {
  @Autowired
  private ModuleAllocationService moduleAllocationService;
  @Autowired
  private ProjectAllocationService projectAllocationService;
  @Autowired
  private EmployeeService employeeService;
  @Autowired
  private ValidationFailureResponseCode validationFailureResponseCode;

  /*
   * Description: Create Module_Allocation API || Author: kajanthan || Date: 23-04-2023
   */
  @PostMapping(value = EndPointURI.MODULE_ALLOCATION)
  public ResponseEntity<Object> createModuleAllocation(
      @RequestBody ModuleAllocationRequestDto moduleAllocationRequestDto) {
    if (!projectAllocationService.existByEmployeeID(moduleAllocationRequestDto.getEmployeeId())) {
      return new ResponseEntity<>(
          new ValidationFailureResponse(Constants.MODULE_ALLOCATION_NOT_EXISTS,
              validationFailureResponseCode.getModuleAllocationAlreadyExists()),
          HttpStatus.BAD_REQUEST);
    }
    Module module = new Module();
    module.setId(moduleAllocationRequestDto.getModuleId());
    SubModule subModule = new SubModule();
    subModule.setId(moduleAllocationRequestDto.getSubModuleId());
    Employee employee = new Employee();
    employee.setId(moduleAllocationRequestDto.getEmployeeId());
    ModuleAllocation moduleAllocation = new ModuleAllocation();
    BeanUtils.copyProperties(moduleAllocationRequestDto, moduleAllocation);
    moduleAllocation.setModule(module);
    moduleAllocation.setSubModule(subModule);
    moduleAllocation.setEmployee(employee);
    moduleAllocationService.saveModuleAllocation(moduleAllocation);
    return new ResponseEntity<>(
        new BasicResponse(RestApiResponseStatus.OK, Constants.ADD_EMPLOYEE_SUCCESS), HttpStatus.OK);
  }

  /*
   * Description: Get All Module_Allocation API || Author: kajanthan || Date: 23-04-2023
   */
  @GetMapping(value = EndPointURI.MODULE_ALLOCATIONS)
  public ResponseEntity<Object> getAllModuleAllocation() {
    return new ResponseEntity<>(
        new ContentResponse<>(Constants.MODULE_ALLOCATIONS,
            moduleAllocationService.getAllModuleAllocation(), RestApiResponseStatus.OK),
        null, HttpStatus.OK);
  }

  /*
   * Description: Get Module_Allocation_by_id API || Author: kajanthan || Date: 23-04-2023
   */
  @GetMapping(value = EndPointURI.MODULE_ALLOCATION_BY_ID)
  public ResponseEntity<Object> getModuleAllocationById(@PathVariable Long id) {
    if (!moduleAllocationService.existByModuleAllocation(id)) {
      return new ResponseEntity<>(
          new ValidationFailureResponse(Constants.MODULE_ALLOCATION_NOT_EXISTS,
              validationFailureResponseCode.getModuleAllocationNotExists()),
          HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(
        new ContentResponse<>(Constants.MODULE_ALLOCATION,
            moduleAllocationService.getModuleAllocationById(id), RestApiResponseStatus.OK),
        null, HttpStatus.OK);
  }
  /*
   * Description: Get Module_Allocation_by_Employee_id API || Author: kajanthan || Date: 23-04-2023
   */

  @GetMapping(value = EndPointURI.MODULE_ALLOCATION__BY_EMPLOYEE_ID)
  public ResponseEntity<Object> getEmployeeByDesignationId(@PathVariable Long id) {
    if (!employeeService.existByEmployee(id)) {
      return new ResponseEntity<>(
          new ValidationFailureResponse(Constants.MODULE_ALLOCATION_NOT_EXISTS,
              validationFailureResponseCode.getModuleAllocationNotExists()),
          HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(new ContentResponse<>(Constants.MODULE_ALLOCATION,
        moduleAllocationService.getAllModuleAllocationByEmployeeId(id), RestApiResponseStatus.OK),
        null, HttpStatus.OK);
  }
  /*
   * Description: Update Module_Allocation API || Author: kajanthan || Date:23-04-2023
   */

  @PutMapping(value = EndPointURI.MODULE_ALLOCATION)
  public ResponseEntity<Object> updateeModuleAllocation(
      @RequestBody ModuleAllocationRequestDto moduleAllocationRequestDto) {
    if (moduleAllocationService.existByModuleAllocation(moduleAllocationRequestDto.getId())) {
      Module module = new Module();
      module.setId(moduleAllocationRequestDto.getModuleId());
      SubModule subModule = new SubModule();
      subModule.setId(moduleAllocationRequestDto.getSubModuleId());
      Employee employee = new Employee();
      employee.setId(moduleAllocationRequestDto.getEmployeeId());
      ModuleAllocation moduleAllocation = new ModuleAllocation();
      BeanUtils.copyProperties(moduleAllocationRequestDto, moduleAllocation);
      moduleAllocation.setModule(module);
      moduleAllocation.setSubModule(subModule);
      moduleAllocation.setEmployee(employee);
      moduleAllocationService.saveModuleAllocation(moduleAllocation);
      return new ResponseEntity<>(
          new BasicResponse(RestApiResponseStatus.OK, Constants.UPDATE_MODULE_ALLOCATION_SUCCESS),
          HttpStatus.OK);
    }
    return new ResponseEntity<>(
        new ValidationFailureResponse(Constants.MODULE_ALLOCATION_NOT_EXISTS,
            validationFailureResponseCode.getModuleAllocationNotExists()),
        HttpStatus.BAD_REQUEST);
  }

  /*
   * Description: Delete Module_Allocation API || Author: kajanthan || Date: 23-04-2023
   */
  @DeleteMapping(value = EndPointURI.MODULE_ALLOCATION_BY_ID)
  public ResponseEntity<Object> deleteModuleAllocation(@PathVariable Long id) {
    if (moduleAllocationService.existByModuleAllocation(id)) {
      moduleAllocationService.deleteModuleAllocation(id);
      return new ResponseEntity<>(
          new BasicResponse(RestApiResponseStatus.OK, Constants.DELETE_MODULE_ALLOCATION_SUCCESS),
          HttpStatus.OK);
    }
    return new ResponseEntity<>(
        new ValidationFailureResponse(Constants.MODULE_ALLOCATION_NOT_EXISTS,
            validationFailureResponseCode.getModuleAllocationNotExists()),
        HttpStatus.BAD_REQUEST);
  }

}
