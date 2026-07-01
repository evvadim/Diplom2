package data.order.response.badrequest;

import com.google.gson.Gson;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.CoreMatchers.equalTo;

public class CreateOrderResponseBadRequest {

    private static final Integer EXPECTED_CODE = 400;
    private static final String EXPECTED_STATUS_LINE = "HTTP/1.1 " + EXPECTED_CODE + " Bad Request";
    private static final Boolean EXPECTED_SUCCESS = false;
    private static final String EXPECTED_MESSAGE = "Ingredient ids must be provided";
    private static final CreateOrderResponseBadRequestData SUCCESS_DATA = new CreateOrderResponseBadRequestData(EXPECTED_SUCCESS, EXPECTED_MESSAGE);

    public static final ResponseSpecification RESPONSE_SPEC = new ResponseSpecBuilder()
            .expectStatusCode(EXPECTED_CODE)
            .expectStatusLine(EXPECTED_STATUS_LINE)
            .expectBody(equalTo(new Gson().toJson(SUCCESS_DATA)))
            .build();

}
