package com.sgic.semita.services;

import java.util.List;
import com.sgic.semita.entities.Release;

public interface ReleaseService {
  
  public void saveRelease(Release release);

  public List<Release> getAllRelease();

  public boolean isReleaseExists(String name);

  public Release getReleaseById(Long id);

  public boolean existByRelease(Long id);

  public boolean isUpdatedReleaseNameExist(Long id, String name);

  public void deleteRelease(Long id);
}
