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

  public void savePost(Post post) { postRepository.save(post); }

  public void deletePost(long id) {
    postRepository.deleteById(id);
  }

  public void deletePostsByAuthorId(long id) {
    postRepository.deleteAllByAuthorId(id);
  }

  public List<Post> getAllPosts(){
    return postRepository.findAll();
  }

  public List<Post> getPostByAuthorId(long id) {
    return postRepository.findByAuthorId(id);
  }

  public List<Post> getPostsByCreatedDate() {
    return postRepository.findAllByOrderByCreatedDateDesc();
  }

}
