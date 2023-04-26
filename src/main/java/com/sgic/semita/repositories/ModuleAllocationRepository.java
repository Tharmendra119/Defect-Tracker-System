package com.sgic.semita.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sgic.semita.entities.ModuleAllocation;


public interface ModuleAllocationRepository extends JpaRepository<ModuleAllocation,Long>{
  public List<ModuleAllocation> findByEmployeeId(Long EmployeeId);
}
