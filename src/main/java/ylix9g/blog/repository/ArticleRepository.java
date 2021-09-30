package ylix9g.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ylix9g.blog.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {

  //
}
