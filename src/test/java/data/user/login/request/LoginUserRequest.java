package data.user.login.request;

import common.http.FetchResponse;
import config.endpoints.Endpoints;
import data.user.login.LoginUser;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

import static common.http.CheckAndExtractResponseDataAsClass.checkResponseSpecs;
import static io.restassured.RestAssured.given;

public class LoginUserRequest extends FetchResponse {

    private final LoginUser loginUser;

    public LoginUserRequest(LoginUser loginUser) {
        this.loginUser = loginUser;
    }

    @Step("Login User POST Request")
    protected Response requestAndCheckResponseSpec(ResponseSpecification specification) {

        Response response = given()
                .spec(CommonLoginUserRequest.requestSpecification)
                .body(loginUser)
                .post(Endpoints.LOGIN_USER);

        if (specification != null) {
            checkResponseSpecs(response, specification);
        }

        return response;

    }

}
