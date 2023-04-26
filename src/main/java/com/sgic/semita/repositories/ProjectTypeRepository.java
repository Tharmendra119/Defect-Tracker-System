package com.sgic.semita.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.semita.entities.ProjectType;

public interface ProjectTypeRepository extends JpaRepository<ProjectType,Long> {
  boolean existsByNameIgnoreCase(String name);
}
