package com.dev0l.springsocialnetwork.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Message {

  private String title;
  private String message;

  public Message() {
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
