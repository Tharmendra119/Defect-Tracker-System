package com.sgic.semita.services;

import java.util.List;
import com.sgic.semita.entities.ProjectType;

public interface ProjectTypeService {
  
  public void saveProjectType(ProjectType projectType);

  public List<ProjectType> getAllProjectType();

  public boolean isProjectTypeExists(String name);

  public ProjectType getProjectTypeById(Long id);

  public boolean existByProjectType(Long id);

  public boolean isUpdatedProjectTypeNameExist(Long id, String name);

  public void deleteProjectType(Long id);
}
