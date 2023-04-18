package com.sgic.semita.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.semita.entities.Designation;

public interface DesignationRepository extends JpaRepository<Designation, Long> {
  boolean existsByNameIgnoreCase(String name);
}
