package com.sgic.semita.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.semita.entities.ProjectType;
import com.sgic.semita.repositories.ProjectTypeRepository;
import com.sgic.semita.services.ProjectTypeService;
@Service
public class ProjectTypeServiceImpl implements ProjectTypeService {
  
  @Autowired
  private ProjectTypeRepository projectTypeRepository;

  @Override
  public void saveProjectType(ProjectType projectType) {
    projectTypeRepository.save(projectType); 
  }

  @Override
  public List<ProjectType> getAllProjectType() {
    return projectTypeRepository.findAll();
  }

  @Override
  public boolean isProjectTypeExists(String name) {
    return projectTypeRepository.existsByNameIgnoreCase(name);
  }

  @Override
  public ProjectType getProjectTypeById(Long id) { 
    return projectTypeRepository.findById(id).get();
  }

  @Override
  public boolean existByProjectType(Long id) {
    return projectTypeRepository.existsById(id);
  }

  @Override
  public boolean isUpdatedProjectTypeNameExist(Long id, String name) {
    if((!getProjectTypeById(id).getName().equalsIgnoreCase(name))&&(isProjectTypeExists(name))) {
      return true;
    }
    return false;
  }

  @Override
  public void deleteProjectType(Long id) {
    projectTypeRepository.deleteById(id);
    
  }

}
