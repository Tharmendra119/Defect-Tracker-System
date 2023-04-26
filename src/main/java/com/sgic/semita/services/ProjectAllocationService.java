package com.sgic.semita.services;

import java.util.List;
import com.sgic.semita.entities.ProjectAllocation;


public interface ProjectAllocationService {

  public void saveProjectAllocation(ProjectAllocation projectAllocation);

  public List<ProjectAllocation> getAllProjectAllocation();

  public ProjectAllocation getProjectAllocationById(Long id);

  public boolean existByProjectAllocation(Long id);

  public void deleteProjectAllocation(Long id);

  public List<ProjectAllocation> getAllProjectAllocationByProjectId(long id);

  public List<ProjectAllocation> getAllProjectAllocationByEmployeeId(long id);

  public boolean existByEmployeeID(Long id);
}
