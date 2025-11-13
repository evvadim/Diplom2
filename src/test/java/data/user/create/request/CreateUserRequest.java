package data.user.create.request;

import config.endpoints.Endpoints;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

import static data.user.create.request.CommonCreateUserRequest.checkResponseSpecs;
import static io.restassured.RestAssured.given;

public class CreateUserRequest {

    private final CreateUserData createUserData;

    public CreateUserRequest(CreateUserData createUserData) {
        this.createUserData = createUserData;
    }

    @Step("Create User POST Request")
    private Response createUserRequestAndCheckResponseSpec(ResponseSpecification specification) {

        Response response = given()
                .spec(CommonCreateUserRequest.requestSpecification)
                .body(createUserData)
                .post(Endpoints.CREATE_USER);

        if (specification != null) {
            checkResponseSpecs(response, specification);
        }

        return response;

    }

    public Response createUserRequest() {
        return createUserRequestAndCheckResponseSpec(null);
    }

    public Response createUserRequest(ResponseSpecification specification) {
        return createUserRequestAndCheckResponseSpec(specification);
    }

}
