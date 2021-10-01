package ylix9g.blog.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ylix9g.blog.entity.User;
import ylix9g.blog.repository.UserRepository;

@Component
public class UserValidator implements Validator {

  private final UserRepository userRepository;

  public UserValidator(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public boolean supports(Class<?> clazz) {
    return User.class.isAssignableFrom(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    User user = (User) target;
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "validation.user.login.empty");
    if (!errors.hasFieldErrors("login") && !user.getLogin().matches("^[a-zA-Z_]\\w{4,}$")) {
      errors.rejectValue("login", "validation.user.login.format");
    } else if (userRepository.existsByLogin(user.getLogin())) {
      errors.rejectValue("login", "validation.user.login.exists");
    }
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "validation.user.password.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "validation.user.firstName.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "validation.user.lastName.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "validation.user.email.empty");
    if (!errors.hasFieldErrors("email") && userRepository.existsByEmail(user.getEmail())) {
      errors.rejectValue("email", "validation.user.email.exists");
    }
  }
}
