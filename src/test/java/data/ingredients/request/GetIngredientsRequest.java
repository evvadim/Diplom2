package data.ingredients.request;

import common.http.FetchResponse;
import config.endpoints.Endpoints;
import data.user.create.request.CommonCreateUserRequest;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

import static common.http.CheckAndExtractResponseDataAsClass.checkResponseSpecs;
import static io.restassured.RestAssured.given;

public class GetIngredientsRequest extends FetchResponse {

    @Step("Get Ingredients GET Request")
    protected Response requestAndCheckResponseSpec(ResponseSpecification specification) {

        Response response = given()
                .spec(CommonCreateUserRequest.requestSpecification)
                .get(Endpoints.GET_INGREDIENTS);

        if (specification != null) {
            checkResponseSpecs(response, specification);
        }

        return response;

    }

}
