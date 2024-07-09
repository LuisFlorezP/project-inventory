package inventory.category.application.handler;

import inventory.category.application.dto.response.ByIdCategoryRs;
import inventory.category.application.dto.response.ListCategoryRs;

public interface ICategoryHandler {

    ListCategoryRs getCategories();

    ByIdCategoryRs getCategoryById(Long id);
}
