package tests;

import data.ingredients.request.CommonGetIngredientsRequest;
import data.ingredients.request.GetIngredientsRequest;
import data.ingredients.response.success.GetIngredientsResponseSuccess;
import data.ingredients.response.success.GetIngredientsResponseSuccessData;
import data.order.request.CommonCreateOrderRequest;
import data.order.request.CreateOrderData;
import data.order.request.CreateOrderRequest;
import data.order.response.success.nonauthorized.CreateOrderNonAuthorizedResponseSuccess;
import data.order.response.success.nonauthorized.CreateOrderNonAuthorizedResponseSuccessData;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.*;

public class CreateNonAuthorizedOrderTest {

    GetIngredientsResponseSuccessData getIngredientsResponseSuccessData;
    ArrayList<String> ingredients;
    private final int countOfIngredients = 6;

    private ArrayList<String> prepareListOfIngredients(int count) {

        // запрашиваем доступные ингредиенты
        GetIngredientsRequest getIngredientsRequest = new GetIngredientsRequest();
        Response response = getIngredientsRequest.fetchResponse(GetIngredientsResponseSuccess.RESPONSE_SPEC);
        getIngredientsResponseSuccessData = (GetIngredientsResponseSuccessData) CommonGetIngredientsRequest.extractResponseToObject(response, GetIngredientsResponseSuccessData.class);

        // наполняем список случайными ингредиентами
        ArrayList<String> ingredients = new ArrayList<>();
        int listSize = getIngredientsResponseSuccessData.getData().size();

        for (int i = 0; i < count; i++) {
            ingredients.add(getIngredientsResponseSuccessData.getData().get((int) (Math.random() * (listSize - 1))).get_id());
        }

        return ingredients;

    }

    @Before
    public void setUp() {

        ingredients = prepareListOfIngredients(countOfIngredients);

    }

    @Test
    public void getIngredients() {

        CreateOrderData createOrderData = new CreateOrderData(ingredients);

        CreateOrderRequest createOrderRequest = new CreateOrderRequest(createOrderData);

        Response response = createOrderRequest.fetchResponse(CreateOrderNonAuthorizedResponseSuccess.RESPONSE_SPEC);
        CreateOrderNonAuthorizedResponseSuccessData createOrderNonAuthorizedResponseSuccessData = (CreateOrderNonAuthorizedResponseSuccessData) CommonCreateOrderRequest.extractResponseToObject(response, CreateOrderNonAuthorizedResponseSuccessData.class);

        assertThat("Received number of Order is null", createOrderNonAuthorizedResponseSuccessData.getOrder().getNumber(), notNullValue());

    }

}
