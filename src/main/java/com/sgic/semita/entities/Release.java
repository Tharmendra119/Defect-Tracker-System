package com.sgic.semita.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Release {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
 private Long id;
 private String name;
public long getId() {
  return id;
}
public void setId(long id) {
  this.id = id;
}
public String getName() {
  return name;
}
public void setName(String name) {
  this.name = name;
}
 
}
