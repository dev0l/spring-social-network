package com.dev0l.springsocialnetwork.controller;

import com.dev0l.springsocialnetwork.entity.Post;
import com.dev0l.springsocialnetwork.entity.User;
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

  /******************** Start ********************/

  @GetMapping("/")
  public String welcome() {
    return "index";
  }

  /******************** Sign In ********************/

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

  @GetMapping("/authError")
  public String authError(Model model) {
    model.addAttribute("msg", "Sign In Failed");
    return "signin";
  }

  /******************** Sign Up ********************/

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

  /******************** Profile ********************/

  @GetMapping("/profile/{id}")
  public ModelAndView showProfile(@ModelAttribute("post") Post post,
                                  @PathVariable long id) {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("profile");
//    List<Post> posts = postService.getAllPosts();
//    mv.addObject("posts", posts);
    User userToShow = userService.findUserById(id);
    mv.addObject(userToShow);
    return mv;
  }

  /******************** Admin/Edit ********************/

  @GetMapping("/admin")
  public ModelAndView adminDashboard() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("admin");
    List<User> users = userService.getAllUsers();
    mv.addObject("users", users);
    return mv;
  }

  @GetMapping("/edit/{id}")
  public ModelAndView updateUser(@PathVariable long id) {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("edit");
    User userToUpdate = userService.findUserById(id);
    mv.addObject(userToUpdate);
    return mv;
  }

  @PostMapping("/update-user")
  public String updateUser(@ModelAttribute User user) {
    userService.updateUser(user);
//    return "redirect:/admin";
    return "redirect:/profile";
  }

  @GetMapping("/delete/{id}")
  public String deleteUser(@PathVariable long id) {
    userService.deleteUser(id);
//    return "redirect:/admin";
    return "redirect:/";
  }

}
