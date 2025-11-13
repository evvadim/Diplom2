package tests;

import data.user.User;
import data.user.create.request.CreateUserData;
import data.user.create.request.CreateUserRequest;
import data.user.create.response.CreateUserResponseSuccess;
import org.junit.Test;

import static config.Config.*;

public class CreateUserTests {

    CreateUserData createUserData = new CreateUserData(getEmail(), getUserPassword(), getUserName());
    User user = new User(createUserData);

    @Test
    public void createUserExpectedTrue() {
        new CreateUserRequest(user.getCreateUserData()).createUserRequest(CreateUserResponseSuccess.RESPONSE_SPEC);
    }

}
