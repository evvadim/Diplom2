package data.user.create.response.forbidden.exist;

import data.user.common.CommonServerMessage;

public class CreateUserResponseForbiddenExistData extends CommonServerMessage {

    public CreateUserResponseForbiddenExistData(Boolean success, String message) {
        super(success, message);
    }

}
