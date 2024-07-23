package inventory.common.application.dto.response;

public class BaseRs {

    private String rqUuid;
    private Integer code;
    private String reasonPhrase;
    private String detail;

    public BaseRs(String rqUuid, Integer code, String reasonPhrase, String detail) {
        this.rqUuid = rqUuid;
        this.code = code;
        this.reasonPhrase = reasonPhrase;
        this.detail = detail;
    }

    public String getRqUuid() {
        return rqUuid;
    }

    public Integer getCode() {
        return code;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }

    public String getDetail() {
        return detail;
    }
}
