package data.user.create.response.forbidden.require;

public class CreateUserResponseForbiddenRequireData {

    private Boolean success;
    private String message;

    public CreateUserResponseForbiddenRequireData(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public CreateUserResponseForbiddenRequireData() {
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
