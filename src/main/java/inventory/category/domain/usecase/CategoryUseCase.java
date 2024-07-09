package inventory.category.domain.usecase;

import inventory.category.domain.model.Category;
import inventory.category.domain.port.api.ICategoryService;
import inventory.category.domain.port.spi.ICategoryPersistence;
import inventory.common.infraestructure.exception.OccupiedSpaceException;
import java.util.List;
import static inventory.common.application.utils.Constants.RQ_UUID;

public class CategoryUseCase implements ICategoryService {

    private final ICategoryPersistence categoryPersistence;

    public CategoryUseCase(ICategoryPersistence categoryPersistence) {
        this.categoryPersistence = categoryPersistence;
    }

    @Override
    public List<Category> getCategories() {
        String rqUuid = System.getProperty(RQ_UUID);

        if (rqUuid.equals("123")) throw new OccupiedSpaceException();

        return categoryPersistence.getCategories();
    }
}
