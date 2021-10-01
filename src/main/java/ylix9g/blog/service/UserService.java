package ylix9g.blog.service;

import org.springframework.stereotype.Service;
import ylix9g.blog.entity.Role;
import ylix9g.blog.entity.User;
import ylix9g.blog.exception.RoleNotFoundException;
import ylix9g.blog.repository.RoleRepository;
import ylix9g.blog.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

  private final RoleRepository roleRepository;

  private final UserRepository userRepository;

  public UserService(RoleRepository roleRepository, UserRepository userRepository) {
    this.roleRepository = roleRepository;
    this.userRepository = userRepository;
  }

  public void save(User user) throws RoleNotFoundException {
    Optional<Role> role = roleRepository.findByServiceName("user");
    user.setRole(role.orElseThrow(() -> new RoleNotFoundException("Role not found")));
    userRepository.save(user);
  }
}
