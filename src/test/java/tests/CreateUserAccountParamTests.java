package tests;

import data.user.create.request.CreateUserData;
import data.user.create.request.CreateUserRequest;
import data.user.create.response.forbidden.require.CreateUserResponseForbiddenRequire;
import data.user.create.response.success.CreateUserResponseSuccess;
import data.user.create.response.success.CreateUserResponseSuccessData;
import data.user.delete.request.DeleteUserRequest;
import data.user.delete.response.DeleteUserResponseSuccess;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static config.Config.*;

@RunWith(Parameterized.class)
public class CreateUserAccountParamTests {

    CreateUserData createUserWithValidData = new CreateUserData(getEmail(), getUserPassword(), getUserName());
    CreateUserResponseSuccessData createUserResponseSuccessData;

    // параметры
    private final CreateUserData createUserData;
    private final Boolean isUserShouldBeCreated;

    public CreateUserAccountParamTests(String email, String password, String name, Boolean isUserShouldBeCreated) {
        this.createUserData = new CreateUserData(email, password, name);
        this.isUserShouldBeCreated = isUserShouldBeCreated;
    }

    @Parameterized.Parameters(name = "Testing Data for Create User Endpoint without one of required fields. Set {index}.")
    public static Object[][] getCredentials() {
        return new Object[][] {
                {null, getUserPassword(), getUserName(), false},
                {getEmail(), null, getUserName(), false},
                {getEmail(), getUserPassword(), null, false},
        };
    }

    @Before
    public void setUp() {

        // проверяем возможность создать пользователя
        CreateUserRequest createUserRequestValid = new CreateUserRequest(createUserWithValidData);
        CreateUserResponseSuccessData createUserResponseSuccessDataValid = createUserRequestValid.createUserRequest(CreateUserResponseSuccess.RESPONSE_SPEC);

        // удаляем этого пользователя
        new DeleteUserRequest(createUserResponseSuccessDataValid.getAccessToken()).deleteUserRequest(DeleteUserResponseSuccess.RESPONSE_SPEC);

    }

    @Test
    @DisplayName("Create User Test without required fields")
    public void createUserExpectedTrue() {

        CreateUserRequest createUserRequest = new CreateUserRequest(createUserData);
        if (isUserShouldBeCreated) {
            createUserResponseSuccessData = createUserRequest.createUserRequest(CreateUserResponseSuccess.RESPONSE_SPEC);
        } else {
            createUserRequest.createUserRequest(CreateUserResponseForbiddenRequire.RESPONSE_SPEC);
        }

    }

    @After
    public void tearDown() {
        if (isUserShouldBeCreated) {
            new DeleteUserRequest(createUserResponseSuccessData.getAccessToken()).deleteUserRequest(DeleteUserResponseSuccess.RESPONSE_SPEC);
        }
    }

}
