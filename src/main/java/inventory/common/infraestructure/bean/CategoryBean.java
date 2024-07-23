package inventory.common.infraestructure.bean;

import inventory.category.domain.port.api.ICategoryService;
import inventory.category.domain.port.spi.ICategoryPersistence;
import inventory.category.domain.usecase.CategoryUseCase;
import inventory.category.infraestructure.output.persistence.jpa.adapter.CategoryAdapter;
import inventory.category.infraestructure.output.persistence.jpa.dao.ICategoryDao;
import inventory.category.infraestructure.output.persistence.jpa.mapper.ICategoryEntityMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryBean {

    private final ICategoryDao categoryDao;
    private final ICategoryEntityMapper categoryEntityMapper;

    public CategoryBean(ICategoryDao categoryDao, ICategoryEntityMapper categoryEntityMapper) {
        this.categoryDao = categoryDao;
        this.categoryEntityMapper = categoryEntityMapper;
    }

    @Bean
    public ICategoryPersistence categoryPersistence() {
        return new CategoryAdapter(categoryDao, categoryEntityMapper);
    }

    @Bean
    public ICategoryService categoryService() {
        return new CategoryUseCase(categoryPersistence());
    }
}
