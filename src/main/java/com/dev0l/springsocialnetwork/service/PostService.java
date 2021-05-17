package com.dev0l.springsocialnetwork.service;

import com.dev0l.springsocialnetwork.entity.Post;
import com.dev0l.springsocialnetwork.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

  @Autowired
  private PostRepository postRepository;

  public void savePost(Post post){
    postRepository.save(post);
  }

  public List<Post> getAllPosts(){
    return postRepository.findAll();
  }

  public Post getPostByTitle(String title){
    return postRepository.findByTitle(title);
  }

  public Post getPostById(Long id){
    return postRepository.findById(id).orElseThrow();
  }
}
