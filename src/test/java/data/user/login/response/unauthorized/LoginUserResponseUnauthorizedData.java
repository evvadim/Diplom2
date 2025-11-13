package data.user.login.response.unauthorized;

import data.user.common.CommonServerMessage;

public class LoginUserResponseUnauthorizedData extends CommonServerMessage {

    public LoginUserResponseUnauthorizedData(Boolean success, String message) {
        super(success, message);
    }

}
