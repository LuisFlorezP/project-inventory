package inventory.common.infraestructure.exception;

import org.springframework.http.HttpStatus;
import static inventory.common.application.utils.Constants.OCCUPIED_SPACE;

public class OccupiedSpaceException extends BusinessException{

    public OccupiedSpaceException() {
        super(OCCUPIED_SPACE, HttpStatus.BAD_REQUEST, System.getProperty("rqUid"));
    }
}
