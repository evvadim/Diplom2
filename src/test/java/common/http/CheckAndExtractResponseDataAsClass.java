package common.http;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

public class CheckAndExtractResponseDataAsClass {

    @Step("Check Response Specification")
    public static void checkResponseSpecs(Response response, ResponseSpecification responseSpecification) {
        response.then().spec(responseSpecification);
    }

    @Step("Cast response to Class<T> and return Object")
    public static <T> Object extractResponseToObject(Response response, Class<T> anyClass) {
        return response.body().as(anyClass);
    }

}
