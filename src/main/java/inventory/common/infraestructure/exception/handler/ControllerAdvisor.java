package inventory.common.infraestructure.exception.handler;

import inventory.common.application.dto.response.BaseRs;
import inventory.common.infraestructure.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import static inventory.common.application.utils.Constants.RQ_UUID;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ExceptionRs> handlerException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ExceptionRs(new BaseRs(System.getProperty(RQ_UUID), HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage())));
    }

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<ExceptionRs> handlerBusinessException(BusinessException e) {
        return ResponseEntity.status(e.getStatus())
                .body(new ExceptionRs(new BaseRs(e.getRqUid(), e.getStatus().value(), e.getStatus().getReasonPhrase(), e.getMessage())));
    }
}
