package com.dev0l.springsocialnetwork.service;

import com.dev0l.springsocialnetwork.entity.Post;
import com.dev0l.springsocialnetwork.entity.User;
import com.dev0l.springsocialnetwork.repository.PostRepository;
import com.dev0l.springsocialnetwork.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private UserRepository userRepository;

//  @Autowired
//  ModelMapper modelMapper;

//  @Autowired
//  SecurityService securityService;

  public Post savePost(User user, String content) {
    Post post = new Post();
    user = userRepository.findByUsername(user.getUsername());
    post.setUser(user);
    post.setContent(content);
    return postRepository.save(post);
  }

  public List<Post> getPostsOfUser(long id) {
    List<Post> postList = postRepository.findPostByUserOrderById(userRepository.findById(id));
//    List<PostDto> postDtoList= new ArrayList<>();
//    for (Post post :postList) {
//      postDtoList.add(modelMapper.map(post,PostDto.class));
//    }
    return postList;
  }

  public List<Post> getAllPosts() {
    return postRepository.findAllByOrderByIdDesc();
  }

  public void deletePost(long id) {
    postRepository.deleteById(id);
  }

}

//@Service
//public class PostService {
//
//  @Autowired
//  private PostRepository postRepository;
//
//  public List<Post> getAllPosts(){
//    return postRepository.findAll();
//  }
//
//  public Post getPostById(Long id){
//    return postRepository.findById(id).orElseThrow();
//  }
//
//  public Post getPostByTitle(String title){
//    return postRepository.findByTitle(title);
//  }
//
//  public void savePost(Post post){
//    postRepository.save(post);
//  }
//
//  public void deletePost(long id) {
//    postRepository.deleteById(id);
//  }
//}
