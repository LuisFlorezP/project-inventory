package inventory.category.application.dto.response;

import inventory.common.application.dto.response.BaseRs;

public class ByIdCategoryRs {

    private BaseRs status;
    private CategoryRs category;

    public ByIdCategoryRs() {
    }

    public ByIdCategoryRs(BaseRs status, CategoryRs category) {
        this.status = status;
        this.category = category;
    }

    public BaseRs getStatus() {
        return status;
    }

    public CategoryRs getCategory() {
        return category;
    }
}
