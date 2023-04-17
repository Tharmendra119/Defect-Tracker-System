package com.sgic.semita.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
  @Id
  private long id;
  private String firstName;
  private String lastName;
  private String gender;
  private Designation designation;
  private String email;
  private int contactNumber;
  private String availability;
}
