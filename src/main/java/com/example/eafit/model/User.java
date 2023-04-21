package com.example.eafit.model;

import java.util.UUID;

public class User {
  private String id;
  private String username;
  private String password;

  private String email;

  private boolean isActive;

  public User(String username, String password, String email) {
    this.id = UUID.randomUUID().toString();
    this.username = username;
    this.password = password;
    this.email = email;
    this.isActive = true;
  }
  
  public String getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean active) {
    isActive = active;
  }
}
