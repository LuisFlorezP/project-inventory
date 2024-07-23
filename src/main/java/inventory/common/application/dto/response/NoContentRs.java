package inventory.common.application.dto.response;

public class NoContentRs {

    private BaseRs status;

    public NoContentRs() {
    }

    public NoContentRs(BaseRs status) {
        this.status = status;
    }

    public BaseRs getStatus() {
        return status;
    }

    public void setStatus(BaseRs status) {
        this.status = status;
    }
}
