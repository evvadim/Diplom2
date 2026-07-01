package tests;

import data.user.create.request.CommonCreateUserRequest;
import data.user.create.request.CreateUserData;
import data.user.create.request.CreateUserRequest;
import data.user.create.response.forbidden.exist.CreateUserResponseForbiddenExist;
import data.user.create.response.success.CreateUserResponseSuccessData;
import data.user.delete.request.DeleteUserRequest;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static config.Config.*;

public class CreateTwinUserAccountTest {

    // объект с данными учётной записи
    CreateUserData createUserDataOrigin = new CreateUserData(getEmail(), getUserPassword(), getUserName());
    CreateUserData createUserDataTwin = new CreateUserData(getEmail(), getAnotherUserPassword(), getAnotherUserName());

    // объект запроса оригинальной учётной записи и близнеца
    CreateUserRequest createUserRequestOrigin;
    CreateUserRequest createUserRequestTwin;

    // объект успешного ответа оригинальной учётной записи и близнеца
    CreateUserResponseSuccessData createUserResponseSuccessDataOrigin;
    CreateUserResponseSuccessData createUserResponseSuccessDataTwin;

    @Before
    public void setUp() {

        // создаём объект запроса оригинальной учётной записи
        createUserRequestOrigin = new CreateUserRequest(createUserDataOrigin);

        // проверяем успешность создания
        Response response = createUserRequestOrigin.fetchResponse();
        // извлекаем из ответа объект с данными
        createUserResponseSuccessDataOrigin = (CreateUserResponseSuccessData) CommonCreateUserRequest.extractResponseToObject(response, CreateUserResponseSuccessData.class);

    }

    @Test
    @DisplayName("Testing Create Twin Users using same email")
    public void createUserExpectedTrue() {

        // создаём объект запроса учётной записи близнеца
        createUserRequestTwin = new CreateUserRequest(createUserDataTwin);

        // ожидаем получить код 403, статус `Forbidden` и сообщение `User already exists`
        Response response = createUserRequestTwin.fetchResponse(CreateUserResponseForbiddenExist.RESPONSE_SPEC);
        createUserResponseSuccessDataTwin = (CreateUserResponseSuccessData) CommonCreateUserRequest.extractResponseToObject(response, CreateUserResponseSuccessData.class);

    }

    @After
    public void tearDown() {
        // удаляем пользователя
        new DeleteUserRequest(createUserResponseSuccessDataOrigin.getAccessToken()).fetchResponse();
    }

}
