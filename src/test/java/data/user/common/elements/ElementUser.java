package data.user.common.elements;

public class ElementUser {

    private String email;
    private String name;

    public ElementUser(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public ElementUser() {
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
