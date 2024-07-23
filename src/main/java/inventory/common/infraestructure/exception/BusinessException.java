package inventory.common.infraestructure.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException{

    private final HttpStatus status;
    private final String rqUid;

    public BusinessException(String message, HttpStatus status, String rqUid) {
        super(message);
        this.status = status;
        this.rqUid = rqUid;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getRqUid() {
        return rqUid;
    }
}
