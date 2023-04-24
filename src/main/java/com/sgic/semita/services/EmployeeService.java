package com.sgic.semita.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.sgic.semita.entities.Employee;
@Service
public interface EmployeeService {
  
  public void saveEmployee(Employee employee);

  public List<Employee> getAllEmployee();
  
  public Employee getEmployeeById(Long id);
  
  public boolean isEmployeeExistsByEmail(String email);
  
  public boolean existByEmployee(Long id);
  
  public boolean isEmployeeExistsByContactNumber(String contactNumber);
  
  public void deleteEmployee(Long id);
  
  public boolean isUpdatedEmployeeEmailExist(Long id, String email);
  
  public boolean isUpdatedEmployeeContactNumberExist(Long id, String contactNumber);

  public List<Employee> getAllEmployeeByDesignationId(long id);
}
