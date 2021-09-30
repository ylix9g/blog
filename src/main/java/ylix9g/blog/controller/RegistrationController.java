package ylix9g.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ylix9g.blog.entity.User;

@Controller
@RequestMapping(path = "/registration")
public class RegistrationController {

  @GetMapping
  public String showRegistrationPage(Model model) {
    model.addAttribute("user", new User());
    return "public/registration_page";
  }

  @PostMapping
  public String performRegistration() {
    return null;
  }
}
