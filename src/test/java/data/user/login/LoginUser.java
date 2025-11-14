package data.user.login;

import data.user.create.request.CreateUserData;

public class LoginUser {

    private final String email;
    private final String password;
    private CreateUserData createUserData;

    public LoginUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public LoginUser(CreateUserData createUserData) {
        this.email = createUserData.getEmail();
        this.password = createUserData.getPassword();
    }

}
