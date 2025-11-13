package data.user.delete.request;

import config.endpoints.Endpoints;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

import static data.user.delete.request.CommonDeleteUserRequest.checkResponseSpecs;
import static io.restassured.RestAssured.given;

public class DeleteUserRequest {

    private final String accessToken;

    public DeleteUserRequest(String accessToken) {
        this.accessToken = accessToken;
    }

    @Step("Delete User DELETE Request")
    private void deleteUserRequestAndCheckResponseSpec(ResponseSpecification specification) {
        Response response = given()
                .spec(CommonDeleteUserRequest.requestSpecification)
                .auth().oauth2(accessToken.substring(7))
                .delete(Endpoints.DELETE_USER);

        if (specification != null) {
            checkResponseSpecs(response, specification);
        }

    }

    public void deleteUserRequest() {
        deleteUserRequestAndCheckResponseSpec(null);
    }

    public void deleteUserRequest(ResponseSpecification specification) {
        deleteUserRequestAndCheckResponseSpec(specification);
    }

}
