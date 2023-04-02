package com.pauloreis.noSqlSocialMedia.domain.dtos;

import java.io.Serializable;

import com.pauloreis.noSqlSocialMedia.domain.entities.User;

public class AuthorDTO implements Serializable {

  private String id;
  private String name;

  public AuthorDTO() {
  }

  public AuthorDTO(final User user) {
    this.id = user.getId();
    this.name = user.getName();

  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
