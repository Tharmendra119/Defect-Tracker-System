package com.sgic.semita.services;

import java.util.List;
import com.sgic.semita.entities.SubModule;

public interface SubModuleService {
  
public void saveSubModule(SubModule subModule);
public List<SubModule> getAllSubModule();
public SubModule getSubModuleById(Long id);
public void deleteSubModule(Long id);
public boolean isUpdatedSubModuleNameExist(Long id, String name);
public boolean existBySubModule(Long id);
public boolean isSubModuleExists(String name);
}
