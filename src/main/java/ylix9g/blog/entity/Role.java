package ylix9g.blog.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "roles")
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToMany(mappedBy = "role")
  private List<User> users;

  @Column(name = "service_name")
  private String serviceName;

  @Column(name = "display_name")
  private String displayName;
}
