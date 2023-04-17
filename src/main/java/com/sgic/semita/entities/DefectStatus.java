package com.sgic.semita.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class DefectStatus {
  
  @Id
  private long id;
  private String name;
  private String color;

}
