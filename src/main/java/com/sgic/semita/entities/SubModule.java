package com.sgic.semita.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class SubModule {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String name;
@ManyToOne
@JoinColumn(name="module_id",nullable = false)
private Module module;
public Long getId() {
  return id;
}
public void setId(Long id) {
  this.id = id;
}
public String getName() {
  return name;
}
public void setName(String name) {
  this.name = name;
}
public Module getModule() {
  return module;
}
public void setModule(Module module) {
  this.module = module;
}


}
