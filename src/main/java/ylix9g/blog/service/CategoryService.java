package ylix9g.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ylix9g.blog.entity.Category;
import ylix9g.blog.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

  private final CategoryRepository categoryRepository;

  public CategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public List<Category> findAllSortedByOrder() {
    Sort sort = Sort.by(Sort.Order.asc("order"));
    return categoryRepository.findAll(sort);
  }
}
