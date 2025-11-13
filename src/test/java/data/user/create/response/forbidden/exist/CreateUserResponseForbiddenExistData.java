package data.user.create.response.forbidden.exist;

public class CreateUserResponseForbiddenExistData {

    private Boolean success;
    private String message;

    public CreateUserResponseForbiddenExistData(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public CreateUserResponseForbiddenExistData() {
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
