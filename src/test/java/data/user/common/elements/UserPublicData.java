package data.user.common.elements;

public class UserPublicData {

    private String email;
    private String name;

    public UserPublicData(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public UserPublicData() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
