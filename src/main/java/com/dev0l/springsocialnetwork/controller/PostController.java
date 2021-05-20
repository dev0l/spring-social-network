package com.dev0l.springsocialnetwork.controller;

import com.dev0l.springsocialnetwork.entity.Post;
import com.dev0l.springsocialnetwork.entity.User;
import com.dev0l.springsocialnetwork.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PostController {

  @Autowired
  private PostService postService;

  @GetMapping("/posts")
  public ModelAndView allPosts(@ModelAttribute("post") Post post) {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("posts");
    List<Post> posts = postService.getAllPosts();
    mv.addObject("posts", posts);
    return mv;
  }

  @GetMapping("/posts/{id}")
  public ModelAndView getPostofUser(@PathVariable long id) {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("posts");
    List<Post> postList = postService.getPostsOfUser(id);
    mv.addObject(postList);
    return mv;
  }

  @PostMapping("/addpost")
  public ModelAndView savePost(@ModelAttribute Post post, User user) {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("profile");
    Post savedPost = postService.savePost(user, post.getContent());
    mv.addObject(savedPost);
    return mv;
  }

  @GetMapping("/delete-post/{id}")
  public String deletePost(@PathVariable long id) {
    postService.deletePost(id);
    return "redirect:/posts";
  }

}
