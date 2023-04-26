package com.sgic.semita.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.semita.entities.Module;
import com.sgic.semita.repositories.ModuleRepository;
import com.sgic.semita.services.ModuleService;
@Service
public class ModuleServiceImpl implements ModuleService {

  @Autowired
  private ModuleRepository moduleRepository;

  @Override
  public void saveModule(Module module) {
    moduleRepository.save(module);
  }

  @Override
  public List<Module> getAllModule() {
    return moduleRepository.findAll();
  }

  @Override
  public boolean isModuleExists(String name) {
    return moduleRepository.existsByNameIgnoreCase(name);
  }

  @Override
  public Module getModuleById(Long id) {
    return moduleRepository.findById(id).get();
  }

  @Override
  public boolean existByModule(Long id) {
    return moduleRepository.existsById(id);
  }

  @Override
  public boolean isUpdatedModuleNameExist(Long id, String name) {
  if((!getModuleById(id).getName().equalsIgnoreCase(name))&&(isModuleExists(name))){
  return true;
}
    return false;
  }

  @Override
  public void deleteModule(Long id) {
    moduleRepository.deleteById(id);

  }

}
