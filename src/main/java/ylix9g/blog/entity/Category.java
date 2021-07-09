package ylix9g.blog.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "categories")
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Integer order;

  private String name;

  @Column(name = "created_at")
  private LocalDateTime createdAt;
}
