package data.user.create.response.success;

import data.user.common.CommonResponseSuccessData;
import data.user.common.elements.User;

public class CreateUserResponseSuccessData extends CommonResponseSuccessData {

    public CreateUserResponseSuccessData(Boolean success, User user, String accessToken, String refreshToken) {
        super(success, user, accessToken, refreshToken);
    }

}
