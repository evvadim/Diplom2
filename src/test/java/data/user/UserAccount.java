package data.user;

import data.user.create.request.CreateUserData;

public class UserAccount {

    private String email;
    private String password;
    private String name;
    private CreateUserData createUserData;

    public UserAccount(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public UserAccount() {
    }

    public UserAccount(CreateUserData createUserData) {
        this.createUserData = createUserData;
        this.email = createUserData.getEmail();
        this.password = createUserData.getPassword();
        this.name = createUserData.getName();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CreateUserData getCreateUserData() {
        return createUserData;
    }

    public void setCreateUserData(CreateUserData createUserData) {
        this.createUserData = createUserData;
    }

}
