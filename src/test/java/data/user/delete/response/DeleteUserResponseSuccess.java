package data.user.delete.response;

import com.google.gson.Gson;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.CoreMatchers.equalTo;

public class DeleteUserResponseSuccess {

    private static final Integer EXPECTED_CODE = 202;
    private static final String EXPECTED_STATUS_LINE = "HTTP/1.1 " + EXPECTED_CODE + " Accepted";
    private static final Boolean EXPECTED_SUCCESS = true;
    private static final String EXPECTED_MESSAGE = "User successfully removed";
    private static final DeleteUserResponseSuccessData SUCCESS_DATA = new DeleteUserResponseSuccessData(EXPECTED_SUCCESS, EXPECTED_MESSAGE);

    public static final ResponseSpecification RESPONSE_SPEC = new ResponseSpecBuilder()
            .expectStatusCode(EXPECTED_CODE)
            .expectStatusLine(EXPECTED_STATUS_LINE)
            .expectBody(equalTo(new Gson().toJson(SUCCESS_DATA)))
            .build();

}
