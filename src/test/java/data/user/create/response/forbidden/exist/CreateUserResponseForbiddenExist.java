package data.user.create.response.forbidden.exist;

import com.google.gson.Gson;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.CoreMatchers.equalTo;

public class CreateUserResponseForbiddenExist {

    private static final Integer EXPECTED_CODE = 403;
    private static final String EXPECTED_STATUS_LINE = "HTTP/1.1 " + EXPECTED_CODE + " Forbidden";
    private static final Boolean EXPECTED_SUCCESS = false;
    private static final String EXPECTED_MESSAGE = "User already exists";
    private static final CreateUserResponseForbiddenExistData FORBIDDEN_DATA = new CreateUserResponseForbiddenExistData(EXPECTED_SUCCESS, EXPECTED_MESSAGE);

    public static final ResponseSpecification RESPONSE_SPEC = new ResponseSpecBuilder()
            .expectStatusCode(EXPECTED_CODE)
            .expectStatusLine(EXPECTED_STATUS_LINE)
            .expectBody(equalTo(new Gson().toJson(FORBIDDEN_DATA)))
            .build();

}
