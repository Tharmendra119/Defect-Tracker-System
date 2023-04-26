package com.sgic.semita.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.semita.entities.Release;
import com.sgic.semita.repositories.ReleaseRepository;
import com.sgic.semita.services.ReleaseService;
@Service
public class ReleaseServiceImpl implements ReleaseService{
  
  @Autowired
  private ReleaseRepository releaseRepository;

  @Override
  public void saveRelease(Release release) {
    releaseRepository.save(release);
  }

  @Override
  public List<Release> getAllRelease() {
    return releaseRepository.findAll();
  }

  @Override
  public boolean isReleaseExists(String name) {
    return releaseRepository.existsByNameIgnoreCase(name);
  }

  @Override
  public Release getReleaseById(Long id) {
    return releaseRepository.findById(id).get();
  }

  @Override
  public boolean existByRelease(Long id) {
    return releaseRepository.existsById(id);
  }

  @Override
  public boolean isUpdatedReleaseNameExist(Long id, String name) {
    if((!getReleaseById(id).getName().equalsIgnoreCase(name))&&(isReleaseExists(name))) {
      return true;
    }
    return false;
  }

  @Override
  public void deleteRelease(Long id) {
  releaseRepository.deleteById(id);
  }

}
