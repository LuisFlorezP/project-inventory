package inventory.category.infraestructure.output.persistence.jpa.mapper;

import inventory.category.domain.model.Category;
import inventory.category.infraestructure.output.persistence.jpa.entity.CategoryEntity;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICategoryEntityMapper {

    @Mapping(source = "categoryId", target = "id")
    Category toModel(CategoryEntity categoryEntity);

    List<Category> toModels(List<CategoryEntity> categoryEntityList);

    @Mapping(source = "id", target = "categoryId")
    CategoryEntity toEntity(Category category);
}
