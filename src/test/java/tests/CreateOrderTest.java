package tests;

import data.ingredients.request.CommonGetIngredientsRequest;
import data.ingredients.request.GetIngredientsRequest;
import data.ingredients.response.success.GetIngredientsResponseSuccess;
import data.ingredients.response.success.GetIngredientsResponseSuccessData;
import data.order.request.CommonCreateOrderRequest;
import data.order.request.CreateOrderData;
import data.order.request.CreateOrderRequest;
import data.order.response.success.CreateOrderResponseSuccess;
import data.order.response.success.CreateOrderResponseSuccessData;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;

public class CreateOrderTest {

    CreateOrderData createOrderData;

    @Test
    public void getIngredients() {

        GetIngredientsRequest getIngredientsRequest = new GetIngredientsRequest();
        Response response = getIngredientsRequest.fetchResponse(GetIngredientsResponseSuccess.RESPONSE_SPEC);

        GetIngredientsResponseSuccessData getIngredientsResponseSuccessData = (GetIngredientsResponseSuccessData) CommonGetIngredientsRequest.extractResponseToObject(response, GetIngredientsResponseSuccessData.class);

        int n = 5;
        ArrayList<String> ingredients = new ArrayList<>();
        int size = (int) (Math.random() * getIngredientsResponseSuccessData.getData().size());

        for (int i = 0; i < n; i++) {
            ingredients.add(getIngredientsResponseSuccessData.getData().get(size).get_id());
        }

        CreateOrderData createOrderData = new CreateOrderData(ingredients);

        CreateOrderRequest createOrderRequest = new CreateOrderRequest(createOrderData);

        Response response1 = createOrderRequest.fetchResponse(CreateOrderResponseSuccess.RESPONSE_SPEC);
        CreateOrderResponseSuccessData createOrderResponseSuccessData = (CreateOrderResponseSuccessData) CommonCreateOrderRequest.extractResponseToObject(response1, CreateOrderResponseSuccessData.class);
        //
        System.out.println(createOrderResponseSuccessData.getOrder().getNumber());
    }

}
