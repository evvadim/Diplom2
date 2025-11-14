package tests;

import data.order.request.CommonCreateOrderRequest;
import data.order.request.CreateOrderData;
import data.order.request.CreateOrderRequest;
import data.order.response.success.nonauthorized.CreateOrderNonAuthorizedResponseSuccess;
import data.order.response.success.nonauthorized.CreateOrderNonAuthorizedResponseSuccessData;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import tests.helpers.PrepareListOfIngredients;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.*;

public class CreateNonAuthorizedOrderTest {

    ArrayList<String> ingredients;
    private final int countOfIngredients = 6;

    @Before
    public void setUp() {

        ingredients = new PrepareListOfIngredients(countOfIngredients).getIngredients();

    }

    @Test
    @DisplayName("Testing Create Order by Non-Authorized User")
    public void createOrderNonAuthorizedUser() {

        CreateOrderData createOrderData = new CreateOrderData(ingredients);
        CreateOrderRequest createOrderRequest = new CreateOrderRequest(createOrderData);

        Response response = createOrderRequest.fetchResponse(CreateOrderNonAuthorizedResponseSuccess.RESPONSE_SPEC);
        CreateOrderNonAuthorizedResponseSuccessData createOrderNonAuthorizedResponseSuccessData = (CreateOrderNonAuthorizedResponseSuccessData) CommonCreateOrderRequest.extractResponseToObject(response, CreateOrderNonAuthorizedResponseSuccessData.class);

        assertThat("Received number of Order is null", createOrderNonAuthorizedResponseSuccessData.getOrder().getNumber(), notNullValue());

    }

}
