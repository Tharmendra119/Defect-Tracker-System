package com.sgic.semita.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.semita.entities.SubModule;
import com.sgic.semita.repositories.SubModuleRepository;
import com.sgic.semita.services.SubModuleService;
@Service
public class SubModuleServiceImpl implements SubModuleService{
  @Autowired
  private SubModuleRepository subModuleRepository;
  @Override
  public void saveSubModule(SubModule subModule) {
   subModuleRepository.save(subModule);  
  }

  @Override
  public List<SubModule> getAllSubModule() {
    return subModuleRepository.findAll();
  }

  @Override
  public SubModule getSubModuleById(Long id) {
    return subModuleRepository.findById(id).get();
  }

  @Override
  public void deleteSubModule(Long id) {
    subModuleRepository.deleteById(id); 
  }

  @Override
  public boolean isUpdatedSubModuleNameExist(Long id, String name) {
    if ((!getSubModuleById(id).getName().equalsIgnoreCase(name)) && (isSubModuleExists(name))) {
      return true;
    }
    return false;
  }

  @Override
  public boolean existBySubModule(Long id) {
   return subModuleRepository.existsById(id);
  }

  @Override
  public boolean isSubModuleExists(String name) {
    return subModuleRepository.existsByNameIgnoreCase(name); 
  }

}
