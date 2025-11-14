package data.user.create.response.forbidden.require;

import common.data.CommonServerMessageData;

public class CreateUserResponseForbiddenRequireData extends CommonServerMessageData {

    public CreateUserResponseForbiddenRequireData(Boolean success, String message) {
        super(success, message);
    }

}
