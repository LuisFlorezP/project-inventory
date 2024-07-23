package inventory.common.infraestructure.exception.handler;

import inventory.common.application.dto.response.BaseRs;

public class ExceptionRs {

    private BaseRs status;

    public ExceptionRs(BaseRs status) {
        this.status = status;
    }

    public BaseRs getStatus() {
        return status;
    }
}
