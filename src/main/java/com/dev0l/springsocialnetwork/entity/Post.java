package com.dev0l.springsocialnetwork.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "posts")
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
//  private String author;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "author_id", referencedColumnName = "id")
  private User user;

  @Column(columnDefinition = "TEXT")
  private String title;

  @Column(columnDefinition = "TEXT")
  private String content;

  @Column(name = "createdDate", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private Date createdDate;

  public Post() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
}

//@Entity
//@Table(name = "posts")
//public class Post extends Message {
//
//  @Id
//  @GeneratedValue(strategy = GenerationType.AUTO)
//  private Long id;
//  private String author;
//
//  public Post() {
//  }
//
//  public Long getId() {
//    return id;
//  }
//
//  public void setId(Long id) {
//    this.id = id;
//  }
//
//  public String getAuthor() {
//    return author;
//  }
//
//  public void setAuthor(String author) {
//    this.author = author;
//  }
//
////  @Override
////  public String toString() {
////    return "Post{" +
////            "id=" + id +
////            ", title='" + title + '\'' +
////            '}';
////  }
//}
