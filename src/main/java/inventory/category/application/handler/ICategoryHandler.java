package inventory.category.application.handler;

import inventory.category.application.dto.response.ListCategoryRs;

public interface ICategoryHandler {

    ListCategoryRs getCategories();
}
