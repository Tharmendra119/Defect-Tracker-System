package com.sgic.semita.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.semita.entities.Release;

public interface ReleaseRepository extends JpaRepository<Release,Long> {
  boolean existsByNameIgnoreCase(String name);
}
