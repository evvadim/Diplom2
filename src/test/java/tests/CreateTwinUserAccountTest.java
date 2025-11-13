package tests;

import data.user.create.request.CreateUserData;
import data.user.create.request.CreateUserRequest;
import data.user.create.response.forbidden.exist.CreateUserResponseForbiddenExist;
import data.user.create.response.success.CreateUserResponseSuccess;
import data.user.create.response.success.CreateUserResponseSuccessData;
import data.user.delete.request.DeleteUserRequest;
import data.user.delete.response.DeleteUserResponseSuccess;
import io.qameta.allure.junit4.DisplayName;
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

        // создаём оригинальную учётную запись
        createUserRequestOrigin = new CreateUserRequest(createUserDataOrigin);

        // проверяем успешность создания
        createUserResponseSuccessDataOrigin = createUserRequestOrigin.createUserRequest(CreateUserResponseSuccess.RESPONSE_SPEC);

    }

    @Test
    @DisplayName("Testing Create User Endpoint using Twin email.")
    public void createUserExpectedTrue() {

        // пытаемся создать учётную запись с таким же значением email
        CreateUserRequest createUserRequestTwin = new CreateUserRequest(createUserDataTwin);

        // ожидаем получить код 403, статус `Forbidden` и сообщение `User already exists`
        // в случае ошибки удаляем близнеца
        try {
            createUserResponseSuccessDataTwin = createUserRequestTwin.createUserRequest(CreateUserResponseForbiddenExist.RESPONSE_SPEC);
        } catch (Exception e) {
            new DeleteUserRequest(createUserResponseSuccessDataTwin.getAccessToken()).deleteUserRequest();
        }

    }

    @After
    public void tearDown() {
        // удаляем пользователя
        new DeleteUserRequest(createUserResponseSuccessDataOrigin.getAccessToken()).deleteUserRequest(DeleteUserResponseSuccess.RESPONSE_SPEC);
    }

}
