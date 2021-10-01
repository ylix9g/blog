package ylix9g.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ylix9g.blog.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

  Optional<Role> findByServiceName(String serviceName);
}
