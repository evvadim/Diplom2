package data.user.create.response.forbidden.exist;

import common.data.CommonServerMessageData;

public class CreateUserResponseForbiddenExistData extends CommonServerMessageData {

    public CreateUserResponseForbiddenExistData(Boolean success, String message) {
        super(success, message);
    }

}
