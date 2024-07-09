package inventory.category.application.dto.response;

import inventory.common.application.dto.response.BaseRs;

public class SingleCategoryRs {

    private BaseRs status;
    private CategoryRs category;

    public SingleCategoryRs() {
    }

    public SingleCategoryRs(BaseRs status, CategoryRs category) {
        this.status = status;
        this.category = category;
    }

    public BaseRs getStatus() {
        return status;
    }

    public void setStatus(BaseRs status) {
        this.status = status;
    }

    public CategoryRs getCategory() {
        return category;
    }

    public void setCategory(CategoryRs category) {
        this.category = category;
    }
}
