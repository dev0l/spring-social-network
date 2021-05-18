package com.dev0l.springsocialnetwork.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Message {

  private String title;
  private String message;

//  @CreatedDate
//  @Column(name = "created_at", nullable = false, updatable = false)
//  private Date createdAt;
//
//  @LastModifiedDate
//  @Column(name = "modified_at")
//  private LocalDateTime modifieddAt;

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
