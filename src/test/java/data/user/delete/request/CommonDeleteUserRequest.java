package data.user.delete.request;

import config.Config;
import common.http.CheckAndExtractResponseDataAsClass;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class CommonDeleteUserRequest extends CheckAndExtractResponseDataAsClass {

    public static RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri(Config.getBaseURI())
            .build();

}
