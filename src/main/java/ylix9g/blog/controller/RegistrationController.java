package ylix9g.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ylix9g.blog.entity.User;
import ylix9g.blog.exception.RoleNotFoundException;
import ylix9g.blog.service.UserService;
import ylix9g.blog.validator.UserValidator;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/registration")
public class RegistrationController {

  private final UserValidator userValidator;

  private final UserService userService;

  public RegistrationController(UserValidator userValidator, UserService userService) {
    this.userValidator = userValidator;
    this.userService = userService;
  }

  @InitBinder
  private void initBinder(WebDataBinder webDataBinder) {
    webDataBinder.addValidators(userValidator);
  }

  @GetMapping
  public String showRegistrationPage(Model model) {
    model.addAttribute("user", new User());
    return "public/registration_page";
  }

  @PostMapping
  public String performRegistration(@Valid @ModelAttribute User user, BindingResult bindingResult)
      throws RoleNotFoundException {
    if (bindingResult.hasErrors()) {
      return "public/registration_page";
    }
    userService.save(user);
    return "redirect:/";
  }
}
