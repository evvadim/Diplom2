package data.user.delete.response;

import data.user.common.CommonServerMessage;

public class DeleteUserResponseSuccessData extends CommonServerMessage {

    public DeleteUserResponseSuccessData(Boolean success, String message) {
        super(success, message);
    }

}
