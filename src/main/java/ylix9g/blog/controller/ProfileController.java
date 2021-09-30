package ylix9g.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/profile/{login}")
public class ProfileController {

  @GetMapping
  private String showProfilePage(@PathVariable String login) {
    return "public/profile_page";
  }
}
