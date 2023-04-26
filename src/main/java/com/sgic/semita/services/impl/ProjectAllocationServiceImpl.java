package com.sgic.semita.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.semita.entities.ProjectAllocation;
import com.sgic.semita.repositories.ProjectAllocationRepository;
import com.sgic.semita.services.ProjectAllocationService;
@Service
public class ProjectAllocationServiceImpl implements ProjectAllocationService {
@Autowired
private ProjectAllocationRepository projectAllocationRepository;
  @Override
  public void saveProjectAllocation(ProjectAllocation projectAllocation) {
   projectAllocationRepository.save(null);
  }

  @Override
  public List<ProjectAllocation> getAllProjectAllocation() {
    return projectAllocationRepository.findAll();
  }

  @Override
  public ProjectAllocation getProjectAllocationById(Long id) {
    return projectAllocationRepository.findById(id).get();
  }

  @Override
  public boolean existByProjectAllocation(Long id) {
    return projectAllocationRepository.existsById(id);
  }

  @Override
  public void deleteProjectAllocation(Long id) {
   projectAllocationRepository.deleteById(id);
  }

  @Override
  public List<ProjectAllocation> getAllProjectAllocationByProjectId(long id) {
    return projectAllocationRepository.findByProjectId(id);
  }

  @Override
  public List<ProjectAllocation> getAllProjectAllocationByEmployeeId(long id) {
    return projectAllocationRepository.findByEmployeeId(id);
  }

  @Override
  public boolean existByEmployeeID(Long id) {
    return projectAllocationRepository.existsByEmployeeId(id);
  }

}
