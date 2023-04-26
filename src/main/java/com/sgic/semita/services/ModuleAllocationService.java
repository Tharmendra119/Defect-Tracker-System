package com.sgic.semita.services;

import java.util.List;
import com.sgic.semita.entities.ModuleAllocation;




public interface ModuleAllocationService {
  
  public void saveModuleAllocation(ModuleAllocation moduleAllocation);

  public List<ModuleAllocation> getAllModuleAllocation();

  public ModuleAllocation getModuleAllocationById(Long id);

  public boolean existByModuleAllocation(Long id);
  
  public void deleteModuleAllocation(Long id);
  
  public List<ModuleAllocation> getAllModuleAllocationByEmployeeId(long id);
  
}
