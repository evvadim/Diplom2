package data.order.request;

import common.http.FetchResponse;
import config.endpoints.Endpoints;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

import static common.http.CheckAndExtractResponseDataAsClass.checkResponseSpecs;
import static io.restassured.RestAssured.given;

public class CreateOrderRequest extends FetchResponse {

    private final CreateOrderData createOrderData;
    private final String credential;

    public CreateOrderRequest(CreateOrderData createOrderData, String credential) {
        this.createOrderData = createOrderData;
        this.credential = credential;
    }

    @Step("Create Order POST Request")
    protected Response requestAndCheckResponseSpec(ResponseSpecification specification) {

        Response response = given()
                .spec(CommonCreateOrderRequest.requestSpecification)
                .body(createOrderData)
                .header("Authorization", credential)
                .post(Endpoints.CREATE_ORDER);

        if (specification != null) {
            checkResponseSpecs(response, specification);
        }

        return response;

    }

}
