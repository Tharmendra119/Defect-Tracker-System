package com.sgic.semita.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sgic.semita.entities.ProjectAllocation;

public interface ProjectAllocationRepository extends JpaRepository<ProjectAllocation,Long>{
  public List<ProjectAllocation> findByProjectId(Long projectId);
  public List<ProjectAllocation> findByEmployeeId(Long employeeId);
  public  boolean existsByEmployeeId(Long employeeId);
}
