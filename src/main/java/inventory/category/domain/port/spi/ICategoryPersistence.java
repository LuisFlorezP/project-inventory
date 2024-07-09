package inventory.category.domain.port.spi;

import inventory.category.domain.model.Category;
import java.util.List;

public interface ICategoryPersistence {

    List<Category> getCategories();
}
