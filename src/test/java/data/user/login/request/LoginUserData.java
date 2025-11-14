package data.user.login.request;

import data.user.create.request.CreateUserData;

public class LoginUserData {

    private final String email;
    private final String password;
    private CreateUserData createUserData;

    public LoginUserData(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public LoginUserData(CreateUserData createUserData) {
        this.email = createUserData.getEmail();
        this.password = createUserData.getPassword();
    }

}
