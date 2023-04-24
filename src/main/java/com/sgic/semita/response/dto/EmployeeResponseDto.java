package com.sgic.semita.response.dto;


import com.sgic.semita.entities.Designation;

public class EmployeeResponseDto {
  private long id;
  private String firstName;
  private String lastName;
  private String gender;
  private Designation designation;
  private String email;
  private String contactNumber;
  private String availability;
  
  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }
  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  public String getLastName() {
    return lastName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  public String getGender() {
    return gender;
  }
  public void setGender(String gender) {
    this.gender = gender;
  }
 
  
  public Designation getDesignation() {
    return designation;
  }
  public void setDesignation(Designation designation) {
    this.designation = designation;
  }
  
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getContactNumber() {
    return contactNumber;
  }
  public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
  }
  public String getAvailability() {
    return availability;
  }
  public void setAvailability(String availability) {
    this.availability = availability;
  }
  
 
  
  
}
