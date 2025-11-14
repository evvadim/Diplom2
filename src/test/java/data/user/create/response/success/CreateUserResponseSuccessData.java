package data.user.create.response.success;

import data.user.common.CommonUserDataFields;
import data.user.common.elements.UserPublicData;

public class CreateUserResponseSuccessData extends CommonUserDataFields {

    public CreateUserResponseSuccessData(Boolean success, UserPublicData user, String accessToken, String refreshToken) {
        super(success, user, accessToken, refreshToken);
    }

}
