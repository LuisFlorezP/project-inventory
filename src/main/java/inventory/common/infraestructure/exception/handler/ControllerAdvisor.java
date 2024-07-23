package inventory.common.infraestructure.exception.handler;

import inventory.category.application.handler.impl.CategoryHandler;
import inventory.common.application.dto.response.BaseRs;
import inventory.common.infraestructure.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import static inventory.common.application.utils.Constants.LOG_ERROR;
import static inventory.common.application.utils.Constants.RQ_UUID;


@ControllerAdvice
public class ControllerAdvisor {

    private final Logger log = Logger.getLogger(String.valueOf(CategoryHandler.class));

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ExceptionRs> handlerException(Exception e) {
        String message = LOG_ERROR + "Exception: " + e.getClass().getName() + ". Message: " + e.getMessage();
        log.log(Level.WARNING, message);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ExceptionRs(new BaseRs(System.getProperty(RQ_UUID), HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage())));
    }

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<ExceptionRs> handlerBusinessException(BusinessException e) {
        String message = LOG_ERROR + e.getMessage();
        log.log(Level.WARNING, message);

        return ResponseEntity.status(e.getStatus())
                .body(new ExceptionRs(new BaseRs(e.getRqUid(), e.getStatus().value(), e.getStatus().getReasonPhrase(), e.getMessage())));
    }

    @ExceptionHandler(value = MissingRequestHeaderException.class)
    public ResponseEntity<ExceptionRs> handlerMissingRequestHeaderException(MissingRequestHeaderException e) {
        String message = LOG_ERROR + e.getMessage();
        log.log(Level.WARNING, message);

        HttpStatus status = HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status)
                .body(new ExceptionRs(new BaseRs(System.getProperty(RQ_UUID), status.value(), status.getReasonPhrase(), e.getMessage())));
    }
}
