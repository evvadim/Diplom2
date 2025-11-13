package data.user.login.response.request;

import config.endpoints.Endpoints;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

import static data.user.common.ACommonRequest.checkResponseSpecs;
import static io.restassured.RestAssured.given;

public class LoginUserRequest {

    private final LoginUserData loginUserData;

    public LoginUserRequest(LoginUserData loginUserData) {
        this.loginUserData = loginUserData;
    }

    @Step("Login User POST Request")
    private Response loginUserRequestAndCheckResponseSpec(ResponseSpecification specification) {

        Response response = given()
                .spec(CommonLoginUserRequest.requestSpecification)
                .body(loginUserData)
                .post(Endpoints.LOGIN_USER);

        if (specification != null) {
            checkResponseSpecs(response, specification);
        }

        return response;

    }

    public Response loginUserRequest() {
        return loginUserRequestAndCheckResponseSpec(null);
    }

    public Response loginUserRequest(ResponseSpecification specification) {
        return loginUserRequestAndCheckResponseSpec(specification);
    }

}
