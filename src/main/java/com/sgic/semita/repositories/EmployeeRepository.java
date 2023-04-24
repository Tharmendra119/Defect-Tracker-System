package com.sgic.semita.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sgic.semita.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>  {

  public boolean existsByEmailIgnoreCase(String email);
  public boolean existsByContactNumberIgnoreCase(String contactNumber);
  public List<Employee> findByDesignationId(Long designationId);
}
