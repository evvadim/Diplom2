package tests;

import data.user.create.request.CommonCreateUserRequest;
import data.user.create.request.CreateUserData;
import data.user.create.request.CreateUserRequest;
import data.user.create.response.success.CreateUserResponseSuccessData;
import data.user.delete.request.DeleteUserRequest;
import data.user.delete.response.DeleteUserResponseSuccess;
import data.user.login.request.CommonLoginUserRequest;
import data.user.login.request.LoginUserData;
import data.user.login.request.LoginUserRequest;
import data.user.login.response.success.LoginUserResponseSuccess;
import data.user.login.response.success.LoginUserResponseSuccessData;
import data.user.login.response.unauthorized.LoginUserResponseUnauthorized;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static config.Config.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

@RunWith(Parameterized.class)
public class LoginUserAccountParamTests {

    CreateUserData createUserData = new CreateUserData(getEmail(), getUserPassword(), getUserName());
    CreateUserResponseSuccessData createUserResponseSuccessData;
    LoginUserResponseSuccessData loginUserResponseSuccessData;

    // переменные для параметризации
    private final LoginUserData loginUserData;
    private final Boolean isShouldBeLoggedIn;

    public LoginUserAccountParamTests(String email, String password, Boolean isShouldBeLoggedIn) {
        this.loginUserData = new LoginUserData(email, password);
        this.isShouldBeLoggedIn = isShouldBeLoggedIn;
    }

    @Parameterized.Parameters(name = "Testing Data for Login User Endpoint without one of required fields. Set {index}.")
    public static Object[][] getCredentials() {
        return new Object[][] {
                {getEmail(), getUserPassword(), true},
                {getAnotherEmail(), getUserPassword(), false},
                {getEmail(), getAnotherUserPassword(), false},
                {null, getUserPassword(), false},
                {getEmail(), null, false},
        };
    }

    @Before
    public void setUp() {

        CreateUserRequest createUserRequest = new CreateUserRequest(createUserData);
        Response response = createUserRequest.fetchResponse();
        createUserResponseSuccessData = (CreateUserResponseSuccessData) CommonCreateUserRequest.extractResponseToObject(response, CreateUserResponseSuccessData.class);

    }

    @Test
    public void loginUserTest() {

        LoginUserRequest loginUserRequest = new LoginUserRequest(loginUserData);

        if (isShouldBeLoggedIn) {
            Response response = loginUserRequest.fetchResponse(LoginUserResponseSuccess.RESPONSE_SPEC);
            loginUserResponseSuccessData = (LoginUserResponseSuccessData) CommonLoginUserRequest.extractResponseToObject(response, LoginUserResponseSuccessData.class);
            assertThat(loginUserResponseSuccessData.getUser().getName(), equalTo(createUserResponseSuccessData.getUser().getName()));
        } else {
            loginUserRequest.fetchResponse(LoginUserResponseUnauthorized.RESPONSE_SPEC);
        }

    }

    @After
    public void tearDown() {
        new DeleteUserRequest(createUserResponseSuccessData.getAccessToken()).fetchResponse(DeleteUserResponseSuccess.RESPONSE_SPEC);
    }
}
