package com.dev0l.springsocialnetwork.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Message {

  private String title;
  private String content;

  public Message() {
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getMessage() {
    return content;
  }

  public void setMessage(String message) {
    this.content = message;
  }
}
