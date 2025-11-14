package data.order.response.badrequest;

public class CreateOrderResponseBadRequestData {

    private Boolean success;
    private String message;

    public CreateOrderResponseBadRequestData(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public CreateOrderResponseBadRequestData() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
