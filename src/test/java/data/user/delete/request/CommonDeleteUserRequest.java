package data.user.delete.request;

import config.Config;
import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class CommonDeleteUserRequest {

    public static RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri(Config.getBaseURI())
            .build();

    @Step("Check Response Specification")
    public static void checkResponseSpecs(Response response, ResponseSpecification responseSpecification) {
        response.then().spec(responseSpecification);
    }

    @Step("Cast response to Class<T> and return Object")
    public static <T> Object extractResponseToObject(Response response, Class<T> anyClass) {
        return response.body().as(anyClass);
    }

}
