package common.http;

import data.user.create.response.success.CreateUserResponseSuccessData;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.CoreMatchers.equalTo;

public class ResponseSuccessSpecs {

    private static final Integer EXPECTED_CODE = 200;
    private static final String EXPECTED_STATUS_LINE = "HTTP/1.1 " + EXPECTED_CODE + " OK";
    private static final Boolean EXPECTED_SUCCESS = true;
    private static final CreateUserResponseSuccessData SUCCESS_DATA = new CreateUserResponseSuccessData(EXPECTED_SUCCESS, null, null, null);

    public static final ResponseSpecification RESPONSE_SPEC = new ResponseSpecBuilder()
            .expectStatusCode(EXPECTED_CODE)
            .expectStatusLine(EXPECTED_STATUS_LINE)
            .expectBody("success", equalTo(SUCCESS_DATA.getSuccess()))
            .build();

}
