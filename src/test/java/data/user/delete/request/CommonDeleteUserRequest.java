package data.user.delete.request;

import config.Config;
import data.user.common.ACommonRequest;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class CommonDeleteUserRequest extends ACommonRequest {

    public static RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri(Config.getBaseURI())
            .build();

}
