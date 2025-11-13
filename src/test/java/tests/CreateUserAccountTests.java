package tests;

import data.user.create.request.CreateUserData;
import data.user.create.request.CreateUserRequest;
import data.user.create.response.CreateUserResponseSuccess;
import data.user.create.response.CreateUserResponseSuccessData;
import data.user.delete.request.DeleteUserRequest;
import data.user.delete.response.DeleteUserResponseSuccess;
import org.junit.After;
import org.junit.Test;

import static config.Config.*;

public class CreateUserAccountTests {

    CreateUserData createUserData = new CreateUserData(getEmail(), getUserPassword(), getUserName());
    CreateUserResponseSuccessData createUserResponseSuccessData;

    @Test
    public void createUserExpectedTrue() {

        CreateUserRequest createUserRequest = new CreateUserRequest(createUserData);
        createUserResponseSuccessData = createUserRequest.createUserRequest(CreateUserResponseSuccess.RESPONSE_SPEC);

    }

    @After
    public void tearDown() {
        new DeleteUserRequest(createUserResponseSuccessData.getAccessToken()).deleteUserRequest(DeleteUserResponseSuccess.RESPONSE_SPEC);
    }

}
