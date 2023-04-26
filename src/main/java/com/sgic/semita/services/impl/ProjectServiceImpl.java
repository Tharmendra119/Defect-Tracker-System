package com.sgic.semita.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.semita.entities.Project;
import com.sgic.semita.repositories.ProjectRepository;
import com.sgic.semita.services.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {
  @Autowired
  private ProjectRepository projectRepository;
  @Override
  public void saveProject(Project project) {
    projectRepository.save(project);
  }

  @Override
  public List<Project> getAllProject() {
    return projectRepository.findAll();
  }

  @Override
  public boolean isProjectExists(String projectName) {
    return projectRepository.existsByProjectNameIgnoreCase(projectName);
  }

  @Override
  public Project getProjectById(Long id) {
    return projectRepository.findById(id).get();
  }

  @Override
  public boolean existByProject(Long id) {
    return projectRepository.existsById(id);
  }

  @Override
  public boolean isUpdatedProjectNameExist(Long id, String projectName) {
    if((!getProjectById(id).getProjectName().equalsIgnoreCase(projectName))&&(isProjectExists(projectName))) {
      return true;
    }
    return false;
  }

  @Override
  public void deleteProject(Long id) {
    projectRepository.deleteById(id);
  }

}
