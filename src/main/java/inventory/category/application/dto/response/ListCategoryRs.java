package inventory.category.application.dto.response;

import inventory.common.application.dto.response.BaseRs;
import java.util.List;

public class ListCategoryRs {

    private BaseRs status;
    private List<CategoryRs> categories;

    public ListCategoryRs() {
    }

    public ListCategoryRs(BaseRs status, List<CategoryRs> categories) {
        this.status = status;
        this.categories = categories;
    }

    public BaseRs getStatus() {
        return status;
    }

    public void setStatus(BaseRs status) {
        this.status = status;
    }

    public List<CategoryRs> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryRs> categories) {
        this.categories = categories;
    }
}
