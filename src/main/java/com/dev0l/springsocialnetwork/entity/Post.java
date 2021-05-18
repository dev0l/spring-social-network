package com.dev0l.springsocialnetwork.entity;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post extends Message {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String author;

  public Post() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

//  @Override
//  public String toString() {
//    return "Post{" +
//            "id=" + id +
//            ", title='" + title + '\'' +
//            '}';
//  }
}
