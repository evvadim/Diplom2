package data.user.login.response.unauthorized;

import com.google.gson.Gson;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.CoreMatchers.equalTo;

public class LoginUserResponseUnauthorized {

    private static final Integer EXPECTED_CODE = 401;
    private static final String EXPECTED_STATUS_LINE = "HTTP/1.1 " + EXPECTED_CODE + " Unauthorized";
    private static final Boolean EXPECTED_SUCCESS = false;
    private static final String EXPECTED_MESSAGE = "email or password are incorrect";
    private static final LoginUserResponseUnauthorizedData FORBIDDEN_DATA = new LoginUserResponseUnauthorizedData(EXPECTED_SUCCESS, EXPECTED_MESSAGE);

    public static final ResponseSpecification RESPONSE_SPEC = new ResponseSpecBuilder()
            .expectStatusCode(EXPECTED_CODE)
            .expectStatusLine(EXPECTED_STATUS_LINE)
            .expectBody(equalTo(new Gson().toJson(FORBIDDEN_DATA)))
            .build();

}
