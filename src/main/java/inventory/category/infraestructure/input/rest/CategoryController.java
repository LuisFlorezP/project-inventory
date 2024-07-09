package inventory.category.infraestructure.input.rest;

import inventory.category.application.dto.request.CategoryRq;
import inventory.category.application.dto.response.SingleCategoryRs;
import inventory.category.application.dto.response.ListCategoryRs;
import inventory.category.application.handler.ICategoryHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static inventory.common.application.utils.Constants.RQ_UUID;

@RestController
@RequestMapping("/categories")
@Tag(name = "Category Controller", description = "Controller to the Category entity")
public class CategoryController {

    private final ICategoryHandler categoryHandler;

    public CategoryController(ICategoryHandler categoryHandler) {
        this.categoryHandler = categoryHandler;
    }

    @Operation(summary = "Allows you to see all categories")
    @GetMapping
    public ResponseEntity<ListCategoryRs> getCategories(@RequestHeader(name = "rqUuid") String rqUuid) {
        System.setProperty(RQ_UUID, rqUuid);
        ListCategoryRs response = categoryHandler.getCategories();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Allows you to see category")
    @GetMapping("/{id}")
    public ResponseEntity<SingleCategoryRs> getCategories(@RequestHeader(name = "rqUuid") String rqUuid, @PathVariable(name = "id") Long id) {
        System.setProperty(RQ_UUID, rqUuid);
        SingleCategoryRs response = categoryHandler.getCategoryById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Allows you to create new category")
    @PostMapping
    public ResponseEntity<SingleCategoryRs> saveCategory(@RequestHeader(name = "rqUuid") String rqUuid, @RequestBody CategoryRq categoryRq) {
        System.setProperty(RQ_UUID, rqUuid);
        SingleCategoryRs response = categoryHandler.saveCategory(categoryRq);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
