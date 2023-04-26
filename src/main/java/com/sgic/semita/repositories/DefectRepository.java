package com.sgic.semita.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sgic.semita.entities.Defect;


public interface DefectRepository extends JpaRepository<Defect,Long>{
  public List<Defect> findByProjectId(Long projectId);
  public boolean existsByCodeIgnoreCase(String code);
}
