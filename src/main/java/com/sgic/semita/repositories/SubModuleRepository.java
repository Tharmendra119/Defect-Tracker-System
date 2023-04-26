package com.sgic.semita.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sgic.semita.entities.SubModule;

public interface SubModuleRepository extends JpaRepository<SubModule,Long> {
  boolean existsByNameIgnoreCase(String name);
}
