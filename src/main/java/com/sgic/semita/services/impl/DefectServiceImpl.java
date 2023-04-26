package com.sgic.semita.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.semita.entities.Defect;
import com.sgic.semita.repositories.DefectRepository;
import com.sgic.semita.services.DefectService;
@Service
public class DefectServiceImpl implements DefectService{
@Autowired
private DefectRepository defectRepository;
  @Override
  public void saveDefect(Defect defect) {
    defectRepository.save(defect);
  }

  @Override
  public List<Defect> getAllDefect() {
    return defectRepository.findAll();
  }

  @Override
  public Defect getDefectById(Long id) {
    return defectRepository.findById(id).get();
  }

  @Override
  public boolean existByDefect(Long id) {
    return defectRepository.existsById(id);
  }

  @Override
  public void deleteDefect(Long id) {
    defectRepository.deleteById(id);
  }

  @Override
  public List<Defect> getAllDefectByProjectId(long id) {
    return defectRepository.findByProjectId(id);
  }

  @Override
  public boolean isDefectExistsByCode(String code) {
    if (defectRepository.existsByCodeIgnoreCase(code)) {
      return true;
    }
    return false;
  }
  

  @Override
  public boolean isUpdatedDefectCodeExist(Long id, String code) {
    if ((!getDefectById(id).getCode().equalsIgnoreCase(code))
        && (isDefectExistsByCode(code))) {
      return true;
    }
    return false;

  }

}
