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
import com.sgic.semita.entities.Designation;
import com.sgic.semita.entities.Employee;
import com.sgic.semita.enums.RestApiResponseStatus;
import com.sgic.semita.request.dto.EmployeeRequestDto;
import com.sgic.semita.services.DesignationService;
import com.sgic.semita.services.EmployeeService;
import com.sgic.semita.utils.Constants;
import com.sgic.semita.utils.EndPointURI;
import com.sgic.semita.utils.ValidationFailureResponseCode;

@CrossOrigin
@RestController
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @Autowired
  private DesignationService designationService;


  @Autowired
  private ValidationFailureResponseCode validationFailureResponseCode;

  /*
   * Description: Create Employee API || Author: kajanthan || Date: 19-04-2023
   */
  @PostMapping(value = EndPointURI.EMPLOYEE)
  public ResponseEntity<Object> createDesignation(
      @RequestBody EmployeeRequestDto employeeRequestDto) {
    if (employeeService.isEmployeeExistsByEmail(employeeRequestDto.getEmail()) || (employeeService
        .isEmployeeExistsByContactNumber(employeeRequestDto.getContactNumber()))) {
      return new ResponseEntity<>(new ValidationFailureResponse(Constants.EMPLOYEE_ALREADY_EXISTS,
          validationFailureResponseCode.getEmployeeAlreadyExists()), HttpStatus.BAD_REQUEST);
    }
    Designation designation = new Designation();
    designation.setId(employeeRequestDto.getDesignationId());
    Employee employee = new Employee();
    BeanUtils.copyProperties(employeeRequestDto, employee);
    employee.setDesignation(designation);
    employeeService.saveEmployee(employee);
    return new ResponseEntity<>(
        new BasicResponse(RestApiResponseStatus.OK, Constants.ADD_EMPLOYEE_SUCCESS), HttpStatus.OK);
  }

  /*
   * Description: Get all Employee API || Author: kajanthan || Date: 19-04-2023
   */
  @GetMapping(value = EndPointURI.EMPLOYEES)
  public ResponseEntity<Object> getAllEmployees() {
    return new ResponseEntity<>(new ContentResponse<>(Constants.EMPLOYEES,
        employeeService.getAllEmployee(), RestApiResponseStatus.OK), null, HttpStatus.OK);
  }

  /*
   * Description: Get Employee by id API || Author: kajanthan || Date: 19-04-2023
   */
  @GetMapping(value = EndPointURI.EMPLOYEE_BY_ID)
  public ResponseEntity<Object> getEmployeeById(@PathVariable Long id) {
    if (!employeeService.existByEmployee(id)) {
      return new ResponseEntity<>(new ValidationFailureResponse(Constants.EMPLOYEE_NOT_EXISTS,
          validationFailureResponseCode.getEmployeeNotExists()), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(new ContentResponse<>(Constants.EMPLOYEE,
        employeeService.getEmployeeById(id), RestApiResponseStatus.OK), null, HttpStatus.OK);
  }

  /*
   * Description: Get Employee by Designation_id API || Author: kajanthan || Date: 21-04-2023
   */

  @GetMapping(value = EndPointURI.EMPLOYEE_DESIGNATION_BY_ID)
  public ResponseEntity<Object> getEmployeeByDesignationId(@PathVariable Long id) {
    if (!designationService.existByDesignation(id)) {
      return new ResponseEntity<>(new ValidationFailureResponse(Constants.EMPLOYEE_NOT_EXISTS,
          validationFailureResponseCode.getEmployeeNotExists()), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(new ContentResponse<>(Constants.EMPLOYEE,
        employeeService.getAllEmployeeByDesignationId(id), RestApiResponseStatus.OK), null,
        HttpStatus.OK);
  }

  /*
   * Description: Delete Employee API || Author: kajanthan || Date: 18-04-2023
   */
  @DeleteMapping(value = EndPointURI.EMPLOYEE_BY_ID)
  public ResponseEntity<Object> deleteEmployee(@PathVariable Long id) {
    if (employeeService.existByEmployee(id)) {
      employeeService.deleteEmployee(id);
      return new ResponseEntity<>(
          new BasicResponse(RestApiResponseStatus.OK, Constants.DELETE_EMPLOYEE_SUCCESS),
          HttpStatus.OK);
    }
    return new ResponseEntity<>(new ValidationFailureResponse(Constants.EMPLOYEE_NOT_EXISTS,
        validationFailureResponseCode.getEmployeeNotExists()), HttpStatus.BAD_REQUEST);
  }
  /*
   * Description: Update Employee API || Author: kajanthan || Date:20-04-2023
   */

  @PutMapping(value = EndPointURI.EMPLOYEE)
  public ResponseEntity<Object> updateEmployee(@RequestBody EmployeeRequestDto empolyeeRequestDto) {
    if (employeeService.existByEmployee(empolyeeRequestDto.getId())) {
      if ((employeeService.isUpdatedEmployeeEmailExist(empolyeeRequestDto.getId(),
          empolyeeRequestDto.getEmail()))
          || (employeeService.isUpdatedEmployeeContactNumberExist(empolyeeRequestDto.getId(),
              empolyeeRequestDto.getContactNumber()))) {
        return new ResponseEntity<>(new ValidationFailureResponse(Constants.EMPLOYEE_ALREADY_EXISTS,
            validationFailureResponseCode.getEmployeeAlreadyExists()), HttpStatus.BAD_REQUEST);
      }
      Designation designation = new Designation();
      designation.setId(empolyeeRequestDto.getDesignationId());
      Employee employee = new Employee();
      employee.setDesignation(designation);
      BeanUtils.copyProperties(empolyeeRequestDto, employee);
      employeeService.saveEmployee(employee);
      return new ResponseEntity<>(
          new BasicResponse(RestApiResponseStatus.OK, Constants.UPDATE_EMPLOYEE_SUCCESS),
          HttpStatus.OK);
    }
    return new ResponseEntity<>(new ValidationFailureResponse(Constants.EMPLOYEE_NOT_EXISTS,
        validationFailureResponseCode.getEmployeeNotExists()), HttpStatus.BAD_REQUEST);
  }
}
