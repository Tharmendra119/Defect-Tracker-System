package com.sgic.semita.services;

import java.util.List;
import com.sgic.semita.entities.Project;


public interface ProjectService {
  
  public void saveProject(Project project);

  public List<Project> getAllProject();

  public boolean isProjectExists(String projectName);

  public Project getProjectById(Long id);

  public boolean existByProject(Long id);

  public boolean isUpdatedProjectNameExist(Long id, String projectName);
  
  public void deleteProject(Long id);
}
