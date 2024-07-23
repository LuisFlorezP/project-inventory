package inventory.common.infraestructure.exception;

import org.springframework.http.HttpStatus;
import static inventory.common.application.utils.Constants.NOT_FOUND_CATEGORY;
import static inventory.common.application.utils.Constants.RQ_UUID;

public class NotFoundCategoryException extends BusinessException{

    public NotFoundCategoryException() {
        super(NOT_FOUND_CATEGORY, HttpStatus.NOT_FOUND, System.getProperty(RQ_UUID));
    }
}
