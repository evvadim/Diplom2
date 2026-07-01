package data.user.create.response.success;

import data.user.common.CommonUserDataFields;
import data.user.common.elements.OwnerData;

public class CreateUserResponseSuccessData extends CommonUserDataFields {

    public CreateUserResponseSuccessData(Boolean success, OwnerData user, String accessToken, String refreshToken) {
        super(success, user, accessToken, refreshToken);
    }

}
