package ylix9g.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ylix9g.blog.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

  boolean existsByLogin(String login);

  boolean existsByEmail(String email);

  Optional<User> findByLogin(String login);
}
