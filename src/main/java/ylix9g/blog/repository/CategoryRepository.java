package ylix9g.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ylix9g.blog.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

  //
}
