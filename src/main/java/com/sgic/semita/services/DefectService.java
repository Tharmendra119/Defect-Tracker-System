package com.sgic.semita.services;

import java.util.List;
import com.sgic.semita.entities.Defect;

public interface DefectService {
  
  public void saveDefect(Defect defect);

  public List<Defect> getAllDefect();

  public Defect getDefectById(Long id);

  public boolean existByDefect(Long id);

  public void deleteDefect(Long id);

  public List<Defect> getAllDefectByProjectId(long id);
  
  public boolean isDefectExistsByCode(String code);

  public boolean isUpdatedDefectCodeExist(Long id, String code);
}
