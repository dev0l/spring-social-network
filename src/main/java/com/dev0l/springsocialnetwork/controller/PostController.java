package com.dev0l.springsocialnetwork.controller;

import com.dev0l.springsocialnetwork.entity.Post;
import com.dev0l.springsocialnetwork.entity.User;
import com.dev0l.springsocialnetwork.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PostController {

  @Autowired
  private PostService postService;

//  @GetMapping("/blog")
//  public String postView(@ModelAttribute("post") Post post) { return "blog"; }

  @GetMapping("/blog")
  public ModelAndView postView(@ModelAttribute("post") Post post) {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("blog");
    List<Post> posts = postService.getAllPosts();
    mv.addObject("posts", posts);
    return mv;
  }

  @PostMapping("/savePost")
  public String savePost(@ModelAttribute("post") Post post){
    postService.savePost(post);
    return "redirect:/blog";
  }
}
