package inventory.common.infraestructure.exception;

import org.springframework.http.HttpStatus;
import static inventory.common.application.utils.Constants.EQUAL_CATEGORY;
import static inventory.common.application.utils.Constants.RQ_UUID;

public class EqualCategoryException extends BusinessException{

    public EqualCategoryException() {
        super(EQUAL_CATEGORY, HttpStatus.BAD_REQUEST, System.getProperty(RQ_UUID));
    }
}
