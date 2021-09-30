package ylix9g.blog.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "categories")
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToMany(mappedBy = "category")
  private List<Article> articles;

  private Integer order;

  private String name;

  @Column(name = "created_at")
  private LocalDateTime createdAt;
}
