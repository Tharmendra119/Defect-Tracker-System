package com.sgic.semita.services;

import java.util.List;
import com.sgic.semita.entities.Module;

public interface ModuleService {
  
  public void saveModule(Module module);

  public List<Module> getAllModule();

  public boolean isModuleExists(String name);

  public Module getModuleById(Long id);

  public boolean existByModule(Long id);

  public boolean isUpdatedModuleNameExist(Long id, String name);

  public void deleteModule(Long id);
}
