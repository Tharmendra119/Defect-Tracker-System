package com.sgic.semita.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class DefectType {
  @Id
  private String id;
  private String name;

}
