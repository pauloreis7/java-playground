package com.pauloreis.noSqlSocialMedia.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {

  private Long timestamp;
  private Integer status;
  private String error;
  private String message;
  private String path;

  public StandardError() {
  }

  public StandardError(
      final Long timestamp,
      final Integer status,
      final String error,
      final String message,
      final String path) {

    this.timestamp = timestamp;
    this.status = status;
    this.error = error;
    this.message = message;
    this.path = path;
  }

  public Long getTimestamp() {
    return timestamp;
  }

  public Integer getStatus() {
    return status;
  }

  public String getError() {
    return error;
  }

  public String getMessage() {
    return message;
  }

  public String getPath() {
    return path;
  }
}
