package tests;

import config.Config;
import data.order.request.CommonCreateOrderRequest;
import data.order.request.CreateOrderData;
import data.order.request.CreateOrderRequest;
import data.order.response.badrequest.CreateOrderResponseBadRequest;
import data.order.response.ise.CreateOrderResponseInternalServerError;
import data.order.response.success.CreateOrderResponseSuccess;
import data.order.response.success.CreateOrderResponseSuccessData;
import data.user.create.request.CommonCreateUserRequest;
import data.user.create.request.CreateUserData;
import data.user.create.request.CreateUserRequest;
import data.user.create.response.success.CreateUserResponseSuccessData;
import data.user.delete.request.DeleteUserRequest;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import tests.helpers.PrepareListOfIngredients;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.*;

@RunWith(Parameterized.class)
public class CreateOrderParamTest {

    ArrayList<String> ingredients;
    CreateUserResponseSuccessData createUserResponseSuccessData;

    // переменные для параметризации
    private final Boolean isUserAuthorized;
    private final Boolean isHashValid;
    private final int countOfIngredients;

    public CreateOrderParamTest(Boolean isUserAuthorized, Boolean isHashValid, int countOfIngredients, String logMessage) {
        this.isUserAuthorized = isUserAuthorized;
        this.isHashValid = isHashValid;
        this.countOfIngredients = countOfIngredients;
    }

    @Parameterized.Parameters(name = "Testing Data for Create Order Endpoint with auth/hash variations. Set \"{3}\".")
    public static Object[][] getDataConfig() {
            return new Object[][] {
                    {true, true, 6, "Auth, valid hash, 6 ingredients"},
                    {true, true, 0, "Auth, valid hash, no ingredients"},
                    {false, true, 6, "non-Auth, valid hash, 6 ingredients"},
                    {false, true, 0, "non-Auth, valid hash, no ingredients"},
                    {true, false, 6, "Auth, wrong hash, 6 ingredients"},
                    {false, false, 6, "non-Auth, wrong hash, 6 ingredients"},
            };
    }

    @Before
    public void setUp() {

        ingredients = new PrepareListOfIngredients(countOfIngredients).getIngredients();

        if (!isHashValid) {
            int n = (int) (Math.random() * (countOfIngredients - 1));
            ingredients.set(n, shakeString(ingredients.get(n)));
        }

        if (isUserAuthorized) {

            CreateUserData createUserData = new CreateUserData(Config.getEmail(), Config.getUserPassword(), Config.getUserName());
            CreateUserRequest createUserRequest = new CreateUserRequest(createUserData);
            Response response = createUserRequest.fetchResponse(CreateOrderResponseSuccess.RESPONSE_SPEC);
            createUserResponseSuccessData = (CreateUserResponseSuccessData) CommonCreateUserRequest.extractResponseToObject(response, CreateUserResponseSuccessData.class);

        }

    }

    @Test
    @DisplayName("Testing Create Order")
    public void createOrder() {

        CreateOrderData createOrderData = new CreateOrderData(ingredients);
        CreateOrderRequest createOrderRequest;

        if (isUserAuthorized) {
            createOrderRequest = new CreateOrderRequest(createOrderData, createUserResponseSuccessData.getAccessToken());
        } else {
            createOrderRequest = new CreateOrderRequest(createOrderData, "");
        }

        Response response;

        if (countOfIngredients == 0) {

            createOrderRequest.fetchResponse(CreateOrderResponseBadRequest.RESPONSE_SPEC);

        } else {

            if (!isHashValid) {
                createOrderRequest.fetchResponse(CreateOrderResponseInternalServerError.RESPONSE_SPEC);
            } else {

                response = createOrderRequest.fetchResponse(CreateOrderResponseSuccess.RESPONSE_SPEC);
                CreateOrderResponseSuccessData createOrderResponseSuccessData = (CreateOrderResponseSuccessData) CommonCreateOrderRequest.extractResponseToObject(response, CreateOrderResponseSuccessData.class);
                assertThat("Received number of Order is null", createOrderResponseSuccessData.getOrder().getNumber(), notNullValue());

                if (isUserAuthorized) {
                    assertThat("Received owner of Order is null", createOrderResponseSuccessData.getOrder().getOwner(), notNullValue());
                }

            }
        }
    }

    @After
    public void tearDown() {

        if (isUserAuthorized) {
            new DeleteUserRequest(createUserResponseSuccessData.getAccessToken()).fetchResponse();
        }

    }

    public String shakeString(String string) {

        int length = string.length();
        return String.format("%s%s", string.substring(length / 2), string.substring(0, length / 2 - 1));

    }

}
