package data.user.login.response.success;

import data.user.common.CommonUserDataFields;
import data.user.common.elements.ElementUser;

public class LoginUserResponseSuccessData extends CommonUserDataFields {

    public LoginUserResponseSuccessData(Boolean success, ElementUser user, String accessToken, String refreshToken) {
        super(success, user, accessToken, refreshToken);
    }

}
