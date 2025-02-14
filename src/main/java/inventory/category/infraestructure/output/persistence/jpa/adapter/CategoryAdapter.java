package inventory.category.infraestructure.output.persistence.jpa.adapter;

import inventory.category.domain.model.Category;
import inventory.category.domain.port.spi.ICategoryPersistence;
import inventory.category.infraestructure.output.persistence.jpa.entity.CategoryEntity;
import inventory.category.infraestructure.output.persistence.jpa.dao.ICategoryDao;
import inventory.category.infraestructure.output.persistence.jpa.mapper.ICategoryEntityMapper;
import java.util.List;

public class CategoryAdapter implements ICategoryPersistence {

    private final ICategoryDao categoryDao;
    private final ICategoryEntityMapper categoryEntityMapper;

    public CategoryAdapter(ICategoryDao categoryDao, ICategoryEntityMapper categoryEntityMapper) {
        this.categoryDao = categoryDao;
        this.categoryEntityMapper = categoryEntityMapper;
    }

    @Override
    public List<Category> getCategories() {
        return categoryEntityMapper.toModels((List<CategoryEntity>) categoryDao.findAll());
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryEntityMapper.toModel(categoryDao.findById(id).orElse(null));
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryEntityMapper.toModel(categoryDao.save(categoryEntityMapper.toEntity(category)));
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryDao.deleteById(id);
    }
}
