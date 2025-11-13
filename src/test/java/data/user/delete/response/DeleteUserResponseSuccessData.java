package data.user.delete.response;

public class DeleteUserResponseSuccessData {

    private Boolean success;
    private String message;

    public DeleteUserResponseSuccessData(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public DeleteUserResponseSuccessData() {
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
