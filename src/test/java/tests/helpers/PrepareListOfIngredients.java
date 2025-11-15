package tests.helpers;

import data.ingredients.request.CommonGetIngredientsRequest;
import data.ingredients.request.GetIngredientsRequest;
import data.ingredients.response.success.GetIngredientsResponseSuccess;
import data.ingredients.response.success.GetIngredientsResponseSuccessData;
import io.restassured.response.Response;

import java.util.ArrayList;

public class PrepareListOfIngredients {

    private final ArrayList<String> ingredients;

    public PrepareListOfIngredients(int count) {

        if (count != 0) {

            // запрашиваем доступные ингредиенты
            GetIngredientsRequest getIngredientsRequest = new GetIngredientsRequest();
            Response response = getIngredientsRequest.fetchResponse(GetIngredientsResponseSuccess.RESPONSE_SPEC);
            GetIngredientsResponseSuccessData getIngredientsResponseSuccessData = (GetIngredientsResponseSuccessData) CommonGetIngredientsRequest.extractResponseToObject(response, GetIngredientsResponseSuccessData.class);

            // наполняем список случайными ингредиентами
            ingredients = new ArrayList<>();
            int listSize = getIngredientsResponseSuccessData.getData().size();

            for (int i = 0; i < count; i++) {
                ingredients.add(getIngredientsResponseSuccessData.getData().get((int) (Math.random() * (listSize - 1))).get_id());

            }
        } else {
            ingredients = null;
        }
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

}
