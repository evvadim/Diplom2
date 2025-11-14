package data.order.request;

import common.http.CheckAndExtractResponseDataAsClass;
import config.Config;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class CommonCreateOrderRequest extends CheckAndExtractResponseDataAsClass {

    public static RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri(Config.getBaseURI())
            .setContentType(ContentType.JSON)
            .build();

}
