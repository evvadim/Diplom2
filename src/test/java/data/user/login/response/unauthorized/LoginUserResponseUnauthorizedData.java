package data.user.login.response.unauthorized;

import common.data.CommonServerMessageData;

public class LoginUserResponseUnauthorizedData extends CommonServerMessageData {

    public LoginUserResponseUnauthorizedData(Boolean success, String message) {
        super(success, message);
    }

}
