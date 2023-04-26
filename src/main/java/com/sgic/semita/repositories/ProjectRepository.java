package com.sgic.semita.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sgic.semita.entities.Project;

public interface ProjectRepository extends JpaRepository<Project,Long>{
  boolean existsByProjectNameIgnoreCase(String projectName);
}
