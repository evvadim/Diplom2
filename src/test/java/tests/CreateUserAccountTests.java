package tests;

import data.user.UserAccount;
import data.user.create.request.CreateUserData;
import data.user.create.request.CreateUserRequest;
import data.user.create.response.CreateUserResponseSuccess;
import org.junit.Test;

import static config.Config.*;

public class CreateUserAccountTests {

    CreateUserData createUserData = new CreateUserData(getEmail(), getUserPassword(), getUserName());
    UserAccount userAccount = new UserAccount(createUserData);

    @Test
    public void createUserExpectedTrue() {
        new CreateUserRequest(userAccount.getCreateUserData()).createUserRequest(CreateUserResponseSuccess.RESPONSE_SPEC);
    }

}
