package com.dev0l.springsocialnetwork.controller;

import com.dev0l.springsocialnetwork.entity.Post;
import com.dev0l.springsocialnetwork.entity.User;
import com.dev0l.springsocialnetwork.service.PostService;
import com.dev0l.springsocialnetwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

  @Autowired
  private UserService userService;
//  private PostService postService;

  /********** Start **********/

  @GetMapping("/")
  public String welcome() {
    return "index";
  }

  /********** Sign In **********/

  @GetMapping("/signin")
  public String signIn() { return "signin"; }

  @PostMapping("/authenticate-user")
  public String authUser(@RequestParam("username") String username,
                         @RequestParam("password") String password) {

    User user = userService.findUserByUsername(username);

    if (user != null && userService.authUser(username, password)) {
      Long id = user.getId();
      return "redirect:/profile/" + id;
    }
    return "redirect:/authError";
  }

  //Fail response from above method which displays
  //a message dynamically in the login form
  @GetMapping("/authError")
  public String authError(Model model) {
    model.addAttribute("msg", "Sign In Failed");
    return "signin";
  }

  /********** Sign Up **********/

  @GetMapping("/signup")
  public String signUp(@ModelAttribute("user") User user) { return "signup"; }

  @PostMapping("/save-user")
  public String saveUser(User user,
                         @RequestParam("password") String password,
                         @RequestParam("passwordConfirm") String passwordConfirm) {

    if (password.equals(passwordConfirm)) {
      user.setImg("https://via.placeholder.com/150");
      userService.saveUser(user);
      return "redirect:/success";
    }
    return "redirect:/failed";
  }

  @GetMapping("/success")
  public String success(@ModelAttribute("user") User user) {
    return "redirect:/signin";
  }

  @GetMapping("/failed")
  public String failed(@ModelAttribute("user") User user,
                       Model model) {
    model.addAttribute("msg", "Oops something went wrong!");
    return "signup";
  }

  /********** Profile **********/

  @GetMapping("/profile/{id}")
  public ModelAndView showProfile(@PathVariable long id) {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("profile");
    User userToShow = userService.findUserById(id);
    mv.addObject(userToShow);
    return mv;
  }

//  @GetMapping("/profile/{id}")
//  public ModelAndView showProfile(@PathVariable long id, @ModelAttribute("post") Post post) {
//    ModelAndView mv = new ModelAndView();
//    mv.setViewName("profile");
//    User userToShow = userService.findUserById(id);
//    mv.addObject(userToShow);
//    List<Post> posts = postService.getAllPosts();
//    mv.addObject("posts", posts);
//    return mv;
//  }

  /********** Admin/Edit **********/

  //Endpoint to handle view which shows a table with
  //all user entries in the database.
  @GetMapping("/admin")
  public ModelAndView adminDashboard() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("admin");
    List<User> users = userService.getAllUsers();
    mv.addObject("users", users);
    return mv;
  }

  //Endpoint for editing specific database entries
  //Their id field is used to query them from the database.
  @GetMapping("/edit/{id}")
  public ModelAndView updateUser(@PathVariable long id) {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("edit");
    User userToUpdate = userService.findUserById(id);
    mv.addObject(userToUpdate);
    return mv;
  }

  //Endpoint that handles updating a specific user
  @PostMapping("/update-user")
  public String updateUser(@ModelAttribute User user) {
    userService.updateUser(user);
//    return "redirect:/admin";
    return "redirect:/profile";
  }

  //Endpoint that handles deleting a specific user
  @GetMapping("/delete/{id}")
  public String deleteUser(@PathVariable long id) {
    userService.deleteUser(id);
//    return "redirect:/admin";
    return "redirect:/";
  }

}
