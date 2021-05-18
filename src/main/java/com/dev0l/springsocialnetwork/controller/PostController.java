package com.dev0l.springsocialnetwork.controller;

import com.dev0l.springsocialnetwork.entity.Post;
import com.dev0l.springsocialnetwork.entity.User;
import com.dev0l.springsocialnetwork.service.PostService;
import com.dev0l.springsocialnetwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PostController {

  @Autowired
  private PostService postService;
  private UserService userService;

//  @GetMapping("/blog")
//  public String postView(@ModelAttribute("post") Post post) { return "blog"; }

  @GetMapping("/blog")
  public ModelAndView allPosts(@ModelAttribute("post") Post post) {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("blog");
    List<Post> posts = postService.getAllPosts();
    mv.addObject("posts", posts);
    return mv;
  }

//  @GetMapping("/blog/{id}")
//  public ModelAndView userPost(@ModelAttribute("post") Post post,
//                               @RequestParam("username") String username) {
//    ModelAndView mv = new ModelAndView();
//    User user = userService.findUserByUsername(username);
//    Long id = user.getId();
//    mv.setViewName("user-blog");
//    List<Post> posts = postService.getAllPosts();
//    mv.addObject("posts", posts);
//    return mv;
//  }

//  @GetMapping("/profile/{id}/blog")
//  public String userPost(@PathVariable long id,
//                         @ModelAttribute("post") Post post,
//                         @RequestParam("username") String username) {
//    User user = userService.findUserById(id);
//    List<Post> posts = postService.getAllPosts();
//    return "redirect:/profile/" + id;
//  }

  @PostMapping("/savePost")
  public String savePost(@ModelAttribute("post") Post post){
    postService.savePost(post);
    return "redirect:/blog";
  }

  @GetMapping("/delete-post/{id}")
  public String deletePost(@PathVariable long id) {
    postService.deletePost(id);
    return "redirect:/blog";
  }
}
