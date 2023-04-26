package com.sgic.semita.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.semita.entities.ModuleAllocation;
import com.sgic.semita.repositories.ModuleAllocationRepository;
import com.sgic.semita.services.ModuleAllocationService;
@Service
public class ModuleAllocationServiceImpl implements ModuleAllocationService{
@Autowired
private ModuleAllocationRepository moduleAllocationRepository;
  @Override
  public void saveModuleAllocation(ModuleAllocation moduleAllocation) {
    moduleAllocationRepository.save(moduleAllocation); 
  }

  @Override
  public List<ModuleAllocation> getAllModuleAllocation() {
    return moduleAllocationRepository.findAll();
  }

  @Override
  public ModuleAllocation getModuleAllocationById(Long id) { 
    return moduleAllocationRepository.findById(id).get();
  }

  @Override
  public boolean existByModuleAllocation(Long id) {
        return moduleAllocationRepository.existsById(id);
  }

  @Override
  public void deleteModuleAllocation(Long id) {
    moduleAllocationRepository.deleteById(id);
  }

  @Override
  public List<ModuleAllocation> getAllModuleAllocationByEmployeeId(long id) {
    return moduleAllocationRepository.findByEmployeeId(id);
  }

}
