package inventory.category.domain.usecase;

import inventory.category.domain.model.Category;
import inventory.category.domain.port.api.ICategoryService;
import inventory.category.domain.port.spi.ICategoryPersistence;
import inventory.common.infraestructure.exception.EqualCategoryException;
import inventory.common.infraestructure.exception.NotFoundCategoryException;
import java.util.List;

public class CategoryUseCase implements ICategoryService {

    private final ICategoryPersistence categoryPersistence;

    public CategoryUseCase(ICategoryPersistence categoryPersistence) {
        this.categoryPersistence = categoryPersistence;
    }

    @Override
    public List<Category> getCategories() {
        return categoryPersistence.getCategories();
    }

    @Override
    public Category getCategoryById(Long id) {
        Category categoryById = categoryPersistence.getCategoryById(id);

        if (categoryById == null) throw new NotFoundCategoryException();

        return categoryById;
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryPersistence.saveCategory(category);
    }

    @Override
    public Category updateCategory(Category category, Long id) {
        Category categoryById = this.getCategoryById(id);

        this.verifyEqualData(categoryById, category);

        return categoryPersistence.saveCategory(categoryById);
    }

    private void verifyEqualData(Category categoryDB, Category category) {
        if (categoryDB.getName().equals(category.getName()) && categoryDB.getDescription().equals(category.getDescription())) throw new EqualCategoryException();
        categoryDB.setName(category.getName());
        categoryDB.setDescription(category.getDescription());
    }
}
