package com.sgic.semita.services.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.semita.entities.Employee;
import com.sgic.semita.repositories.EmployeeRepository;
import com.sgic.semita.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Override
  public void saveEmployee(Employee employee) {
    employeeRepository.save(employee);
  }

  @Override
  public List<Employee> getAllEmployee() {
    return employeeRepository.findAll();

  }

  @Override
  public boolean isEmployeeExistsByEmail(String email) {
    if (employeeRepository.existsByEmailIgnoreCase(email)) {
      return true;
    }
    return false;
  }

  @Override
  public Employee getEmployeeById(Long id) {
    return employeeRepository.findById(id).get();
  }

  @Override
  public boolean existByEmployee(Long id) {
    return employeeRepository.existsById(id);
  }

  @Override
  public boolean isEmployeeExistsByContactNumber(String contactNumber) {
    if (employeeRepository.existsByContactNumberIgnoreCase(contactNumber)) {
      return true;
    }
    return false;
  }

  @Override
  public void deleteEmployee(Long id) {
    employeeRepository.deleteById(id);
  }

  @Override
  public boolean isUpdatedEmployeeEmailExist(Long id, String email) {
    if ((!getEmployeeById(id).getEmail().equalsIgnoreCase(email))
        && (isEmployeeExistsByEmail(email))) {
      return true;
    }
    return false;

  }

  @Override
  public boolean isUpdatedEmployeeContactNumberExist(Long id, String contactNumber) {
    if ((!getEmployeeById(id).getContactNumber().equalsIgnoreCase(contactNumber))
        && (isEmployeeExistsByContactNumber(contactNumber))) {
      return true;
    }
    return false;
  }

  @Override
  public List<Employee> getAllEmployeeByDesignationId(long id) {
    return employeeRepository.findByDesignationId(id);
  }
  
   
}
