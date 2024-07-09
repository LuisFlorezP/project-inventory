package inventory.category.domain.port.api;

import inventory.category.domain.model.Category;
import java.util.List;

public interface ICategoryService {

    List<Category> getCategories();

    Category getCategoryById(Long id);

    Category saveCategory(Category category);

    Category updateCategory(Category category, Long id);
}
