package com.sgic.semita.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.semita.entities.Module;

public interface ModuleRepository extends JpaRepository<Module,Long> {
  boolean existsByNameIgnoreCase(String name);
}
