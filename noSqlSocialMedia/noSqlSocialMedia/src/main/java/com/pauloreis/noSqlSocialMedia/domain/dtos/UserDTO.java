package com.pauloreis.noSqlSocialMedia.domain.dtos;

import java.io.Serializable;

import com.pauloreis.noSqlSocialMedia.domain.entities.User;

public class UserDTO implements Serializable {

  private String id;
  private String name;
  private String email;

  public UserDTO() {
  }

  public UserDTO(final User user) {
    this.id = user.getId();
    this.name = user.getName();
    this.email = user.getEmail();
  }

  public String getId() {
    return id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }
}
