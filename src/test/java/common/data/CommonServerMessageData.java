package common.data;

public class CommonServerMessageData {

    private Boolean success;
    private String message;

    public CommonServerMessageData(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public CommonServerMessageData() {
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
