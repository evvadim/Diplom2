package common.http;

import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

public abstract class FetchResponse {

    protected abstract Response requestAndCheckResponseSpec(ResponseSpecification specification);

    public Response fetchResponse() {
        return requestAndCheckResponseSpec(null);
    }

    public Response fetchResponse(ResponseSpecification specification) {
        return requestAndCheckResponseSpec(specification);
    }

}
