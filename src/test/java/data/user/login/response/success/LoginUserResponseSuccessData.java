package data.user.login.response.success;

import data.user.common.CommonUserDataFields;
import data.user.common.elements.OwnerData;

public class LoginUserResponseSuccessData extends CommonUserDataFields {

    public LoginUserResponseSuccessData(Boolean success, OwnerData user, String accessToken, String refreshToken) {
        super(success, user, accessToken, refreshToken);
    }

}
