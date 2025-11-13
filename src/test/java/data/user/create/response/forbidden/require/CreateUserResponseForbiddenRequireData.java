package data.user.create.response.forbidden.require;

import data.user.common.CommonServerMessage;

public class CreateUserResponseForbiddenRequireData extends CommonServerMessage {

    public CreateUserResponseForbiddenRequireData(Boolean success, String message) {
        super(success, message);
    }

}
