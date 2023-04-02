package com.pauloreis.noSqlSocialMedia.domain.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.pauloreis.noSqlSocialMedia.domain.dtos.AuthorDTO;
import com.pauloreis.noSqlSocialMedia.domain.dtos.CommentDTO;

@Document
public class Post implements Serializable {

  @Id
  private String id;
  private Date date;
  private String title;
  private String body;
  private AuthorDTO author;

  private List<CommentDTO> comments = new ArrayList<>();

  public Post() {
  }

  public Post(
      final String id,
      final Date date,
      final String title,
      final String body,
      final AuthorDTO author) {
    this.id = id;
    this.date = date;
    this.title = title;
    this.body = body;
    this.author = author;
  }

  public String getId() {
    return id;
  }

  public Date getDate() {
    return date;
  }

  public String getTitle() {
    return title;
  }

  public String getBody() {
    return body;
  }

  public AuthorDTO getAuthor() {
    return author;
  }

  public List<CommentDTO> getComments() {
    return comments;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Post other = (Post) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }
}
