package inventory.category.application.handler.impl;

import inventory.category.application.dto.request.CategoryRq;
import inventory.category.application.dto.response.SingleCategoryRs;
import inventory.category.application.dto.response.CategoryRs;
import inventory.category.application.dto.response.ListCategoryRs;
import inventory.category.application.handler.ICategoryHandler;
import inventory.category.application.mapper.ICategoryMapper;
import inventory.category.domain.port.api.ICategoryService;
import inventory.common.application.dto.response.BaseRs;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static inventory.common.application.utils.Constants.*;

@Service
@Transactional
public class CategoryHandler implements ICategoryHandler {

    private final Logger logger = Logger.getLogger(String.valueOf(CategoryHandler.class));
    private final ICategoryService categoryService;
    private final ICategoryMapper categoryMapper;

    public CategoryHandler(ICategoryService categoryService, ICategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public ListCategoryRs getCategories() {
        logger.log(Level.INFO, LOG_START_HANDLER + "getCategories");

        BaseRs baseRs = new BaseRs(System.getProperty(RQ_UUID), HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), SUCCESS_CATEGORY_MESSAGE);

        List<CategoryRs> categories = categoryMapper.toResponses(categoryService.getCategories());
        ListCategoryRs response = new ListCategoryRs(baseRs, categories);

        logger.log(Level.INFO, LOG_END_HANDLER + "getCategories");
        return response;
    }

    @Override
    public SingleCategoryRs getCategoryById(Long id) {
        logger.log(Level.INFO, LOG_START_HANDLER + "getCategoryById");

        BaseRs baseRs = new BaseRs(System.getProperty(RQ_UUID), HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), SUCCESS_CATEGORY_MESSAGE);

        CategoryRs category = categoryMapper.toResponse(categoryService.getCategoryById(id));
        SingleCategoryRs response = new SingleCategoryRs(baseRs, category);

        logger.log(Level.INFO, LOG_END_HANDLER + "getCategoryById");
        return response;
    }

    @Override
    public SingleCategoryRs saveCategory(CategoryRq categoryRq) {
        logger.log(Level.INFO, LOG_START_HANDLER + "saveCategory");

        BaseRs baseRs = new BaseRs(System.getProperty(RQ_UUID), HttpStatus.CREATED.value(), HttpStatus.CREATED.getReasonPhrase(), SUCCESS_CATEGORY_MESSAGE);

        CategoryRs category = categoryMapper.toResponse(categoryService.saveCategory(categoryMapper.toModel(categoryRq)));
        SingleCategoryRs response = new SingleCategoryRs(baseRs, category);

        logger.log(Level.INFO, LOG_END_HANDLER + "saveCategory");
        return response;
    }
}
