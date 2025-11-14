package tests;

import data.order.request.CommonCreateOrderRequest;
import data.order.request.CreateOrderData;
import data.order.request.CreateOrderRequest;
import data.order.response.success.CreateOrderResponseSuccess;
import data.order.response.success.CreateOrderResponseSuccessData;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import tests.helpers.PrepareListOfIngredients;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.*;

public class CreateOrderParamTest {

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

        Response response = createOrderRequest.fetchResponse(CreateOrderResponseSuccess.RESPONSE_SPEC);
        CreateOrderResponseSuccessData createOrderResponseSuccessData = (CreateOrderResponseSuccessData) CommonCreateOrderRequest.extractResponseToObject(response, CreateOrderResponseSuccessData.class);

        assertThat("Received number of Order is null", createOrderResponseSuccessData.getOrder().getNumber(), notNullValue());

    }

}
