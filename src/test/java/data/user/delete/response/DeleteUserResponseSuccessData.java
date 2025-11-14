package data.user.delete.response;

import common.data.CommonServerMessageData;

public class DeleteUserResponseSuccessData extends CommonServerMessageData {

    public DeleteUserResponseSuccessData(Boolean success, String message) {
        super(success, message);
    }

}
