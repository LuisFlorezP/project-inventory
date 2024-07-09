package inventory.category.application.mapper;

import inventory.category.application.dto.response.CategoryRs;
import inventory.category.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICategoryMapper {

    CategoryRs toResponse(Category category);

    List<CategoryRs> toResponses(List<Category> category);
}
