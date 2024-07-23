package inventory.category.application.handler;

import inventory.category.application.dto.request.CategoryRq;
import inventory.category.application.dto.response.SingleCategoryRs;
import inventory.category.application.dto.response.ListCategoryRs;
import inventory.common.application.dto.response.NoContentRs;

public interface ICategoryHandler {

    ListCategoryRs getCategories();

    SingleCategoryRs getCategoryById(Long id);

    SingleCategoryRs saveCategory(CategoryRq categoryRq);

    SingleCategoryRs updateCategory(CategoryRq categoryRq, Long id);

    NoContentRs deleteCategory(Long id);
}
