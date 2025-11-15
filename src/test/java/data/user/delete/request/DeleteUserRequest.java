package data.user.delete.request;

import common.http.FetchResponse;
import config.endpoints.Endpoints;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

import static data.user.delete.request.CommonDeleteUserRequest.checkResponseSpecs;
import static io.restassured.RestAssured.given;

public class DeleteUserRequest extends FetchResponse {

    private final String accessToken;

    public DeleteUserRequest(String accessToken) {
        this.accessToken = accessToken;
    }

    @Step("Delete User DELETE Request")
    protected Response requestAndCheckResponseSpec(ResponseSpecification specification) {

        Response response = given()
                .spec(CommonDeleteUserRequest.requestSpecification)
                .header("Authorization", accessToken)
                .delete(Endpoints.DELETE_USER);

        if (specification != null) {
            checkResponseSpecs(response, specification);
        }

        return response;

    }

}
