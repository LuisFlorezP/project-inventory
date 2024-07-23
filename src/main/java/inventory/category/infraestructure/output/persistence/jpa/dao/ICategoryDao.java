package inventory.category.infraestructure.output.persistence.jpa.dao;

import inventory.category.infraestructure.output.persistence.jpa.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryDao extends CrudRepository<CategoryEntity, Long> {
}
